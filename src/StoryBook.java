public class StoryBook extends Book {
    public StoryBook(String bookId, String title, String author, String category, int stock) {
        super(bookId, title, author, category, stock);
        this.category = "Cerita";
    }

    public StoryBook(String title, String author, int stock) {
        super();
        this.title = title;
        this.author = author;
        this.category = "Cerita";
        this.stock = stock;
    }
}
