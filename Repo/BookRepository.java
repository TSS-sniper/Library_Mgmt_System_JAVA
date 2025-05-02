package Repo;

import Entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    {
        books.put("10001", new Book("10001", "The Alchemist", "Jitendar", 299.00, 4.8));
        books.put("10002", new Book("10002", "Harry Potter", "Mukesh", 699.99, 5.0));
        books.put("10003", new Book("10003", "Beauty and the Beast", "Tarun", 320.00, 4.4));
        books.put("10004", new Book("10004", "Titanic", "Manas", 280.00, 4.1));
        books.put("10005", new Book("10005", "Games of Thrones", "Tisha", 850.00, 4.9));
        books.put("10006", new Book("10006", "House of Dragons", "Vidushi", 760.00, 4.7));
        books.put("10007", new Book("10007", "The Chronicles of Narnia", "Nazeer", 540.00, 4.6));
        books.put("10008", new Book("10008", "How to train your Dragon", "Ayush", 300.00, 4.2));
        books.put("10009", new Book("10009", "Conjuoring", "Tushar", 270.00, 3.8));
        books.put("10010", new Book("10010", "Wall - E", "Govardhan", 310.00, 4.5));
        books.put("10011", new Book("10011", "The Devil", "Dixit", 260.00, 3.9));
        books.put("10012", new Book("10012", "Beauty without the Brain", "Devashruti", 220.00, 3.7));
        books.put("10013", new Book("10013", "Stranger Things", "Animesh", 420.00, 4.3));
        books.put("10014", new Book("10014", "AntGirl", "Aarya", 200.00, 3.6));
        books.put("10015", new Book("10015", "The Hulk", "Keshav", 500.00, 4.0));
        books.put("10016", new Book("10016", "Captain America Returns", "Sanjay", 600.00, 4.2));
        books.put("10017", new Book("10017", "Thor", "Ayush", 650.00, 4.4));
        books.put("10018", new Book("10018", "IronMan", "Garvesh", 700.00, 4.9));
        books.put("10019", new Book("10019", "The Grave of the Fireflies", "Rachit", 450.00, 4.1));
        books.put("10020", new Book("10020", "The Giants", "Aaditya", 330.00, 4.0));
        books.put("10021", new Book("10021", "Java 24", "Tarun", 550.00, 4.6));
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public int size() {
        return books.size();
    }

    public boolean exists(String id) {
        return books.containsKey(id);
    }

    public void removeBook(String id) {
        books.remove(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
