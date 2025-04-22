package src.Entity;

public interface User {
    String getName();
    String getUserId();
    int getBorrowedBookCount();

    void borrowBook();
    void returnBook();
}
