package NAUKMA.students;

public class runStudent{
    public static void main(String[] args) {
        runStudent runStudent = new runStudent();
        runStudent.run();
    }

    public void run(){
        Student student = new Student("Daniel", "Orel", "FI", "CS");
        student.setLessons(5);
        student.earnGrades();
        student.getGrades();
        System.out.println(student.toString());
    }
}
