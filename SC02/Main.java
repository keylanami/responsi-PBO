package SC02;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoanService service = new LoanService();

        Book ima = new Book("BK01", "Algorithms", 4);
        Book java = new Book("BK02", "Intro to Java", 2);

        Library library = new Library("Oplib Telyu", List.of(ima, java));

        Member member = new Member("M01", "Keyu");


        System.out.println("Welcome to " + library.getName());
        System.out.println("Books available: " + library.getCatalogue().size());



        // di loan kan ada komposisi pake constructor, nah kita pake di sini yaa
        try {
            Loan preparedLoan = service.createLoanWithInitialItems("L001", member, List.of(new LoanItem(ima, 1)));

            System.out.println("Peminjaman awal: " + preparedLoan.getItems().size() + " detail");


        } catch (InvalidLoanException e) {
            System.out.println("Detail awal ditolak: " + e.getMessage());
        }



        // ini relasi asosiasi. loan -> member
        Loan loan = service.createLoan("L02", member);
        
        try {
            int quantity;


            try {
                quantity = Integer.parseInt("tiga"); // ini untuk test exception handling yaa
            } catch (NumberFormatException e) {
                System.out.println("isi harus berupa ANGKA");
                quantity = 1;
            }


            service.addBook(loan, java, quantity); // relasi apa? yap, composition karena Loan --bikin--> LoanItem di dirinya sendiri

            service.addBook(loan, ima, 0); // coba quantitynya 0 which is ga valid. apa yang bakal terjadi?


        } catch (Exception e) {
           service.markNeedsReview(loan);


           System.out.println("Loan rejected: " + e.getMessage());
           System.out.println("Loan is marked to be reviewed: ");
        } finally {
            System.out.println("OK! ALL PASSED! pemeriksaan selesai!");
        }


        System.out.println("Detail peminjaman kode L02: " + loan.getItems().size());
        System.out.println("Stok " + ima.getTitle() + " available: " + ima.getAvailableCopies());
        System.out.println("Loan yang perlu ditinjau: " + loan.isNeedsReview());
    }
}
