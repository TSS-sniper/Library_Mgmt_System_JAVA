package src.Entity;

public interface Library {
    void addBookToDatabase(Book book);
    void removeBookFromDatabase(String isbn);
    void BookRecord(); // Prints or returns all book records
}
