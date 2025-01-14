package libraryManagement.com;

import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private String category;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + "\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "Category: " + category + "\n" +
               "Issued: " + (isIssued ? "Yes" : "No");
    }
}

public class LibraryManagementSystem {
    private final List<Book> books = new ArrayList<>();
    private final Map<String, Integer> categoryCounters = new HashMap<>();

    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Book Category (Novels, Story Books, Engineering Books, General Knowledge): ");
        String category = scanner.nextLine();

        // Generate ID based on category
        int id = categoryCounters.getOrDefault(category, 0) + 1;
        categoryCounters.put(category, id);

        books.add(new Book(id, title, author, category));
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    public void displayBooksByCategory() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category to display books (Novels, Story Books, Engineering Books, General Knowledge): ");
        String category = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found in the category: " + category);
        }
    }

    public void issueBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isIssued()) {
                    System.out.println("Book is already issued.");
                } else {
                    book.setIssued(true);
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void returnBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isIssued()) {
                    System.out.println("Book is not issued.");
                } else {
                    book.setIssued(false);
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void searchBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book ID to search: ");
        int id = scanner.nextInt();

        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                System.out.println("Book deleted successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void deleteAllBooks() {
        books.clear();
        System.out.println("All books deleted successfully!");
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Display Books by Category");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Delete Book");
            System.out.println("8. Delete All Books");
            System.out.println("9. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addBook();
                    break;
                case 2:
                    system.displayBooks();
                    break;
                case 3:
                    system.displayBooksByCategory();
                    break;
                case 4:
                    system.issueBook();
                    break;
                case 5:
                    system.returnBook();
                    break;
                case 6:
                    system.searchBook();
                    break;
                case 7:
                    system.deleteBook();
                    break;
                case 8:
                    system.deleteAllBooks();
                    break;
                case 9:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
//    Novels:
//Book Title: To Kill a Mockingbird
//Author: Harper Lee
//Book Title: 1984
//Author: George Orwell
//Book Title: Pride and Prejudice
//Author: Jane Austen
//Book Title: The Great Gatsby
//Author: F. Scott Fitzgerald
//Book Title: The Catcher in the Rye
//Author: J.D. Salinger
//*****************************************
//Story Books:
//Book Title: The Tale of Peter Rabbit
//Author: Beatrix Potter
//Book Title: The Little Prince
//Author: Antoine de Saint-Exupéry
//Book Title: Alice's Adventures in Wonderland
//Author: Lewis Carroll
//Book Title: The Wind in the Willows
//Author: Kenneth Grahame
//Book Title: The Jungle Book
//Author: Rudyard Kipling
//Engineering Books:
//Book Title: Engineering Mechanics
//Author: J.L. Meriam, L.G. Kraige
//Book Title: Mechanical Engineering Design
//Author: J.E. Shigley
//Book Title: Introduction to Electrical Engineering
//Author: Mulukutla S. Sarma
//Book Title: Fundamentals of Thermodynamics
//Author: Richard E. Sonntag, Claus Borgnakke
//Book Title: Fluid Mechanics
//Author: Frank M. White
//*************************************************
//General Knowledge:
//Book Title: The Guinness Book of World Records
//Author: Craig Glenday
//Book Title: A Brief History of Time
//Author: Stephen Hawking
//Book Title: Sapiens: A Brief History of Humankind
//Author: Yuval Noah Harari
//Book Title: The World Almanac and Book of Facts
//Author: World Almanac Editors
//Book Title: Freakonomics
//Author: Steven D. Levitt, Stephen J. Dubner