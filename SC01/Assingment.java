package SC01;
import java.util.ArrayList;
import java.util.List;

public class Assingment {
    private String title;
    private int maxScore;
    private List<Submission> submissions = new ArrayList<>();
    private boolean needsReview;

    public Assingment(String title, int maxScore){
        if (maxScore <= 0) {
            throw new IllegalArgumentException("Max score tidak boleh <0");
        }


        this.title = title;
        this.maxScore = maxScore;
        this.needsReview = false;
    }


    public String getTitle() {
        return title;
    }

    public int getMaxScore() {
        return maxScore;
    }


    public List<Submission> getSubmissions() {
        return submissions;
    }

    public boolean isNeedsReview() {
        return needsReview;
    }


    public void setNeedsReview(boolean needsReview) {
        this.needsReview = needsReview;
    }


    // komposisi submission dilakukan oleh student pada assignment
    public void addSubmission(Student student, int attemptNo, String answer ){
        submissions.add( new Submission(student, attemptNo, answer));
    }
    


}
