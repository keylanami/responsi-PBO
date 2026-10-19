package SC02;
import java.util.ArrayList;
import java.util.List;



// di loan ini ada relasi composition sama LoanItem
// perhatikan implementasi compositionnya yaaa karena bisa pake 2 cara 
public class Loan {
    private String loanId;
    private Member borrower;
    private List<LoanItem> items = new ArrayList<>();
    private boolean needsReview;


    // constructor biasa
    public Loan(String loanId, Member borrower){
        this.loanId = loanId;
        this.borrower = borrower;
        this.needsReview = false;
    }

    public String getLoanId() {
        return loanId;
    }

    public Member getBorrower() {
        return borrower;
    }

    public List<LoanItem> getItems() {
        return items;
    }

    public boolean isNeedsReview() {
        return needsReview;
    }

    public void setNeedsReview(boolean needsReview) {
        this.needsReview = needsReview;
    }


    // 1. Composition pake method biasa
    public void addItem(Book book, int quantity){
        items.add(new LoanItem(book, quantity)); // loan bikin LoanItem baru di dalamnya
    }




    // 2. Composition langsung pake constructor
    public Loan(String loanId, Member borrower, List<LoanItem> initialItems){
        this(loanId, borrower);

        if (initialItems != null) {
            for (LoanItem loanItem : initialItems) {
                if (loanItem == null) {
                    throw new IllegalArgumentException("LoanItem awal gak boleh null");
                }

                items.add(new LoanItem(loanItem.getBook(), loanItem.getQuantity()));
            }
        }
    }

    // loh kak, kok constructornya ada 2 sih?? dan kok gak error?
    // nanti kalian bakal belajar yang namanya overloading dan overriding habis assessment ini #spoiler

}
