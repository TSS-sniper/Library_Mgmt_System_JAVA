package Service;

import Entity.*;
import Repo.*;
import java.util.*;

import Comparator.PriceComparator;
import Comparator.RatingComparator;
import Comparator.TitleComparator;

public class LibraryService {
    private StudentRepository studentRepo = new StudentRepository();
    private BookRepository bookRepo = new BookRepository();
    private LibraryCardRepository cardRepo = new LibraryCardRepository();
    private IssueHistoryRepository historyRepo = new IssueHistoryRepository();
    private Map<String, LibraryCardRequest> requests = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void registerStudent(Student student) {
        studentRepo.addStudent(student);
        System.out.println("Student registered successfully.");
    }

    public boolean isStudentExists(String sid) {
        return studentRepo.exists(sid);
    }

    public void addBook(Book book) {
        bookRepo.addBook(book);
        System.out.println("Book added.");
    }

    public void removeBook(String id) {
        if(!bookRepo.exists(id)) {
            System.out.println("Book not present in the Library.");
            return;
        }
        bookRepo.removeBook(id);
        System.out.println("Book removed.");
    }

    public void viewBooksMainMenu() {
        if (bookRepo.size() == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Enter your choice:\n1. View all books\n2. Filter books\n3. Back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> viewBooks();
            case 2 -> viewBooksByFilter();
            case 3 -> {
                return;
            }
            default -> {
                System.out.println("Invalid choice...");
            }
        }
    }

    public void viewUsers() {
        if(studentRepo.size() == 0) {
            System.out.println("No students registered");
            return;
        }
        System.out.println("All registered Students are : ");
        for(Student student : studentRepo.getAllStudents()) {
            System.out.println(student);
        }
    }

    public void removeUser(String id) {
        if(!studentRepo.exists(id)) {
            System.out.println("Student not resistered in the Library.");
            return;
        }
        studentRepo.removeStudent(id);
        System.out.println("Student removed.");
    }

    public void viewBooks() {
        if (bookRepo.size() == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("All books are :");
        for (Book book : bookRepo.getAllBooks()) {
            System.out.println(book);
        }
    }

    public void viewBooksByFilter() {
        System.out.println(
                "Welcome to the sorting menu\n1. Sort by Rating\n2. Sort by Price\n3. Sort by Title\n4. Sort by Rating > Price > Title\n5. Back");
        int choice = sc.nextInt();
        List<Book> books = new ArrayList<>(bookRepo.getAllBooks());
        switch (choice) {
            case 1 -> books.sort(new RatingComparator());
            case 2 -> books.sort(new PriceComparator());
            case 3 -> books.sort(new TitleComparator());
            case 4 -> books.sort(
                    new RatingComparator().thenComparing(new PriceComparator()).thenComparing(new TitleComparator()));
            case 5 -> {
                return;
            }
            default -> {
                System.out.println("Invalid choice...");
            }
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String bookId, String studentId) {
        Book book = bookRepo.getBook(bookId);
        Student student = studentRepo.getStudent(studentId);
        if (book != null && student != null && student.hasLibraryCard() && !book.isIssued()) {
            book.setIssued(true);
            historyRepo.log(studentId, bookId);
            System.out.println("Book issued successfully.");
        } else {
            if(book == null) {
                System.out.println("Book not found.");
            }
            if(student == null) {
                System.out.println("Student not found.");
            }
            if(student == null || book == null) {
                return;
            }
            if(!student.hasLibraryCard()) {
                System.out.println("Student does not have a library card.");
            }
            if(book.isIssued()) {
                System.out.println("Book already issued.");
            }
        }

    }

    public void requestLibraryCard(String studentId) {
        Student student = studentRepo.getStudent(studentId);
        if (student != null && !student.hasLibraryCard()) {
            requests.put(studentId, new LibraryCardRequest(studentId));
            System.out.println("Library card request submitted.");
        } else {
            System.out.println("Already has card or student not found.");
        }
    }

    public void approveLibraryCard(String studentId) {
        LibraryCardRequest req = requests.get(studentId);
        Student student = studentRepo.getStudent(studentId);
        if (req != null && student != null && !req.isApproved()) {
            LibraryCard card = new LibraryCard("LC" + studentId, studentId);
            cardRepo.addCard(card);
            student.setLibraryCard(true);
            req.setApproved(true);
            System.out.println("Library card issued: " + card);
        } else {
            System.out.println("Request not found or already approved.");
        }
    }

    public void viewStudentProfile(String studentId) {
        Student student = studentRepo.getStudent(studentId);
        if (student != null) {
            System.out.println(student);
            System.out.println("History: " + historyRepo.getHistory(studentId));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void returnBook(String bookId) {
        Book book = bookRepo.getBook(bookId);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid book ID or book was not issued.");
        }
    }

}
