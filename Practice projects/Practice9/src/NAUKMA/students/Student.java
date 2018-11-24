package NAUKMA.students;

import java.util.ArrayList;

public class Student {
    /*
     * All information about the student, which returns
     * toString function.
     */
    protected String studentInfo = "";

    /*
     * All the marks, which student earns during the university period.
     */
    protected final int MAXScore = 100;
    protected int amountOfLessons;
    protected int averageScore;
    /*
     * Each student has his own name, surname, studentID, Year of
     * education, specialisation.
     */
    protected String name, surname;
    protected int yearOfEducation;
    protected String specialisation;
    protected String faculty;
    protected int studentID;

    /*
     * Each student the opportunity to earn the grades during the
     * lessons, randomly generated.
     */
    protected boolean isGraded = false;
    protected boolean isGotLessons = false;
    protected ArrayList<Integer> grades = new ArrayList<>();
    protected ArrayList<String> lessons = new ArrayList<>();

    /*
     * Created the database of the student IDs. We will use the pointer
     * currentStudent to communicate with his own possibilities.
     */
    protected static ArrayList<Integer> studentIDList = new ArrayList<>();
    protected static int StudentCounter = 0;

    /*
     * Constructor without any properties. I gave the opportunity
     * to set name and surname, specialisation. The user is also given
     * the unique ID and he is also 1-st year of education.
     */
    Student(){
        StudentCounter++;
        setUniqueID();
        yearOfEducation = 1;
        System.out.println("Constructor without any parameters has created new student!");
    }

    /*
     * Constructor with properties. The user sets everything in the
     * constructor by himself.
     */
    /**
     * @param name - the name of the student
     * @param surname - the surname of the student
     * @param YearOfEducation - the student year of education
     */
    Student(String name, String surname, int YearOfEducation){
        StudentCounter++;
        this.name = name;
        this.surname = surname;
        this.yearOfEducation = YearOfEducation;
        setUniqueID();
        System.out.println("Constructor with parameters has created new student!");
    }

    /*
     * Setter sets the student name and surname. It receives one parameter and split it into two strings.
     */
    public void setNameSurname(String nameSurname) {
        String []StudentInit = nameSurname.split(" ");
        this.name = StudentInit[0];
        this.surname = StudentInit[1];
    }

    /*
     * These overload methods sets the lesson, if it is the non-array string, directly into the ArrayList, if it is the array parameter, sets current array into ArrayList
     */
    public void setLessons(String lesson){
        amountOfLessons++;
        lessons.add(lesson);
        isGotLessons = true;
    }

    public void setLessons(String[] lessons){
        for(int counter = 0; counter < lessons.length; counter++){
            amountOfLessons++;
            this.lessons.add(lessons[counter]);
        }
        isGotLessons = true;
    }

    /*
     * Opportunity to earn the grades during the educational process.
     */
    public void earnGrades(){
        if(isGotLessons){
            for(int counter = 0; counter < amountOfLessons; counter++){
                grades.add((int)(Math.random() * MAXScore));
            }
            isGraded = true;
        } else {
            System.out.println("You haven't received the lessons yet!");
        }
    }

    /*
     * Receive the earned grades in the electronic way.
     */
    public void getGrades(){
        if(isGraded) {
            for (int counter = 0; counter < amountOfLessons; counter++) {
                System.out.println(lessons.get(counter) + ":" + grades.get(counter));
            }
        } else if(isGotLessons && !isGraded){
            System.out.println("You haven't earned the score yet!");
        } else if(!isGotLessons) {
            System.out.println("You haven't received the lessons yet!");
        }
    }

    /*
     * Method calculates the average score from obtained marks
     * during the educational process.
     */
    public void getAverageScore(){
        if(isGraded){
            for(int counter = 0; counter < amountOfLessons; counter++){
                averageScore += grades.get(counter);
            }
            System.out.println("The average score of student with ID " + studentIDList.get(StudentCounter - 1) + " is " + (double) averageScore / amountOfLessons);
        } else if(isGotLessons && !isGraded){
            System.out.println("You haven't earned the score yet!");
        } else if(!isGotLessons) {
            System.out.println("You haven't received the lessons yet!");
        }
    }

    /*
     * Method 'setUniqueID' generate the unique ID
     * personally for the students of KMA.
     */
    private void setUniqueID() {
        studentIDList.add(StudentCounter);
        studentID = studentIDList.get(StudentCounter - 1);
    }

    /*
     * If you have a desire to print the object, method toString will
     * return the 'studentInfo' variable to you, which consists of the
     * whole information about the student.
     */
    @Override
    public String toString(){
        this.studentInfo = "Student ID: " + this.studentID + "\nStudent NS: " + this.name + " " + this.surname + "\nFaculty: " + this.faculty + "\nSpecialisation: " + this.specialisation + "\nYear of education: " + yearOfEducation;
        return studentInfo;
    }

    public static void getAmountOfStudents(){
        System.out.println("The amount of students in the university is " + StudentCounter);
    }
}
