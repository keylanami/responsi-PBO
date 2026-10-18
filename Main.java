import java.util.List;

public class Main {
    public static void main(String[] args) {
        AcademicService service = new AcademicService();

        Student keyla = new Student("0065", "Key");

        // Komposisi 
        Course pbo = new Course("oop49", "Opbject Oriented Programming", List.of(new Assingment("Jurnal 5", 100)));

        // agregasi
        Department department = new Department("Computer Science");
        service.addCourseToDepartment(department, pbo);
        service.enroll(keyla, pbo);

        service.addAssignment(pbo, "class relation", 100);

        Assingment task =service.findAssingment(pbo, "class relation");
        
        

        try {
            int attempNo;

            try {
                attempNo = Integer.parseInt("dua");
            } catch(NumberFormatException e){
                System.out.println("Nomor percobaan harus berupa angka");
                attempNo = 1;
            }

            service.submit(task, keyla, attempNo, "class adalah blueprint object");



        } catch (Exception e) {
            service.markNeedsReview(task);

            System.out.println("Submission rejected " + e.getMessage());

            System.out.println("Tugas ditandai untuk ditinjau");
            
        } finally {
            System.out.println("Pemeriksaan selesai! sudah tuntasn dicheck");
        }



        
        System.out.println("Department " + department.getName());
        System.out.println("Jumlah course " + department.getCourses().size());
        System.out.println("Nama student: " + keyla.getName());
        System.out.println("Id mahasiswa: " + keyla.getId());

        System.out.println("Nama tugas: " + task.getTitle());
        System.out.println("Submission valid: " + task.getSubmissions().size());
        System.out.println("Perlu ditinjauL " + task.isNeedsReview());
        
        System.out.println();

    }
}
