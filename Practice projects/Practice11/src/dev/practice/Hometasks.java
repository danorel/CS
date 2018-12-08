package dev.practice;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Hometasks {

    private Scanner dialog = new Scanner(System.in);
    private String src = "file.txt";

    public static void main(String[] args) {
        Hometasks hometasks = new Hometasks();
        hometasks.chooseFunction();
    }

    private void chooseFunction() {
        System.out.println("1. BorderTheNumber");
        System.out.println("2. RemoveChar");
        System.out.println("3. GetInformationFromFile");
        System.out.println("4. LookForString");
        System.out.println("What func do u want to test? Answer: ");
        int answer = dialog.nextInt();
        switch (answer){
            case 1:
                Hometasks.borderTheNumber();
                break;
            case 2:
                System.out.print("What char do u want to find? Answer: ");
                String ch = dialog.next();
                System.out.println(Hometasks.removeChar("Daniel, Orel, What, Do, U, Do", ch.charAt(0)));
                break;
            case 3:
                Hometasks.getInformationFromFile(src);
                break;
            case 4:
                System.out.print("What string do u want to find? Answer: ");
                String string = dialog.next();
                System.out.println(Hometasks.lookForString(src, string));
                break;
            default:
                System.out.println("FAILED! Not legal value!");
                break;
        }
    }

    public static void borderTheNumber(){
        Scanner scanner = new Scanner(System.in);
        long number;
        do{
            System.out.print("Enter the Integer number: (0 to exit)");
            number = scanner.nextLong();
            if(number == 0) break;
            else {
                String str_number = Long.toString(number);
                System.out.println(str_number);
            }
        } while(number != 0);
    }


    public static String removeChar(String str, char ch){
        String []strings = str.split(Character.toString(ch));
        String concatenate_strings = "";
        for(String current_str : strings){
            concatenate_strings += current_str;
        }
        if(concatenate_strings.equals("")) concatenate_strings = null;
        return concatenate_strings;
    }

    public static void getInformationFromFile(String src){
        File directory = new File("data");
        directory.mkdir();
        try{
            FileReader FileReader = new FileReader("data/" + src);
            BufferedReader reader = new BufferedReader(FileReader);
            String str;
            while((str = reader.readLine()) != null){
                System.out.println(str);
            }
            reader.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public static boolean lookForString(String src, String str){
        boolean isFound = false;
        try{
            FileReader FileReader = new FileReader("data/" + src);
            BufferedReader reader = new BufferedReader(FileReader);
            String current_str;
            while((current_str = reader.readLine()) != null){
                if(current_str.equals(str)){
                    isFound = true;
                }
            }
            reader.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
        return isFound;
    }
}
