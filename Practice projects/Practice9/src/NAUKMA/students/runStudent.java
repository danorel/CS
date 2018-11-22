package NAUKMA.students;

public class runStudent{
    private String dir = "data";
    private String fileName = "Students.txt";

    public static void main(String[] args) {
        runStudent runStudent = new runStudent();
        runStudent.run();
    }

    public void run(){
        FIStudent fiStudent1 = new FIStudent();
        System.out.println(fiStudent1);

        FIStudent fiStudent2 = new FIStudent("George", "Lobanoff", 2);
        fiStudent2.saveInformationAboutStudent(fiStudent2, dir, fileName);
        fiStudent2.getInformationAboutStudent(dir, fileName);
        fiStudent2.makeProgram();
    }
}
