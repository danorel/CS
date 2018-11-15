package NAUKMA.students;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private Scanner scanner = new Scanner(System.in);

    private final int MAXStudentID = 999999;
    private final int MINStudentID = 100000;

    private final int MAXScore = 100;
    private int NumberOfLessons;

    private String name, surname;
    private int studentID;
    private int YearOfEducation;
    private String specialisation;
    private String faculty;
    private int group;
    private ArrayList<Integer> grades = new ArrayList<>();
    private ArrayList<String> lessons = new ArrayList<>();
    private ArrayList<Integer> studentsID = new ArrayList<>();
    private int currentPointer = 0;

    Student(){
        CheckID(getGeneratedID());
        studentID = studentsID.get(studentsID.size() - 1);
        YearOfEducation = 1;
    }

    Student(String name, String surname, String faculty, String specialisation){
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.specialisation = specialisation;
        CheckID(getGeneratedID());
        this.studentID = studentsID.get(studentsID.size() - 1);
        this.YearOfEducation = 1;
        this.group = 1 + (int)(Math.random() * 2);
    }

    public void setLessons(int Amount){
        NumberOfLessons = Amount;
        for(int counter = 0; counter < NumberOfLessons; counter++){
            System.out.print("Lesson[" + (counter + 1) + "]: ");
            lessons.add(scanner.nextLine());
        }
    }

    public void earnGrades(){
        for(int counter = 0; counter < NumberOfLessons; counter++){
            grades.add(1 + (int)(Math.random() * MAXScore));
        }
    }

    public void getGrades(){
        for(int counter = 0; counter < NumberOfLessons; counter++){
            System.out.println(lessons.get(counter) + ":" + grades.get(counter));
        }
    }

    private void CheckID(int ID) {
        boolean uniqueID = false;
        int tempID = ID;
        if(studentsID.size() == 0){
            studentsID.add(ID);
        } else {
            do{
                for(int counter = 0; counter < studentsID.size(); counter++){
                    if(studentsID.get(counter).equals(ID)){
                        System.err.println("Fatal ERROR! This ID is already exists! Trying to generate the new one...");
                        uniqueID = false;
                        tempID = getGeneratedID();
                        CheckID(tempID);
                    } else {
                        uniqueID = true;
                    }
                }
                if(uniqueID){
                    studentsID.add(tempID);
                }
            } while(uniqueID);
        }
    }

    private int getGeneratedID() {
        return (int)(Math.random() * (MAXStudentID - MINStudentID)) + MINStudentID;
    }

    @Override
    public String toString(){
        String info = "Student ID: " + this.studentID + "\nStudent NS: " + this.name + " " + this.surname + "\nFaculty: " + this.faculty + "\nSpecialisation: " + this.specialisation + "\nGroup: " + this.group;
        return info;
    }
}
