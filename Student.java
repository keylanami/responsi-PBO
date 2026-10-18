import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Course> enrolledCourses;

    public Student(String id, String name){
        if (id == null) {
            throw new IllegalArgumentException("id harus diisi");
        }

        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }


    // asosiasi
    public void addEnrolledCourse(Course course){
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }

    }
    

}
