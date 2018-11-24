package NAUKMA.students;

import java.io.*;

public class Runner {
    private String dir = "data";
    private String fileName = "Students.txt";
    private File directory;
    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedReader reader;
    private BufferedWriter writer;

    private String[] lessons = {"Discrete Math", "Math Analysis", "PL", "English"};

    public static void main(String[] args) {
        Runner Runner = new Runner();
        Runner.run();
    }

    public void run(){
        setUpDirectoryAndConnectionsToFile();
        Interface IF = new Interface(reader);

        FIStudent fiStudent1 = new FIStudent();
        fiStudent1.setSpecialisation("PE");
        fiStudent1.setNameSurname("Daniel Orel");
        Runner.saveInformationAboutStudent(fiStudent1, writer);
        fiStudent1.setLessons(lessons);
        fiStudent1.earnGrades();
        fiStudent1.getAverageScore();
//        System.out.println(Runner.getStudentIDFromFile(fiStudent1, reader));

        FIStudent fiStudent2 = new FIStudent("George", "Lobanoff", 2);
        fiStudent2.setSpecialisation("PM");
        Runner.saveInformationAboutStudent(fiStudent2, writer);
        fiStudent2.setLessons(lessons);
        fiStudent2.earnGrades();
        fiStudent2.getAverageScore();

//        Runner.getInformationAboutStudent(reader);

        try{
            writer.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
        Student.getAmountOfStudents();
    }

    public void setUpDirectoryAndConnectionsToFile() {
        try{
            directory = new File(dir);
            directory.mkdir();
            file = new File(dir + "/" + fileName);
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    /*
     * The method, the main role of which to save the entire
     * information about the student in the directory 'data' and
     * the filename 'Students.txt'.
     */
    public static void saveInformationAboutStudent(Student student, BufferedWriter writer){
        student.studentInfo = "Student ID: " + student.studentIDList.get(Student.StudentCounter - 1) + "\nStudent NS: " + student.name + " " + student.surname + "\nFaculty: " + student.faculty + "\nSpecialisation: " + student.specialisation + "\nYear of education: " + student.yearOfEducation;
        try {
            writer.write(student.studentInfo + "\n");
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     * The method, the main role of which to read all the data(which was saved by the saveInformationAboutStudent method) in the
     * file about some student.
     */
//    public static void getInformationAboutStudent(BufferedReader reader){
//        try{
//            String line;
//            while((line = reader.readLine()) != null){
//                System.out.println(line);
//            }
//            reader.close();
//        } catch(Exception exception){
//            exception.printStackTrace();
//        }
//    }

    /*
     * Gets the id of current student in the file 'Student.txt' in the
     * directory 'data'.
     */
//    public static int getStudentIDFromFile(Student student, BufferedReader reader){
//        int ID = 0;
//        String str;
//        try{
//            int counter = 0;
//            while((str = reader.readLine()) != null){
//                if(counter == (5 * (student.studentID - 1))){
//                    String[] subStrings = str.split(" ");
//                    ID = Integer.parseInt(subStrings[2]);
//                }
//                counter++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return ID;
//    }

//    private void LineSeparator(){
//        System.out.println("----------------------------");
//    }
}
