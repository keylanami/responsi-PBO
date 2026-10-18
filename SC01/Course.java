package SC01;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private List<Assingment> assingments = new ArrayList<>();

    public Course(String code, String title, List<Assingment> initialAssignments){
        this.title = title;
        this.code = code;

        // if (initialAssignments != null) {
            
        // }
    }
    

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public List<Assingment> getAssingments() {
        return assingments;
    }


    public void addAssignment(String title, int maxScore){
        assingments.add(new Assingment(title, maxScore));
    }



}
