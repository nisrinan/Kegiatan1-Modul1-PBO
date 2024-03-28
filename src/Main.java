import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[10];
        Book[] books = new Book[10];

        books[0] = new HistoryBook("388c-e681-9152", "Title", "Author", "Sejarah", 4);
        books[1] = new StoryBook("ed90-be30-5cdb", "Title", "Author", "Cerita", 0);
        books[2] = new TextBook("d95e-0c4a-9523", "Title", "Author", "Novel", 2);

        Admin admin = new Admin("", "", "", "");

        boolean exit = false;

        while (!exit) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM (15 digits) (input 99 to go back): ");
                    String nim = scanner.nextLine();
                    if (nim.equals("99")) {
                        break;
                    }

                    if (nim.length() != 15) {
                        System.out.println("Invalid NIM. NIM must be 15 digits.");
                        break;
                    }

                    User student = null;
                    for (User user : users) {
                        if (user instanceof Student && user.nim.equals(nim)) {
                            student = user;
                            break;
                        }
                    }

                    if (student == null) {
                        student = new Student("", nim, "", "");
                    }

                    System.out.println("You are logged in.");

                    boolean studentExit = false;
                    while (!studentExit) {
                        System.out.println("==== Student Menu ====");
                        System.out.println("1. Buku terpinjam");
                        System.out.println("2. Pinjam buku");
                        System.out.println("3. Kembalikan buku");
                        System.out.println("4. Pinjam Buku atau Logout");
                        System.out.print("Choose option (1-4): ");

                        int studentOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (studentOption) {
                            case 1:
                                student.showBorrowedBooks();
                                break;
                            case 2:
                                student.displayBooks(books);
                                break;
                            case 3:
                                student.logout();
                                break;
                            case 4:
                                studentExit = true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your username (admin): ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.nextLine();

                    if (admin.isAdmin(username, password)) {
                        boolean adminExit = false;
                        while (!adminExit) {
                            System.out.println("===== Admin Menu =====");
                            System.out.println("1. Add Student");
                            System.out.println("2. Add Book");
                            System.out.println("3. Display Registered Students");
                            System.out.println("4. Display Available Books");
                            System.out.println("5. Logout");
                            System.out.print("Choose option (1-5): ");

                            int adminOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (adminOption) {
                                case 1:
                                    System.out.print("Enter student name: ");
                                    String studentName = scanner.nextLine();
                                    System.out.print("Enter student NIM: ");
                                    String studentNim = scanner.nextLine();
                                    System.out.print("Enter student faculty: ");
                                    String studentFaculty = scanner.nextLine();
                                    System.out.print("Enter student program: ");
                                    String studentProgram = scanner.nextLine();
                                    admin.addStudent(studentName, studentNim, studentFaculty, studentProgram);
                                    break;
                                case 2:
                                    admin.addBook(books);
                                    break;
                                case 3:
                                    admin.displayStudents(users);
                                    break;
                                case 4:
                                    admin.displayBooks(books);
                                    break;
                                case 5:
                                    adminExit = true;
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you. Exiting program.");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        }

        scanner.close();
    }
}
