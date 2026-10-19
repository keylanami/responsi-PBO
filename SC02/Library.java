package SC02;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> catalogue = new ArrayList<>();

    public Library(String name, List<Book> initialBooks){
        this.name = name;

        if (initialBooks != null) {
            catalogue.addAll(initialBooks); // .addAll itu dipake buat nyimpen >1
        }
    }

    public List<Book> getCatalogue() {
        return catalogue;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book){
        catalogue.add(book);
    }

}
