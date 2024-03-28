public class HistoryBook extends Book {
    public HistoryBook(String bookId, String title, String author, String category, int stock) {
        super(bookId, title, author, category, stock);
        this.category = "Sejarah";
    }

    public HistoryBook(String title, String author, int stock) {
        super();
        this.title = title;
        this.author = author;
        this.category = "Sejarah";
        this.stock = stock;
    }
}
