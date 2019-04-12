import java.io.File;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.ArrayList; 
import java.util.Scanner; 
 
/*
      Walther Alvarez
      CISC 500
      Assignment #7
      This is a program prompts the user 
      for an input and output file 
      that reads each line in a file, 
      reverses its lines, and writes them to another file. 
      For example, if the file input.txt contains the lines 
      Mary had a little lamb 
      Its fleece was white as snow 
      And everywhere that Mary went 
      The lamb was sure to go. 
      and you run 
      reverse input.txt output.txt 
      then output.txt contains 
      The lamb was sure to go. 
      And everywhere that Mary went 
      Its fleece was white as snow 
      Mary had a little lamb
*/ 
 
public class Assignment7 
{ 
   /**
   This method reads a file line by line and re
   turns the result in an array list.
   @param filename the file to read
   @return an array list with the lines in the file
   */
    public static ArrayList<String> changeLinesToArray(String filename) throws FileNotFoundException 
    { 
        ArrayList<String> lines = new ArrayList<String>(); 
        Scanner fileInput = new Scanner(new File(filename)); 
        while (fileInput.hasNextLine()) 
        { 
            String line = fileInput.nextLine(); 
            lines.add(line); 
        } 
        fileInput.close(); 
        return lines; 
    } 
    /**
   Write all lines in array list to given file in reverse order.
   @param filename the name of the file to write to
   @param lines the lines to write to the file
   */
    public static void reverseLines(ArrayList<String> lines, String filename) throws FileNotFoundException 
    { 
        PrintWriter fileOutput = new PrintWriter(new File(filename));
        for (int i = lines.size() - 1; i >= 0; i--) 
        { 
            fileOutput.println(lines.get(i));
        } 
        fileOutput.close(); 
    }
    public static void main(String[] args) throws FileNotFoundException 
    { 
        String filenameInput; 
        String filenameOutput; 
        if (args.length == 2) 
        { 
            filenameInput = args[0]; 
            filenameOutput = args[1]; 
        }   
        else 
        { 
            Scanner console = new Scanner(System.in); 
            System.out.print("Input file: "); 
            filenameInput = console.next(); 
            System.out.print("Output file: "); 
            filenameOutput = console.next(); 
            console.close(); 
        } 
 
        ArrayList<String> fileLines = changeLinesToArray(filenameInput); 
        reverseLines(fileLines, filenameOutput); 
    } 
   
}
