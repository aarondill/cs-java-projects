/**
 * public class LabTest4A
 *  
 * Author:  Aaron Dill
 * Date:    05/12/2023
 * Course:  CSI H
 * Period:  4th Period
 *  
 * Summary of file:
 * Write a program to input the number of hours Megan worked in
 * a week at minimum wage (currently $7.25 in Texas) and output
 * the total pay for that week, in dollar format.  If she worked
 * 40 hours or less, she gets paid for the hours she worked (hours
 * times wage), but if she works more than 40 hours, she gets paid
 * time-and-a-half for all of the hours over 40.  For example, the
 * pay for a 50 hour work week would be calculated like this: 
 * 40 X 7.25 + 10 X 7.25 X 1.5
 *
 */

import java.util.Scanner;
import java.io.InputStream;

public class LabTest4A{
  final static double WAGE=7.25;
  final static String NAME="Megan";
 
  private static void log(Object... strs){ for(Object str : strs) System.out.println(str); }
  private static void logf(String fmt, Object... objs){ System.out.printf(fmt+"\n", objs); }
  private static void err(Object... strs){ for(Object str : strs) System.err.println(str); }
  public static void main(String... args){
    String filename="labTest4A.in";
    InputStream fileStream = LabTest4A.class.getResourceAsStream(filename);
    if(fileStream == null){
      err("Could not find your input file. Please make sure it's named "+filename+", or if this is a bug, please alert Aaron Dill.");
      System.exit(2);
    }
    // This closes the scanner
    try(Scanner scan = new Scanner(fileStream)){
     // Main program loop, does input, processing, and output
     // Assumes data file is correct.
     while (scan.hasNextInt()){
       int hours = scan.nextInt();
       double total=0;
       if (hours <= 40) total=hours*WAGE;
       else total= (40*WAGE) + ((hours-40)*WAGE*1.5);
       logf("%s's pay for %d hours worked is $%.2f", NAME, hours, total);
     }
    } catch(Exception e){
      err("Man, something went wrong, but I don't have the time to figure it out. Here's the error: ", e);
      System.exit(1);
    }
  }
}