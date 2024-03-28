import java.util.Scanner;

public class Student extends User {
    public Student(String name, String nim, String faculty, String program) {
        super(name, nim, faculty, program);
    }

    @Override
    public void displayBooks(Book[] books) {
        super.displayBooks(books);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Id buku yang ingin dipinjam (input 99 untuk back): ");
        String bookId = scanner.nextLine();

        if (bookId.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return;
        }

        Book bookToBorrow = null;
        for (Book book : books) {
            if (book != null && book.getBookId().equals(bookId)) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow != null && bookToBorrow.getStock() > 0) {
            System.out.print("Berapa lama buku akan dipinjam? (maksimal 14 hari) ");
            int days = scanner.nextInt();
            if (days > 0 && days <= 14) {
                borrowedBooks[numBorrowedBooks] = bookToBorrow;
                numBorrowedBooks++;
                bookToBorrow.decreaseStock();
                System.out.println("Peminjaman buku berhasil.");
            } else {
                System.out.println("Input tidak valid.");
            }
        } else {
            System.out.println("Buku tidak tersedia atau tidak valid.");
        }
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Faculty: " + faculty);
        System.out.println("Program: " + program);
    }
}
