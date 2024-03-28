public class TextBook extends Book {
    public TextBook(String bookId, String title, String author, String category, int stock) {
        super(bookId, title, author, category, stock);
        this.category = "Novel";
    }

    public TextBook(String title, String author, int stock) {
        super();
        this.title = title;
        this.author = author;
        this.category = "Novel";
        this.stock = stock;
    }
}
