public class Book {
    public String bookId;
    public String title;
    public String author;
    public String category;
    public int stock;

    public Book() {
        this.bookId = generateId();
    }

    public Book(String bookId, String title, String author, String category, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public String generateId() {
        return "B" + (int) (Math.random() * 1000);
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock() {
        stock--;
    }
}
