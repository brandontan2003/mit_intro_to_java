package assignments.assignment_4;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
    String address;
    List<Book> books = new ArrayList<>();

    // Creates a new Library
    public Library(String address) {
        // Implement this method
        this.address = address;
    }

    public void addBook(Book bookTitle) {
        Book newBook = new Book(bookTitle.getTitle());
        this.books.add(newBook);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void borrowBook(String bookTitle) {
        if (books.size() == 0 || books.stream().noneMatch(book -> book.getTitle().equals(bookTitle))) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
        books.forEach(book -> {
            if (book.getTitle().equals(bookTitle)) {
                if (book.isBorrowed()) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    book.borrowed();
                    System.out.printf("You successfully borrowed %s%n", book.title);
                }
            }
        });
    }

    public void returnBook(String bookTitle) {
        if (books.size() == 0 || books.stream().noneMatch(book -> book.getTitle().equals(bookTitle))) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
        books.forEach(book -> {
            if (book.getTitle().equals(bookTitle)) {
                if (book.isBorrowed()) {
                    book.returned();
                    System.out.printf("You successfully returned %s%n", book.title);
                }
            }
        });
    }

    public void printAvailableBooks() {
        if (books.size() == 0) {
            System.out.println("No book in catalog");
        }
        books.forEach(book -> {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
            }
        });
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}