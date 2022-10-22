import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Make a program that reads a file and saves all the integer in a string separated by commas

public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        // file is the first args
        try{
            File file = new File(args[0]);
        

            Scanner sc = new Scanner(file);
            // Count the number of lines in the file
            int count = 0;
            while(sc.hasNextLine()){
                sc.nextLine();
                count++;
            }
            String[] lines = new String[count];
            sc = new Scanner(file);
            // Save the lines in an array
            for(int i = 0; i < count; i++){
                lines[i] = sc.nextLine();
            }
            // if the lines contain a / save all the characters before the / in a string
            for(int i = 0; i < count; i++){
                if(lines[i].contains("/")){
                    lines[i] = lines[i].substring(0, lines[i].indexOf("/"));
                }
            }
            // keep parsing the lines as integers. if there is an exception, ignore it
            for(int i = 0; i < count; i++){
                try{
                    Integer.parseInt(lines[i]);
                }catch(Exception e){
                    lines[i] = "";
                }
            }
            // remove all the empty strings from the array
            String[] newLines = new String[count];
            int j = 0;
            for(int i = 0; i < count; i++){
                if(!lines[i].equals("")){
                    newLines[j] = lines[i];
                    j++;
                }
            }

            // print the array without the brackets
            for(int i = 0; i < j; i++){
                System.out.print(newLines[i]);
                if(i != j - 1){
                    System.out.print(",");
                }
            }
        }catch(Exception e){
            System.out.println("ERROR: NO FILE PATH PROVIDED");
        }
    }
}