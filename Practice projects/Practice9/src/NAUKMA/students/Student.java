package NAUKMA.students;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    protected Scanner scanner = new Scanner(System.in);
    /*
     * All information about the student, which returns
     * toString function.
     */
    protected String info = "";

    /*
     * ID restrictions. Generating student ID from MIN to MAX StudentID.
     */
    protected final int MAXStudentID = 999999;
    protected final int MINStudentID = 100000;

    /*
     * All the marks, which student earns during the university period.
     */
    protected final int MAXScore = 100;
    protected int NumberOfLessons;
    protected int AverageScore;

    /*
     * Each student has his own name, surname, studentID, Year of
     * education, specialisation.
     */
    protected String name, surname;
    protected int studentID;
    protected int YearOfEducation;
    protected String specialisation;
    protected String faculty;

    /*
     * Each student the opportunity to earn the grades during the
     * lessons, randomly generated.
     */
    protected ArrayList<Integer> grades = new ArrayList<>();
    protected ArrayList<String> lessons = new ArrayList<>();

    /*
     * Created the database of the student IDs. We will use the pointer
     * currentStudent to communicate with his own possibilities.
     */
    protected ArrayList<Integer> studentIDList = new ArrayList<>();
    protected int currentStudent = 0;

    /*
     * Constructor without any properties. I gave the opportunity
     * to set name and surname, specialisation. The user is also given
     * the unique ID and he is also 1-st year of education.
     */

    Student(){
        studentID = getUniqueID();
        studentIDList.set(currentStudent, studentID);
        YearOfEducation = 1;
        setNS();
        currentStudent++;
        System.out.println("Constructor without any parameters has created new student!");
    }

    protected void setNS() {
        System.out.print("What is your name and surname? (Sample: 'George Lobanoff') Answer: ");
        String NS = scanner.nextLine();
        String []StudentInit = NS.split(" ");
        this.name = StudentInit[0];
        this.surname = StudentInit[1];
    }

    /*
     * Constructor with properties. The user sets everything in the
     * constructor by himself.
     */
    /**
     * @param name - the name of the student
     * @param surname - the surname of the student
     * @param specialisation - the spec of the student
     * @param YearOfEducation - the student year of education
     */
    Student(String name, String surname, int YearOfEducation){
        this.name = name;
        this.surname = surname;
        this.YearOfEducation = YearOfEducation;
        this.studentID = getUniqueID();
        System.out.println("Constructor with parameters has created new student!");
    }

    /*
     * The method, the main role of which to save the entire
     * information about the student in the directory 'data' and
     * the filename 'Students.txt'.
     */
    public void saveInformationAboutStudent(Student student, String dir, String fileName){
        try {
            File directory = new File(dir);
            directory.mkdir();
            FileWriter fileWriter = new FileWriter(dir + "/" + fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(toString());
            writer.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     * The method, the main role of which to read all the data(which was saved by the saveInformationAboutStudent method) in the
     * file about some student.
     */
    public void getInformationAboutStudent(String dir, String fileName){
        try{
            FileReader fileReader = new FileReader(dir + "/" + fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String str = null;
            LineSeparator();
            while((str = reader.readLine()) != null){
                System.out.println(str);
            }
            LineSeparator();
            reader.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     * The method changes the pointer to the current Student.
     * It gives the opportunity to call the class methods
     * personally to pointed student.
     */
    public void changeCurrentStudent(int currentStudent){
        int counter = 0;
        if(currentStudent >= studentIDList.size()){
            System.err.println("Fatal ERROR. U got out of restrictions...Refering to the first student!");
            this.currentStudent = 0;
        } else {
            this.currentStudent = currentStudent;
        }
    }

    /*
     * Gets the id of current student in the file 'Student.txt' in the
     * directory 'data'.
     */
    public void getStudentIDFromFile(String dir, String fileName){
        try{
            FileReader fileReader = new FileReader(dir + "/" + fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String []array = reader.readLine().split(" ");
            reader.close();
            System.out.println(array[4* currentStudent - 2]);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    /*
     * Methods sets the lesson list directly into the ArrayList
     * variable
     */
    public void setLessons(int Amount){
        NumberOfLessons = Amount;
        for(int counter = 0; counter < NumberOfLessons; counter++){
            System.out.print("Lesson[" + (counter + 1) + "]: ");
            lessons.add(scanner.nextLine());
        }
    }

    /*
     * Opportunity to earn the grades during the educational process.
     */
    public void earnGrades(){
        for(int counter = 0; counter < NumberOfLessons; counter++){
            grades.add(1 + (int)(Math.random() * MAXScore));
        }
    }

    /*
     * Receive the earned grades in the electronic way.
     */
    public void getGrades(){
        for(int counter = 0; counter < NumberOfLessons; counter++){
            System.out.println(lessons.get(counter) + ":" + grades.get(counter));
        }
    }

    /*
     * Method calculates the average score from obtained marks
     * during the educational process.
     */
    public double getAverageScore(){
        for(int counter = 0; counter < NumberOfLessons; counter++){
            AverageScore += grades.get(counter);
        }
        return (double)AverageScore / 5;
    }

    /*
     * Method 'getGeneratedID' and 'getUniqueID' generate the unique ID
     * personally for the students of KMA.
     */
    private int getUniqueID() {
        int ID = getGeneratedID();
        int counter = 0;
        if(studentIDList.size() == 0){
            studentIDList.add(ID);
        } else {
            while(counter != studentIDList.size()){
                if(studentIDList.get(counter) == ID){
                    ID = getGeneratedID();
                    counter = -1;
                }
                counter++;
            }
        }
        return ID;
    }

    private int getGeneratedID() {
        return (int)(Math.random() * (MAXStudentID - MINStudentID)) + MINStudentID;
    }

    /*
     * If you have a desire to print the object, method toString will
     * return the 'info' variable to you, which consists of the
     * whole information about the student.
     */
    @Override
    public String toString(){
        this.info = "Student ID: " + this.studentID + "\nStudent NS: " + this.name + " " + this.surname + "\nFaculty: " + this.faculty + "\nSpecialisation: " + this.specialisation + "\nYear of education: " + YearOfEducation;
        return info;
    }

    protected void LineSeparator(){
        System.out.println("--------------------------");
    }
}
