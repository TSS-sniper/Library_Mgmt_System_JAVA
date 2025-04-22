package src.Entity;

public interface Book {
    public void BookIssueHistory(String Username);
    String getTitle();
    String getAuthor();
    String getISBN();
    boolean isAvailable();

    void setAvailable(boolean status);
}
