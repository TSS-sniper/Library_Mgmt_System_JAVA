package Controller;

import Entity.*;
import Service.*;
import java.util.*;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("\n1. Student Portal\n2. Librarian Portal\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> studentMenu(sc, service);
                case 2 -> librarianMenu(service, sc);
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice...");
            }
        }
    }

    private static void studentMenu(Scanner sc, LibraryService service) {
        System.out.println("\n1. Register as new Student\n2. Login as an existing Student\n3. Back to Main Menu");
        int opt = sc.nextInt();
        switch (opt) {
            case 1 -> {
                System.out.println("Enter Student ID: ");
                String sid = sc.next();
                if (service.isStudentExists(sid)) {
                    System.out.print("Student already exists, Please Login.");
                } else {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Email Address: ");
                    String email = sc.next();
                    System.out.print("Enter Phone: ");
                    String phone = sc.next();
                    Student student = new Student(sid, name, email, phone);
                    service.registerStudent(student);
                }
            }
            case 2 -> {
                System.out.println("Enter student ID:");
                String sid = sc.next();
                if (!service.isStudentExists(sid)) {
                    System.out.print("Student does not exists, Please register.");
                } else {
                    studentMenu(service, sc, sid);
                }
            }
            case 3 -> {
                return;
            }
            default -> System.out.println("Invalid choice...");
        }
    }

    private static void librarianMenu(LibraryService service, Scanner sc) {
        while (true) {
            System.out.println(
                    "\nLibrarian Menu:\n1. Add Book\n2. Remove Book\n3. Issue Book\n4. Approve Library Card\n5. View All Books\n6. View All Registered Students\n7. Remove Student\n8. Return Book\n9. Back");
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> {
                    System.out.print("Enter Book ID : ");
                    String bid = sc.next();
                    System.out.print("Enter Title : ");
                    String title = sc.next();
                    System.out.print("Enter Author : ");
                    String author = sc.next();
                    System.out.print("Enter Rating ");
                    Double rating = sc.nextDouble();
                    System.out.print("Enter Price : ");
                    Double price = sc.nextDouble();
                    service.addBook(new Book(bid, title, author, price, rating));
                }
                case 2 -> {
                    System.out.print("Enter Book ID to remove : ");
                    service.removeBook(sc.next());
                }
                case 3 -> {
                    System.out.print("Enter Book ID and Student ID : ");
                    service.issueBook(sc.next(), sc.next());
                }
                case 4 -> {
                    System.out.print("Enter Student ID : ");
                    service.approveLibraryCard(sc.next());
                }
                case 5 -> service.viewBooks();
                case 6 -> service.viewUsers();
                case 7 -> {
                    System.out.print("Enter Student ID to remove : ");
                    service.removeUser(sc.next());
                }
                case 8 -> {
                    System.out.print("Enter Book ID to return : ");
                    service.returnBook(sc.next());
                }
                case 9 -> {
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void studentMenu(LibraryService service, Scanner sc, String sid) {
        while (true) {
            System.out.println("\nStudent Menu:\n1. View Profile\n2. Request Library Card\n3. View Books\n4. Back");
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> service.viewStudentProfile(sid);
                case 2 -> service.requestLibraryCard(sid);
                case 3 -> service.viewBooksMainMenu();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
