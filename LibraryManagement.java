import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title, author, bookId;
    
    Book(String title, String author, String bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }
}

class Member {
    String name, memberId;
    
    Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    
    void addBook(String title, String author, String bookId) {
        books.add(new Book(title, author, bookId));
        System.out.println("Book added successfully.");
    }
    
    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\nList of Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.bookId + ", Title: " + book.title + ", Author: " + book.author);
        }
    }
    
    void updateBook(String bookId, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.bookId.equals(bookId)) {
                book.title = newTitle;
                book.author = newAuthor;
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
    
    void deleteBook(String bookId) {
        books.removeIf(book -> book.bookId.equals(bookId));
        System.out.println("Book deleted successfully.");
    }
    
    void addMember(String name, String memberId) {
        members.add(new Member(name, memberId));
        System.out.println("Member added successfully.");
    }
    
    void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }
        System.out.println("\nList of Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.memberId + ", Name: " + member.name);
        }
    }
    
    void updateMember(String memberId, String newName) {
        for (Member member : members) {
            if (member.memberId.equals(memberId)) {
                member.name = newName;
                System.out.println("Member updated successfully.");
                return;
            }
        }
        System.out.println("Member not found.");
    }
    
    void deleteMember(String memberId) {
        members.removeIf(member -> member.memberId.equals(memberId));
        System.out.println("Member deleted successfully.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    library.addBook(title, author, bookId);
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to update: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    library.updateBook(bookId, newTitle, newAuthor);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    bookId = scanner.nextLine();
                    library.deleteBook(bookId);
                    break;
                case 5:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    library.addMember(name, memberId);
                    break;
                case 6:
                    library.viewMembers();
                    break;
                case 7:
                    System.out.print("Enter member ID to update: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    library.updateMember(memberId, newName);
                    break;
                case 8:
                    System.out.print("Enter member ID to delete: ");
                    memberId = scanner.nextLine();
                    library.deleteMember(memberId);
                    break;
                case 9:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
