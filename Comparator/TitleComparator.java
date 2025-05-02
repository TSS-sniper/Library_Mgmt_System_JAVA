package Comparator;

import Entity.Book;
import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareToIgnoreCase(b2.getTitle());
    }
}
