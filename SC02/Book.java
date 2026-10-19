package SC02;
public class Book {
    private String isbn;
    private String title;
    private int availableCopies;


    public Book(String isbn, String title, int availableCopies){
        
        if (isbn == null || title == null) {
            throw new IllegalArgumentException("ISBN dan judu buku wajib diisi.");
        }

        if (availableCopies < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        
        this.title = title;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {

        if (availableCopies < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif.");
        }

        this.availableCopies = availableCopies;
    }

}
