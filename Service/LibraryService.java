package src.Service;


import src.Entity.Book;
import src.Entity.Library;
import java.util.ArrayList;
import java.util.List;

public class LibraryService implements Library {
    private List<Book> books;

    public LibraryService() {
        books = new ArrayList<>();
    }

    @Override
    public void addBookToDatabase(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void removeBookFromDatabase(String isbn) {
        books.removeIf(book -> book.getISBN().equals(isbn));
        System.out.println("Book removed with ISBN: " + isbn);
    }

    @Override
    public void BookRecord() {
        System.out.println("=== Library Book Records ===");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", ISBN: " + book.getISBN() +
                        ", Available: " + book.isAvailable());
            }
        }
    }

    // Optional: Expose the book list if needed
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}

