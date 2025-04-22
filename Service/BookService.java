package src.Service;

import src.Entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService implements Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    // List to store usernames who issued the book
    private List<String> issueHistory;

    public BookService(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.issueHistory = new ArrayList<>();
    }

    @Override
    public void BookIssueHistory(String username) {
        issueHistory.add(username);
    }

    public List<String> getIssueHistory() {
        return new ArrayList<>(issueHistory);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean status) {
        this.available = status;
    }
}
