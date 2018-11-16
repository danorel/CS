package NAUKMA.students;

public class runStudent{
    private String dir = "data";
    private String fileName = "Students.txt";

    public static void main(String[] args) {
        runStudent runStudent = new runStudent();
        runStudent.run();
    }

    public void separateLines(){
        System.out.println("--------------------------");
    }

    public void run(){
        Student student = new Student("Daniel", "Orel", "FI", "CS", 1);
        student.setLessons(5);
        student.earnGrades();
        student.getGrades();
        separateLines();
        System.out.println(student.toString());
        student.saveInformationAboutStudent(student, dir, fileName);
        separateLines();
        student.getStudentIDFromFile(dir, fileName);
        separateLines();
        student.getInformationAboutStudent(dir, fileName);
        separateLines();
        Student student1 = new Student();
        System.out.println(student1.toString());
        student1.saveInformationAboutStudent(student1, dir, fileName);
    }
}
