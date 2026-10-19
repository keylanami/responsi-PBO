package SC02;
import java.util.List;

public class LoanService {
    

    public Loan createLoan(String loanId, Member member){
        return new Loan(loanId, member);
    }


    public Loan createLoanWithInitialItems(String loanId, Member member, List<LoanItem> initialItems) throws InvalidLoanException{
        validateLoan(loanId, member);

        if (initialItems.isEmpty()) {
            throw new InvalidLoanException("Peminjaman awal harus punya at least 1 detail");
        }

        if (initialItems.size() > 5) {
            throw new InvalidLoanException("Jumlah detail melebihi batas maksimum");
        }


        // buat check validasi tiap detail loan-nya pake loop, inget-inget lagi materi loop yaa
        for (int i = 0; i < initialItems.size(); i++) {
            LoanItem item = initialItems.get(i);

            if (item == null || item.getBook() == null) {
                throw new InvalidLoanException("Detail atau buku ga valid");
            }

            if (item.getQuantity() <= 0) {
                throw new InvalidLoanException("Jumlah buku harus >0");
            }



            // nested loop. check buku yang sama ga boleh duplicate.
            // tujuannya biar kayak DISTINCT di query sql
            for(int j = 0; j < i; j++){
                LoanItem previousItem = initialItems.get(j);


                if (previousItem.getBook().getIsbn().equals(item.getBook().getIsbn())) {
                    throw new InvalidLoanException("buku yang sama gak boleh muncul 2x. \n");
                }

            }


            if (item.getBook().getAvailableCopies() < item.getQuantity()) {
                throw new InvalidLoanException("Stok unavailable nih buat judul: \n" + item.getBook().getTitle());
            }

        }

        Loan loan = new Loan(loanId, member, initialItems);


        for (LoanItem loanItem : initialItems) {
            Book book = loanItem.getBook();

            book.setAvailableCopies(book.getAvailableCopies() - loanItem.getQuantity());
        }

        return loan;
        
    }

    private void validateLoan(String loanId, Member member) throws InvalidLoanException {
        if (loanId.isBlank()) {
            throw new InvalidLoanException("ID load wajib diisi, ga boleh kosong");
        }

        if (member == null) {
            throw new InvalidLoanException("Jadi member dulu kalau belum");
        }
    }



    public void addBook(Loan loan, Book book, int quantity) throws InvalidLoanException{
         if (loan == null || book == null) {
            throw new InvalidLoanException(
                "Loan dan Book wajib ada! isi dulu!"
            );
        }

        if (quantity <= 0) {
            throw new InvalidLoanException(
                "Jumlah buku harus >0 yaa."
            );
        }

        if (book.getAvailableCopies() < quantity) {
            throw new InvalidLoanException(
                "Stok gak cukup untuk: " + book.getTitle()
            );
        }


        book.setAvailableCopies(book.getAvailableCopies() - quantity); // logic biasa utk kurangin stok setelah validasi
        loan.addItem(book, quantity); // relasi composition
    }


    public void markNeedsReview(Loan loan){
        if (loan == null) {
            throw new IllegalArgumentException("loan kosong nih! wajib diisi");
        }

        loan.setNeedsReview(true);
    }

}
