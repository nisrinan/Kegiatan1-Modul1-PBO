import java.util.Scanner;

public class Admin extends User {

    public Admin(String name, String nim, String faculty, String program) {
        super(name, nim, faculty, program);
    }

    public void addStudent(String name, String nim, String faculty, String program) {
        System.out.println("Student successfully registered.");
    }

    public void addBook(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.print("Choose category (1-3): ");
        int category = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        if (category == 1) {
            Book newBook = new StoryBook(title, author, stock);
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = newBook;
                    break;
                }
            }
            System.out.println("Book successfully added to the library.");
        } else if (category == 2) {
            Book newBook = new HistoryBook(title, author, stock);
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = newBook;
                    break;
                }
            }
            System.out.println("Book successfully added to the library.");
        } else if (category == 3) {
            Book newBook = new TextBook(title, author, stock);
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = newBook;
                    break;
                }
            }
            System.out.println("Book successfully added to the library.");
        } else {
            System.out.println("Invalid category.");
        }
    }

    @Override
    public void displayBooks(Book[] books) {
        System.out.println("=================================================================================");
        System.out.println("|| No.|| Id buku\t\t || Judul\t || Author\t || Category || Stock ||");
        System.out.println("=================================================================================");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println("|| " + (i+1) + " || " + books[i].getBookId() + "\t || " +
                        books[i].getTitle() + "\t || " + books[i].getAuthor() + "\t || " +
                        books[i].getCategory() + "\t || " + books[i].getStock() + "\t ||");
            }
        }
        System.out.println("=================================================================================");
    }

    public void displayStudents(User[] users) {
        System.out.println("List of Registered Students:");
        for (User user : users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("Name: " + student.name);
                System.out.println("NIM: " + student.nim);
                System.out.println("Faculty: " + student.faculty);
                System.out.println("Program: " + student.program);
                System.out.println("---------------------------");
            }
        }
    }

    public boolean isAdmin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
