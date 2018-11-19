package NAUKMA.students;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private Scanner scanner = new Scanner(System.in);
    private String info = "";

    private final int MAXStudentID = 999999;
    private final int MINStudentID = 100000;

    private final int MAXScore = 100;
    private int NumberOfLessons;

    private String name, surname;
    private int studentID;
    private int YearOfEducation;
    private String specialisation;
    private ArrayList<Integer> grades = new ArrayList<>();
    private ArrayList<String> lessons = new ArrayList<>();

    Student(){
        studentID = getUniqueID();
        YearOfEducation = 1;
        setNS();
        setSpecialisation();
    }

    private void setSpecialisation() {
        System.out.print("What is your specialisation? (Sample: 'Computer Science') Answer: ");
        String specialisation = scanner.nextLine();
        this.specialisation = specialisation;
    }

    private void setNS() {
        System.out.print("What is your name and surname? (Sample: 'George Lobanoff') Answer: ");
        String NS = scanner.nextLine();
        String []StudentInit = NS.split(" ");
        this.name = StudentInit[0];
        this.surname = StudentInit[1];
    }

    Student(String name, String surname, String faculty, String specialisation, int YearOfEducation){
        this.name = name;
        this.surname = surname;
        this.specialisation = specialisation;
        this.YearOfEducation = YearOfEducation;
        this.studentID = getUniqueID();
    }


    public void saveInformationAboutStudent(Student student, String dir, String fileName){
        try {
            File directory = new File(dir);
            directory.mkdir();
            FileWriter fileWriter = new FileWriter(dir + "/" + fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(info);
            writer.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void getInformationAboutStudent(String dir, String fileName){
        try{
            FileReader fileReader = new FileReader(dir + "/" + fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String str = null;
            while((str = reader.readLine()) != null){
                System.out.println(str);
            }
            reader.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void getStudentIDFromFile(String dir, String fileName){
        try{
            FileReader fileReader = new FileReader(dir + "/" + fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String []array = reader.readLine().split(" ");
            reader.close();
            System.out.println(array[2]);
        } catch(Exception exception){
            exception.printStackTrace();
        }
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

    private int getUniqueID() {
        boolean uniqueID = false;
        int ID = getGeneratedID();

        return ID;
    }

    private int getGeneratedID() {
        return (int)(Math.random() * (MAXStudentID - MINStudentID)) + MINStudentID;
    }

    @Override
    public String toString(){
        this.info = "Student ID: " + this.studentID + "\nStudent NS: " + this.name + " " + this.surname + "\nSpecialisation: " + this.specialisation + "\nYear of education: " + YearOfEducation;
        return info;
    }
}
