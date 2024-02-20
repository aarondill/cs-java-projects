/**
 * public class LabTest3B1
 *  
 * Author:  Aaron Dill
 * Date:    04/24/2023
 * Course:  H Computer Science I
 * Period:  4th period
 *  
 * Summary of file:
 *     Write a program to input five items from a data file called “labTest3B1.in” and output them as shown in the
 *     example below.
 *     The five items are:
 *     • A first name (string variable)
 *     • A middle initial (character variable)
 *     • An age (integer variable)
 *     • A city and state (String variable, with comma after the city, then a space, then the state)
 *     • A GPA value (decimal variable)
 *     Put a multi-line comment block in the program source code before the input section that says:
 *     This is the input section.
 *     It will input a person’s first name,
 *     middle initial, age, city and state, and GPA,
 *     and output all to the screen.
 *     Also put a single line comment before the output portion of the program that simply says:
 *     This is the output section.
 *     Here is a sample program run using Susie Q, age 16, from Boise, Idaho, with an estimated GPA of 3.5.
 *     Sample data file
 *     Susie
 *     Q
 *     16
 *     Boise, Idaho
 *     3.5
 *     Expected output
 *     My name is Susie Q,
 *     and I am 16 years old.
 *     I live in Boise, Idaho,
 *     and my GPA is around 3.5.
 */
 import java.util.Scanner;
 import java.util.ArrayList;
 import java.io.*;
 import java.util.NoSuchElementException;
 public class LabTest3B1{
   private static void log(Object... strArr){ for(Object s : strArr) System.out.println(s); }
   private static void logf(String format, Object... objArr){ 
      ArrayList<Object> args = new ArrayList<>();
      args.add(format);
      for(Object o : objArr) args.add(o);
      System.out.printf(format+"\n", objArr); 
   }
   private static void err(Object... strArr){ for(Object s : strArr) System.err.println(s); }
   
   public static void main(String... args){
      String inputFileName = "labTest3B1.in";
      String fName, cityAndState; char mInitial; int age; double gpa;
      // This try-with-resources closes the scanner at the end of the block
      try(Scanner input = new Scanner(new File(inputFileName))){
         /*
          * This is the input section.
          * It will input a person’s first name,
          * middle initial, age, city and state, and GPA,
          * and output all to the screen.
          */
         // Use nextLine instead of next for all inputs because it avoids the potential errors from using next followed by nextLine.
         fName = input.nextLine();
         mInitial = input.nextLine().charAt(0);
         age = input.nextInt(); input.nextLine();
         cityAndState = input.nextLine();
         gpa = input.nextDouble();
         // If file couldn't be found (thrown by scanner)
      } catch(FileNotFoundException e){
         err(e);
         err("Something went wrong finding your file. Please ensure it's named "+inputFileName);
         System.exit(1);
         return;
         // If something wasn't there 
      } catch (NoSuchElementException e){
         err(e);
         err("Something went wrong finding all the data from the input file. Please ensure it's in the correct order and matches the program specifications.");
         System.exit(1);
         return;
      }
      // This is the output section.
      logf("My name is %s %c,", fName, mInitial);
      logf("and I am %d years old.", age);
      logf("I live in %s,", cityAndState);
      logf("and my GPA is around %.1f.", gpa);
   }
 }
 
 
 