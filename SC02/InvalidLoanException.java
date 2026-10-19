package SC02;
public class InvalidLoanException extends Exception {
    public InvalidLoanException(String m){
        super(m);
    }
}

// ini custom exception yaa, bakal kamu pake di throws tiap function di service nanti sesuai kebutuhannya
