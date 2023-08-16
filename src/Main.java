import com.workintech.Library.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian(new TreeMap<>(), new TreeMap<>(), new TreeMap<>());
        defaultBooks(librarian);
        Book book1 = new Book(Status.AVAILABLE, 95, 1866,
                new Author("Dostoyevsky", 1), "Keli", 1);
        librarian.addBooks(book1.getId(), book1);


    }

    public static void defaultBooks(Librarian librarian) {
        Book book1 = new Book(Status.AVAILABLE, 95, 1866,
                new Author("Dostoyevsky", 1), "The Gambler", 1);

        Book book2 = new Book(Status.AVAILABLE, 110, 1868,
                new Author("Dostoyevsky", 1), "The Idiot", 2);

        Book book3 = new Book(Status.AVAILABLE, 130, 1926,
                new Author("Franz Kafka", 2), "The Castle", 3);

        Book book4 = new Book(Status.AVAILABLE, 110, 1927,
                new Author("Franz Kafka", 2), "Amerika", 4);

        Book book5 = new Book(Status.AVAILABLE, 150, 1878,
                new Author("Henry James", 3), "Europeans", 5);
        Book book6 = new Book(Status.AVAILABLE, 150, 1878,
                new Author("Henry James", 3), "Europeans", 6);
        librarian.addBooks(book1.getId(), book1);
        librarian.addBooks(book2.getId(), book2);
        librarian.addBooks(book3.getId(), book3);
        librarian.addBooks(book4.getId(), book4);
        librarian.addBooks(book5.getId(), book5);
        librarian.addBooks(book6.getId(), book6);
        System.out.println(librarian.getBooks());

    }

    public static void enterToLibrary(Librarian librarian) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please indicate whether you are an attendant or a visitor.");
            String identy = scanner.next().toUpperCase();
            if (identy.equals("READER")) {
                reader(librarian);
            }
        }
    }

    public static void reader(Librarian librarian) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please write what u wanna do.");
                String text = scanner.next().toLowerCase();
                if (text.contains("borrow")) {
                    readerBorrowBook(librarian);
                }
                if (text.contains("give")) {
                    readerBorrowBook(librarian);
                } else {
                    System.out.println("I could not get you well, pleae can you write what you want again?");
                }
            } catch (Exception ex) {
                System.exit(0);
            }
        }
    }

    public static void readerBorrowBook(Librarian librarian) {
        Reader reader1 = new Reader("İhsan", 1,
                new Address("İzmir", "Karabağlar", "Reis mahallesi", 17),
                535496);
        //Bu reader objesini Library reader mapine ekle burda!
    }
}