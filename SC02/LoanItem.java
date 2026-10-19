package SC02;
public class LoanItem {
    private Book book;
    private int quantity;

    public LoanItem(Book book, int quantity){
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }


}
