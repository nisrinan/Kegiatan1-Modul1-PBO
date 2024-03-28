import java.util.Scanner;

public class User {
    protected String name;
    protected String nim;
    protected String faculty;
    protected String program;
    protected Book[] borrowedBooks;
    protected int numBorrowedBooks;

    public User(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
        this.borrowedBooks = new Book[5];
        this.numBorrowedBooks = 0;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Faculty: " + faculty);
        System.out.println("Program: " + program);
    }

    public void showBorrowedBooks() {
        if (numBorrowedBooks == 0) {
            System.out.println("Belum ada buku yang dipinjam.");
        } else {
            System.out.println("Buku yang dipinjam:");
            for (int i = 0; i < numBorrowedBooks; i++) {
                System.out.println((i + 1) + ". " + borrowedBooks[i].getTitle());
            }
        }
    }

    public void logout() {
        if (numBorrowedBooks == 0) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
        } else {
            System.out.println("Apakah kamu yakin untuk mengembalikan semua buku?");
            System.out.print("Input Y (ya) atau T (tidak): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                for (int i = 0; i < numBorrowedBooks; i++) {
                    borrowedBooks[i] = null;
                }
                System.out.println("Pengembalian buku berhasil dilakukan");
                numBorrowedBooks = 0;
            } else {
                System.out.println("Pengembalian buku dibatalkan.");
            }
        }
    }

    public void displayBooks(Book[] books) {
        System.out.println("=================================================================================");
        System.out.println("|| No.|| Id buku\t\t || Judul\t || Author\t || Category || Stock ||");
        System.out.println("=================================================================================");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println("|| " + (i + 1) + " || " + books[i].getBookId() + "\t || " +
                        books[i].getTitle() + "\t || " + books[i].getAuthor() + "\t || " +
                        books[i].getCategory() + "\t || " + books[i].getStock() + "\t ||");
            }
        }
        System.out.println("=================================================================================");
    }
}
