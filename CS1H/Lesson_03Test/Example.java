/**
 * public class Example
 *  
 * Author:  Aaron Dill
 * Date:    04/24/2023
 * Course:  H Computer Science I
 * Period:  4th period
 *  
 * Summary of file:
 *     
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
public class Example{
   private static void log(Object... strArr){ for(Object s : strArr) System.out.println(s); }
   private static void logf(String format, Object... objArr){ 
      ArrayList<Object> args = new ArrayList<>();
      args.add(format);
      for(Object o : objArr) args.add(o);
      System.out.printf(format+"\n", objArr); 
   }
   private static void err(Object... strArr){ for(Object s : strArr) System.err.println(s); }
   
   /** This exits the program if the file isn't found, or the callback throws a NoSuchElementException. 
     * In any other case, the error is elevated, or else the value returned by cb is returned.
     */
   public static <T> T getInputFromFile(String inputFileName, Function<Scanner, T> cb){
         // This try-with-resources closes the scanner at the end of the block
      try(Scanner input = new Scanner(new File(inputFileName))){
         return (cb.apply(input));
         // If file couldn't be found (thrown by scanner)
      } catch(FileNotFoundException e){
         err("ERROR: ", e);
         err("Something went wrong finding your file. Please ensure it's located at the path '"+inputFileName+"'");
         System.exit(2);
         // If something wasn't there 
      } catch (NoSuchElementException e){
         err("ERROR: ", e);
         err("Something went wrong finding all the data from the input file. Please ensure it's in the correct order and matches the program specifications.");
         System.exit(2);
      }      
      return null; // This statement should never be reached.
   }

   public static void main(String... args){
      int i = getInputFromFile("example.in", scan -> scan.nextInt());
      log(i);
   }
}
 
 
 