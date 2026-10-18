import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Course> courses = new ArrayList<>();
    
    public Department(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }



    // aggregasi
    public void addCourse(Course course){
        courses.add(course);
    }




}
