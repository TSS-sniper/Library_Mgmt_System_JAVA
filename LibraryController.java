package extra.Library_Management_System.Contoller;

import extra.Library_Management_System.Service.*;
import java.util.*;

public class LibraryController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService service = new LibraryService();

        System.out.println("Enter User ID:");
        String userId = scanner.nextLine();

        while (true) {
            System.out.println("Choose operation: 1) Issue Book 2) Return Book 3) Check Availability 4) Show History 5) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Book ID to issue:");
                    String issueId = scanner.nextLine();
                    service.issueBook(issueId, userId);
                    break;
                case 2:
                    System.out.println("Enter Book ID to return:");
                    String returnId = scanner.nextLine();
                    service.returnBook(returnId, userId);
                    break;
                case 3:
                    System.out.println("Enter Book ID to check:");
                    String checkId = scanner.nextLine();
                    service.checkAvailability(checkId);
                    break;
                case 4:
                    service.showHistory(userId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
        
    }
}