package Comparator;

import Entity.Book;
import java.util.Comparator;

public class RatingComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Double.compare(b2.getRating(), b1.getRating());
    }
}