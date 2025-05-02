package Entity;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private double price;
    private double rating;

    public Book(String bookId, String title, String author, double price, double rating) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.price = price;
        this.rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author + " rated " + rating + " priced at " + price
                + (isIssued ? " (Issued)" : " (Available)");
    }
}