package extra.Library_Management_System.Entity;

import java.util.*;

	public class Library {
	    public List<Book> books = new ArrayList<>();

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public void removeBook(String bookId) {
	        books.removeIf(book -> book.bookId.equals(bookId));
	    }

	    public List<Book> bookRecord() {
	        return books;
	    }
	}
