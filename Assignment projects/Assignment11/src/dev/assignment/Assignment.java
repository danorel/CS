package dev.assignment;

import java.io.*;
import java.util.Scanner;

public class Assignment {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
        assignment.functionChooser();
    }

    public void functionChooser(){
        System.out.println("1. ChangeSubstring");
        System.out.println("2. CopyDataFromFileToFile");
        System.out.println("3. OddAndEvenData");
        System.out.println("4. CypherTheFile");
        System.out.println("5. Re-cypherTheFile");
        System.out.print("Enter the number of function to call: ");
        int answer = scanner.nextInt();
        switch(answer){
            case 1:
                Assignment.changeSubstring("data", "file.txt", "$", "<3");
                break;
            case 2:
                Assignment.copyDataFromFileToFile("input_data", "input.txt", "output_data", "output.bak");
                break;
            case 3:
                Assignment.OddAndEvenData("data", "file.txt");
                break;
            case 4:
                Assignment.cypherTheFile("data", "file.txt", "cypher_data", "cypher.txt");
                break;
            case 5:
                Assignment.recypherTheFile("cypher_data", "cypher.txt", "re-cypher.txt");
                break;
            default:
                System.out.println("Fatal ERROR! Not valid input.");
                break;
        }
    }

    public static void changeSubstring(String dir, String src, String substr, String str){
        try{
            File directory = new File(dir);
            directory.mkdir();
            FileReader FileReader = new FileReader(dir + "/" + src);
            BufferedReader reader = new BufferedReader(FileReader);
            String current_str;
            while((current_str = reader.readLine()) != null){
                if(current_str.equals(substr)){
                    current_str = current_str.replace(substr, str);
                }
                System.out.println(current_str);
            }
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void copyDataFromFileToFile(String input_dir, String input_src, String output_dir, String output_src){
        try{
            File input_directory = new File(input_dir);
            input_directory.mkdir();

            File output_directory = new File(output_dir);
            output_directory.mkdir();

            FileReader FileReader = new FileReader(input_dir + "/" + input_src);
            BufferedReader reader = new BufferedReader(FileReader);

            String current_str;
            String output_data = "";
            while((current_str = reader.readLine()) != null){
                output_data += current_str + "\n";
            }
            reader.close();
            FileWriter FileWriter = new FileWriter(output_dir + "/" + output_src);
            BufferedWriter writer = new BufferedWriter(FileWriter);
            writer.write(output_data);
            writer.close();

        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void OddAndEvenData(String dir, String src){
        try{
            File directory = new File(dir);
            directory.mkdir();
            FileReader FileReader = new FileReader(dir + "/" + src);
            BufferedReader reader = new BufferedReader(FileReader);

            File output_directory = new File("output_data");
            output_directory.mkdir();

            FileWriter OddFileWriter = new FileWriter("output_data/" + "odd_output.txt");
            BufferedWriter odd_writer = new BufferedWriter(OddFileWriter);

            FileWriter EvenFileWriter = new FileWriter("output_data/" + "even_output.txt");
            BufferedWriter even_writer = new BufferedWriter(EvenFileWriter);

            String current_str;
            int counter = 0;
            while((current_str = reader.readLine()) != null){
                if(counter % 2 == 0) odd_writer.write(current_str + "\n");
                else even_writer.write(current_str + "\n");
                counter++;
            }
            even_writer.close();
            odd_writer.close();
            reader.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void cypherTheFile(String dir, String src, String cypher_dir, String cypher_src){
        try{
            File directory = new File(dir);
            directory.mkdir();

            File cypher_directory = new File(cypher_dir);
            cypher_directory.mkdir();

            FileWriter FileWriter = new FileWriter(cypher_dir + "/" + cypher_src);
            BufferedWriter writer = new BufferedWriter(FileWriter);

            FileReader FileReader = new FileReader(dir + "/" + src);
            BufferedReader reader = new BufferedReader(FileReader);
            String str;
            while ((str = reader.readLine()) != null){
                str += "\n";
                for(int counter = 0; counter < str.length(); counter++){
                    char ch = str.charAt(counter);
                    ch = (char)(ch + 1);
                    writer.write(Character.toString(ch));
                }
            }
            writer.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void recypherTheFile(String dir, String src, String to_src){
        try{
            File directory = new File(dir);
            directory.mkdir();

            FileWriter FileWriter = new FileWriter(dir + "/" + to_src);
            BufferedWriter writer = new BufferedWriter(FileWriter);

            FileReader FileReader = new FileReader(dir + "/" + src);
            BufferedReader reader = new BufferedReader(FileReader);

            String str;
            while ((str = reader.readLine()) != null){
                for(int counter = 0; counter < str.length(); counter++){
                    char ch = str.charAt(counter);
                    ch = (char)(ch - 1);
                    writer.write(Character.toString(ch));
                }
            }
            writer.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
