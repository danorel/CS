package NAUKMA.students;

import java.util.ArrayList;

public class FIStudent extends Student {
    private String faculty = "Informatics faculty";

    private String[] specList = {"CS", "PE", "PM"};

    public FIStudent(){
        super();
        super.faculty = faculty;
        setSpecialisation();
    }

    /**
     * @param name - the name of the student
     * @param surname - the surname of the student
     * @param YearOfEducation - the name of the student
     */
    public FIStudent(String name, String surname, int YearOfEducation){
        super(name, surname, YearOfEducation);
        setSpecialisation();
        super.faculty = faculty;
    }

    private void setSpecialisation(){
        System.out.println("Enter your specialisation from the spec list: ");
        for(int counter = 0; counter < specList.length; counter++){
            System.out.println((counter + 1) + ". "+ specList[counter]);
        }
        specialisation = scanner.nextLine();
    }

    public void makeProgram(){
        int option = 1 + (int)(Math.random() * 2);
        int A, B;
        switch (option){
            case 1:
                System.out.println("Enter the numbers A and B. This program will calculate the summary of A and B.");
                System.out.print("A: ");
                A = scanner.nextInt();
                System.out.print("B: ");
                B = scanner.nextInt();
                calculateSummary(A, B);
                break;
            case 2:
                System.out.println("Enter the restrictions [A, B]. This program will generate random number in this borders.");
                do{
                    System.out.print("A: ");
                    A = scanner.nextInt();
                    System.out.print("B: ");
                    B = scanner.nextInt();
                    if(A > B){
                        System.err.println("Fatal error, A > B! Re-enter the borders.");
                    }
                } while(A > B);
                randomizer(A, B);
                break;
            default:
                break;
        }
    }

    private void calculateSummary(int A, int B){
        System.out.println(A + " + " + B + " = " + (A + B));
    }

    private void randomizer(int RestrictionA, int RestrictionB){
        System.out.println("Random number is : " + (RestrictionA + (int)(Math.random() * (RestrictionB - RestrictionA))));
    }
}
