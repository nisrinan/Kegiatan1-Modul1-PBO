import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choice, adminUsername, adminPassword;
        String nim;
        Scanner objInput = new Scanner(System.in);

        System.out.println("=====Library System=====");
        System.out.println("1. Login as Student\n2. Login as Admin\n3. Exit");
        System.out.print("Choose option (1-3) : ");
        choice = objInput.nextLine();

        do {
            switch (choice) {
                case "1":
                    System.out.print("Enter your NIM (exactly 15 digits) : ");
                    nim = objInput.nextLine();
                    if (nim.length() == 15) {
                        System.out.println("Successful Login as Student");
                    } else {
                        System.out.println("User Not Found");
                    }
                    break;
                case "2":
                    System.out.print("Enter your username (admin) : ");
                    adminUsername = objInput.nextLine();
                    System.out.print("Enter your password (admin) : ");
                    adminPassword = objInput.nextLine();
                    if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
                        System.out.println("Successful Login as Admin");
                    } else {
                        System.out.println("User Not Found");
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Choose option (1-3)");
            }
            System.out.print("Choose option (1-3) : ");
            choice = objInput.nextLine();
        } while (choice.equals("1") || choice.equals("2"));
    }
}