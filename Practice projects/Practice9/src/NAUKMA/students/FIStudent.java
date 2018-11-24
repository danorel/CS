package NAUKMA.students;

public class FIStudent extends Student{
    private String faculty = "Informatics faculty";
    private String specialisation;
    private String[] specList = {"CS", "PE", "PM"};

    public FIStudent(){
        super();
        super.faculty = this.faculty;
    }

    /**
     * @param name - the name of the student
     * @param surname - the surname of the student
     * @param YearOfEducation - the name of the student
     */
    public FIStudent(String name, String surname, int YearOfEducation){
        super(name, surname, YearOfEducation);
        super.faculty = faculty;
    }

    public void setSpecialisation(String specialisation){
        boolean isValidSpecialisation = false;
        for(int counter = 0; counter < specList.length; counter++){
            if(specialisation.equals(specList[counter])){
                isValidSpecialisation = true;
                super.specialisation = specialisation;
                break;
            } else if(counter == 2 && !isValidSpecialisation){
                System.out.println("Setting the default specialisation Computer Science");
                super.specialisation = "CS";
                break;
            }
        }
    }

    public void makeProgram(){
        int option = 1 + (int)(Math.random() * 2);
        int A, B;
        switch (option){
            case 1:
                System.out.println("This program will calculate the summary of 5 and -5.");
                calculateSummary(5, -5);
                break;
            case 2:
                System.out.println("This program will generate random number in this borders [1, 100].");
                do{
                    A = 1;
                    B = 100;
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
