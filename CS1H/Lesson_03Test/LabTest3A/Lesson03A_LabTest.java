// Used for input from stdin
import java.util.Scanner;
// Used in getInput()
import java.util.function.Supplier;
/**
 * public class Lesson03A_LabTest
 *  
 * Author:  Aaron Dill
 * Date:    4/6/2023
 * Course:  CSI H
 * Period:  4th
 *  
 * Summary of file:
 * Write a program to input five items from the keyboard and output them as shown in the example below.
 * The five items are:
 * 
 * Your first name (string variable)
 * Your middle initial (character variable)
 * Your age (integer variable)
 * The city where you live (String variable, with comma after the city, then a space, then the state)
 * Your current estimated GPA (decimal variable) 
 * 
 * Here is a sample program run using Samantha E, age 19, from Boise, Idaho, with an estimated GPA of 3.5.
 * Enter your first name--> Samantha
 * Enter your middle initial--> E
 * Enter your age--> 19
 * Enter your city and state, with a space after the comma--> Vancouver, BC
 * Enter your estimated GPA--> 4.0
 *
 * My name is Samantha E,
 * and I am 19 years old.
 * I live in Vancouver, BC,
 * and my GPA is around 4.0
 * (<== cursor must end up here in the output window)
 */
public class Lesson03A_LabTest{
   /**
    * Utility method to print the prompt, call getData, 
    * call scan.nextLine to discard unused input, and return the value of getData
    */
   private static <T> T getInput(String prompt, Supplier<T> getData, Scanner scan){
      System.out.print(prompt);
      T r = getData.get();
      if(scan.hasNextLine()) scan.nextLine();
      return r;
   }
   /** Overload that doesn't take a scanner or call nextLine (mostly for use with nextLine) */
   private static <T> T getInput(String prompt, Supplier<T> getData){
      System.out.print(prompt);
      T r = getData.get();
      return r;
   }
   
   /** shorter/varargs version of System.out.println */
   private static void sysout(String... strArr){
      if(strArr.length == 0){
         System.out.println();
         return;
      }
      for(String str : strArr){
         System.out.println(str);
      }
   }
   /** System.out.printf, but nicer */
   private static void sysoutf(String format, Object... args){
      if(format.matches(".*\n$")) System.out.printf(format, args);
      else System.out.printf(format+'\n', args);
   }
   
   public static void main(String... args){
      // Declare variables for use in surrounding scope - Assigned within try-with-resources
      String firstName, cityAndState;
      char middleInitial;
      int age;
      double GPA;
      // This will auto close the scanner at the end of block or if something throws.      
      try(Scanner scan = new Scanner(System.in)){
         /*
          * This is the input section.
          * It will input a person’s first name,
          * middle initial, age, city and state, and GPA,
          * and output all to the screen.
          */         
         firstName = getInput("Enter your first name--> ", scan::next, scan);
         middleInitial = getInput("Enter your middle initial--> ", scan::next, scan).charAt(0);
         age = getInput("Enter your age--> ", scan::nextInt, scan);
         // Use overload that doesn't call extra nextLine()
         cityAndState = getInput("Enter your city and state, with a space after the comma--> ", scan::nextLine);
         GPA = getInput("Enter your estimated GPA--> ", scan::nextDouble, scan);
                  
         // Redundant closing
         scan.close();
      }
      // This is the output section.
      // print empty line
      sysout();
      // print name and mid initial
      sysoutf("My name is %s %c,", firstName, middleInitial);
      // print age
      sysoutf("and I am %d years old.", age);
      // print city and state
      sysoutf("I live in %s,", cityAndState);
      // print GPA to one decimal place
      sysoutf("and my GPA is around %.1f", GPA);
   }
}