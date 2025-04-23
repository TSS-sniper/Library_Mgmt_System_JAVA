package extra.Library_Management_System.Service;

import extra.Library_Management_System.Entity.*;
import extra.Library_Management_System.Repo.*;
import java.util.*;

public class LibraryService {
    Library library = new Library();
    List<User> users = new ArrayList<>();

    public LibraryService() {
        for (String record : BookRepo.bookRecords) {
            String[] parts = record.split(" : ");
            Book book = new Book();
            book.title = parts[0];
            book.bookId = parts[1];
            book.author = parts[2];
            book.pubYear = Integer.parseInt(parts[3]);
            book.isAvailable = Boolean.parseBoolean(parts[4]);
            library.addBook(book);
        }

        for (String record : UserRepo.userRecords) {
            String[] parts = record.split(" : ");
            User user = new User();
            user.userName = parts[0];
            user.userId = parts[1];
            users.add(user);
        }
    }

    public void issueBook(String bookId, String userId) {
        for (Book book : library.books) {
            if (book.bookId.equals(bookId) && book.isAvailable) {
                book.isAvailable = false;
                book.issueHistory.add(userId);
                for (User user : users) {
                    if (user.userId.equals(userId)) {
                        user.addIssue(bookId);
                        System.out.println("Book issued successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Book not available or user not found.");
    }

    public void returnBook(String bookId, String userId) {
        for (Book book : library.books) {
            if (book.bookId.equals(bookId)) {
                book.isAvailable = true;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkAvailability(String bookId) {
        for (Book book : library.books) {
            if (book.bookId.equals(bookId)) {
                System.out.println("Available: " + book.isAvailable);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showHistory(String userId) {
        for (User user : users) {
            if (user.userId.equals(userId)) {
                System.out.println("History: " + user.getIssueHistory());
                return;
            }
        }
        System.out.println("User not found.");
    }
}
