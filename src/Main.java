import com.workintech.Library.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian(new TreeMap<>(), new HashSet<>(), new TreeMap<>());
        Reader reader1 = new Reader("İhsan", 1,
                new Address("İzmir", "Karabağlar", "Reis mahallesi", 17),
                535496, new TreeMap<>());
        librarian.saveReaders(reader1.getId(), reader1);
        defaultBooks(librarian);
        enterToLibrary(librarian);



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
    }

    public static void enterToLibrary(Librarian librarian) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please indicate whether you are an reader or a librarian.");
            String identy = scanner.nextLine().toUpperCase(Locale.ENGLISH);
            if (identy.contains("READER")) {
                reader(librarian);
            }if (identy.contains("LIBRARIAN")) {
                librarian(librarian);
            }
        }
    }
    public static void librarian(Librarian librarian) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Welcome to library system.");
                String text = scanner.nextLine().toUpperCase();
                if (text.contains("ADD")) {
                    addBook(librarian);
                }
                if (text.contains("DELETE")) {
                    System.out.println("Enter the id of book that you wanna delete.");
                    deleteBook(librarian);
                }
                if (text.contains("WORKS")) {
                    System.out.println("Enter the author name that u wanna see works");
                    worksOfAuthors(librarian);
                }
                else{
                    System.out.println("System shut down.");
                    System.exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Invalid: "+ex.getMessage());
            }
        }
    }

    public static void deleteBook(Librarian librarian){
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        librarian.deleteBooks(id);
        System.out.println(librarian.getBooks());

    }
    public static void worksOfAuthors(Librarian librarian){
       Scanner scanner=new Scanner(System.in);
       String name=scanner.nextLine();
       librarian.authorAndWorks(name);
        System.out.println(name.toUpperCase()+ " and works: "+"\n"+librarian.getAuthors());

    }
    public static void addBook(Librarian librarian){
        Book book7 = new Book(Status.AVAILABLE, 190, 1878,
                new Author("Henry James", 3), "İhsan", 5);
           librarian.addBooks(book7.getId(),book7);
        System.out.println(librarian.getBooks());
    }

    public static void reader(Librarian librarian) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please write what u wanna do.");
                String text = scanner.nextLine().toUpperCase(Locale.ENGLISH);
                if (text.contains("BORROW")) {
                    readerBorrowBook(librarian);
                }
                if (text.contains("GIVE")) {
                    giveBackTheBook(librarian);
                }
                if (text.contains("INVOICE")) {
                    currentInvoice(librarian);
                }
                if (text.contains("BASE")) {
                    System.exit(0);                          //BURADA BREAK KULLANAMAYIZ ÇÜNKÜ BİR İŞLEM YAPILDIKTAN SONRA YAZILABİLİR.
                }
            } catch (Exception ex) {
                System.out.println("Invalid: "+ex.getMessage());
            }
        }
    }

    public static void readerBorrowBook(Librarian librarian) {

        while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please specify the book you want to buy.");
                String text = scanner.nextLine().toUpperCase();
                if (text.contains("DOSTOYEVSKY") || text.contains("FRANZ") ||
                        text.contains("HENRY")) {
                    if (text.contains("DOSTOYEVSKY")) {
                        borrowByAuthorName("Dostoyevsky", librarian);
                    }
                    if (text.contains("FRANZ")) {
                        borrowByAuthorName("Franz Kafka", librarian);
                    }
                    if (text.contains("HENRY")) {
                        borrowByAuthorName("Henry James", librarian);
                    }
                } else {
                    borrowByWorkName(librarian);
                }
            printMyBooks(librarian);
                break;
        }
    }
    public static void borrowByWorkName(Librarian librarian) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please entry the book name that you wanna get.");
            try {
                String name = scanner.nextLine();
                librarian.chooseBook(name, librarian.getReaders().get(1));
                break;
            } catch (Exception ex) {
                System.out.println("Invalid:" + ex.getMessage());
            }
        }
    }

    public static void borrowByAuthorName(String name, Librarian librarian) {
        while (true) {
            librarian.chooseOneOfWorksAuthors(name, librarian.getReaders().get(1));
                break;
        }
    }
    public static void currentInvoice( Librarian librarian) {
        System.out.println("Your total invoice: "+ librarian.getReaders().get(1).getMyInvoiceFee());
    }

    public static void printMyBooks(Librarian librarian) {
        System.out.println(librarian.getReaders().get(1).getMyBooks());

    }
    public static void giveBackTheBook(Librarian librarian) {
        librarian.backTheBook(librarian.getReaders().get(1), librarian.getReaders().get(1).getMyBooks().get(1));
         printMyBooks(librarian);
    }
}