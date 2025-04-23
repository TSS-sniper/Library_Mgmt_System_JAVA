package extra.Library_Management_System.Entity;

import java.util.*;

public class Book {
    public String title;
    public String bookId;
    public String author;
    public int pubYear;
    public boolean isAvailable;
    public List<String> issueHistory = new ArrayList<>();
}


