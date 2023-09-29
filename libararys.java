import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private intbookId;
    private booleanisAvailable;
    private Date issueDate;
    private Date returnDate;

    public Book(String title, String author, intbookId) {
this.title = title;
this.author = author;
this.bookId = bookId;
this.isAvailable = true;
this.issueDate = null;
this.returnDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public intgetBookId() {
        return bookId;
    }

    public booleanisAvailable() {
        return isAvailable;
    }

    public void issueBook() {
        if (isAvailable) {
isAvailable = false;
issueDate = new Date();
            // Set the return date, e.g., 15 days from the issue date
            long returnTime = issueDate.getTime() + 15 * 24 * 60 * 60 * 1000L;
returnDate = new Date(returnTime);
        } else {
System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
isAvailable = true;
issueDate = null;
returnDate = null;
        } else {
System.out.println("Book is not issued yet.");
        }
    }

    @Override
    public String toString() {
SimpleDateFormatdateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Book ID: " + bookId +
               "\nTitle: " + title +
               "\nAuthor: " + author +
               "\nAvailable: " + (isAvailable ? "Yes" : "No") +
               "\nIssue Date: " + (issueDate != null ? dateFormat.format(issueDate) : "Not issued") +
               "\nReturn Date: " + (returnDate != null ? dateFormat.format(returnDate) : "Not issued") + "\n";
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, intbookId) {
        Book book = new Book(title, author, bookId);
books.add(book);
System.out.println("Book added successfully.");
    }

    public void searchBook(intbookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
System.out.println("Book found:\n" + book);
                return;
            }
        }
System.out.println("Book not found.");
    }

    public void issueBook(intbookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
book.issueBook();
System.out.println("Book issued successfully.");
                return;
            }
        }
System.out.println("Book not found or already issued.");
    }

    public void returnBook(intbookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
book.returnBook();
System.out.println("Book returned successfully.");
                return;
            }
        }
System.out.println("Book not found or not issued.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
System.out.println("Library Management System");
System.out.println("1. Add Book");
System.out.println("2. Search Book");
System.out.println("3. Issue Book");
System.out.println("4. Return Book");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");

int choice = scanner.nextInt();
scanner.nextLine(); 

            switch (choice) {
                case 1:
System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
System.out.print("Enter author: ");
                    String author = scanner.nextLine();
System.out.print("Enter book ID: ");
intbookId = scanner.nextInt();
library.addBook(title, author, bookId);
                    break;
                case 2:
System.out.print("Enter book ID to search: ");
intsearchId = scanner.nextInt();
library.searchBook(searchId);
                    break;
                case 3:
System.out.print("Enter book ID to issue: ");
intissueId = scanner.nextInt();
library.issueBook(issueId);
                    break;
                case 4:
System.out.print("Enter book ID to return: ");
intreturnId = scanner.nextInt();
library.returnBook(returnId);
                    break;
                case 5:
scanner.close();
System.out.println("Exiting the Library Management System.");
System.exit(0);
                default:
System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

