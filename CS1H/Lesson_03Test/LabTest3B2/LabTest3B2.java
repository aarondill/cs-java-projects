/**
 * public class LabTest3B2
 *  
 * Author:  Aaron Dill
 * Date:    04/24/2023
 * Course:  H Computer Science I
 * Period:  4th period
 *  
 * Summary of file:
 *      Write a program to input several words from a data file and output them in alphabetical order, using the Advanced
 *      Technique #1 as shown in the lesson. Use an ArrayList of Strings, a while loop to load the data from the file, the
 *      Collections.sort method to alphabetize the list, and a for each loop to output the list.
 *      The data file will be called: "labTest3B2.in".
 *      Here is a sample:
 *      orange
 *      apple
 *      grape
 *      banana
 *      pineapple
 *      kiwi
 *      Here is the expected output:
 *      apple
 *      banana
 *      grape
 *      kiwi
 *      orange
 *      pineapple
 *      (<== cursor must end up here in the output window)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
public class LabTest3B2{
  private static void log(Object... strArr){ for(Object s : strArr) System.out.println(s); }
  private static void logf(String format, Object... objArr){ 
     ArrayList<Object> args = new ArrayList<>();
     args.add(format);
     for(Object o : objArr) args.add(o);
     System.out.printf(format+"\n", objArr); 
  }
  private static void err(Object... strArr){ for(Object s : strArr) System.err.println(s); }

  public static void main(String... args){
     String inputFileName = "labTest3B2.in";
     ArrayList<String> fruits = new ArrayList<>();
     // This try-with-resources closes the scanner at the end of the block
     try(Scanner input = new Scanner(new File(inputFileName))){
        // Add every line to the fruits array.
        // No handling is done if the array is empty, as it causes no issues, but this is likely a mistake by the user.
        while(input.hasNextLine()) fruits.add(input.nextLine());
        // If file couldn't be found (thrown by scanner)
     } catch(FileNotFoundException e){
        err(e);
        err("Something went wrong finding your file. Please ensure it's named "+inputFileName);
        System.exit(1);
        return;
     }
     // Exactly identical to fruits.sort(null). In fact, that's what this method does, is call list.sort(null);
     // Additionally, this requires an additional import from java.util.Collections, while fruits.sort(null) would require no such import.
     // This call will sort by "natural ordering", which is determined by str1.compareTo(str2), and is equivelent to lexographical ordering.
     Collections.sort(fruits);    
     // Output each fruit in the list (now sorted)
     for(String f : fruits) log(f);
  }
}
 
 
 