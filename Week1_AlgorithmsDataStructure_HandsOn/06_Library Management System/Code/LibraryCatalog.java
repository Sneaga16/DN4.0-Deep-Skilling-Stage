import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title.toLowerCase(); 
        this.author = author;
    }

    String show() {
        return "📘 [" + bookId + "] " + title + " by " + author;
    }
}

public class LibraryCatalog {

    static Book[] collection = new Book[10];
    static int size = 0;

    public static void addBook(int id, String title, String author) {
        if (size < collection.length) {
            collection[size++] = new Book(id, title, author);
            System.out.println("Book added to the shelf.");
        } else {
            System.out.println("Library is full.");
        }
    }

    
    public static void searchDirectly(String query) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (collection[i].title.equalsIgnoreCase(query)) {
                System.out.println("🔍 Found (Linear): " + collection[i].show());
                found = true;
            }
        }
        if (!found) System.out.println("No such book found using linear search.");
    }

    
    public static void probeBooks(String query) {
        
        Book[] sortedList = Arrays.copyOf(collection, size);
        Arrays.sort(sortedList, (a, b) -> a.title.compareToIgnoreCase(b.title));

        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedList[mid].title.compareToIgnoreCase(query);

            if (cmp == 0) {
                System.out.println("📗 Found (Binary): " + sortedList[mid].show());
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("No such book found using binary search.");
    }

    
    public static void listAll() {
        if (size == 0) {
            System.out.println("Library is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(collection[i].show());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        
        addBook(101, "Java Unleashed", "R. Martin");
        addBook(102, "Python Notes", "A. Gupta");
        addBook(103, "Algorithms Deep Dive", "S. Tarun");
        addBook(104, "C for Geeks", "N. Kiran");
        addBook(105, "Data Structures", "L. Mehta");

        do {
            System.out.println("\n== LIBRARY CATALOG SYSTEM ==");
            System.out.println("1 → View All Books");
            System.out.println("2 → Search by Title (Linear)");
            System.out.println("3 → Search by Title (Binary)");
            System.out.println("4 → Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    listAll();
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String titleLinear = sc.nextLine();
                    searchDirectly(titleLinear);
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String titleBinary = sc.nextLine();
                    probeBooks(titleBinary);
                    break;
                case 4:
                    System.out.println("Goodbye, Reader!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);
        sc.close();
    }
}