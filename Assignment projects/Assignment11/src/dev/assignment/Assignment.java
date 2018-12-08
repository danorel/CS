package dev.assignment;

import java.io.*;

public class Assignment {

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
//        assignment.changeSubstring("data", "file.txt", "kek", "lol");
//        assignment.copyDataFromFileToFile("input_data", "input.txt", "output_data", "output.txt");
//        assignment.OddAndEvenData("data", "file.txt");
//        assignment.cypherTheFile("data", "file.txt", "cypher_data", "cypher.txt");
//        assignment.recypherTheFile("cypher_data", "cypher.txt", "re-cypher.txt");

    }

    public void changeSubstring(String dir, String src, String substr, String str){
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

    public void copyDataFromFileToFile(String input_dir, String input_src, String output_dir, String output_src){
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

    public void OddAndEvenData(String dir, String src){
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

    public void cypherTheFile(String dir, String src, String cypher_dir, String cypher_src){
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

    public void recypherTheFile(String dir, String src, String to_src){
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
