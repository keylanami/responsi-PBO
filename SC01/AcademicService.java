package SC01;
public class AcademicService {
    
    public void addCourseToDepartment(Department department, Course course){
        
        if (department == null || course == null) {
            throw new IllegalArgumentException("Department atau Course harus ada");
        }
        
        department.addCourse(course);
    }

    public void enroll(Student student, Course course){

        if (student == null || course == null) {
            throw new IllegalArgumentException("Nama murid atau matkulnya harus ada!");
        }
        student.addEnrolledCourse(course);
    }

    public void addAssignment(Course course, String title, int maxScore){

        if (course == null) {
            throw new IllegalArgumentException("Course harus diisi!");
        } else if (title == null) {
            throw new IllegalArgumentException("Judul tugas wajib diisi!!");
        } else if (maxScore <= 0) {
            throw new IllegalArgumentException("Nilai maksimum harus di atas 0");
        }

        

        course.addAssignment(title, maxScore);
    }



    public Assingment findAssingment(Course course, String title){
        if (course == null || title == null) {
            throw new IllegalArgumentException("Course atau title wajib diisi");
        }

         return course.getAssingments()
            .stream()
            .filter(a -> a.getTitle().equalsIgnoreCase(title))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Tugas tidak ditemukan: " + title
                )
            );
    }


    public void submit(Assingment assingment, Student student, int attemptNo, String answer){
        if (assingment == null || student == null ) {
            throw new IllegalArgumentException("Assignment atau Student ga boleh kosong!");
        } else if (attemptNo <= 0) {
            throw new IllegalArgumentException("attemp no harus lebih dari 0");
        }

        if (answer.isBlank() || answer == null) {
            throw new IllegalArgumentException("Jawaban tidak boleh kosong");
        }

        assingment.addSubmission(student, attemptNo, answer);
    }


    public void markNeedsReview(Assingment assingment){
        if (assingment == null) {
            throw new IllegalArgumentException("Kumpulin tugasnya dulu!!");
        }
        assingment.setNeedsReview(true);
    }



}
