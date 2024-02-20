/**
 * public class LabTest4B
 *  
 * Author:  Aaron Dill
 * Date:    05/12/2023
 * Course:  CSI H
 * Period:  4th Period
 *  
 * Summary of file:
 * Write a program to input an employee’s name,
 * a code indicating that employee’s pay level,
 * and an integer representing the number of
 * hours they worked in a week.
 *
 * Using a switch statement and the input code as
 * the control variable, for a code ‘A’, the hourly
 * wage is $7.25, for ‘B’ $8.50 an hour, code ‘C’ 
 * $10.00, code ‘D’ $12.50, and code ‘E’ $15 per
 * hour. The number of hours will vary between 1 
 * and 40 hours.
 *
 */

import java.util.Scanner;
import java.io.InputStream;

public class LabTest4B{
  private static void log(Object... strs){ for(Object str : strs) System.out.println(str); }
  private static void logf(String fmt, Object... objs){ System.out.printf(fmt+"\n", objs); }
  private static void err(Object... strs){ for(Object str : strs) System.err.println(str); }
  public static void main(String... args){
    String filename="labTest4B.in";
    InputStream fileStream = LabTest4B.class.getResourceAsStream(filename);
    if(fileStream == null){
      err("Could not find your input file. Please make sure it's named "+filename+", or if this is a bug, please alert Aaron Dill.");
      System.exit(2);
    }
    // This closes the scanner
    try(Scanner scan = new Scanner(fileStream)){
     // Main program loop, does input, processing, and output
     // Assumes data file is correct.
     while (scan.hasNextLine()){
       // This is the *only* safe part of this program.
       String line=scan.nextLine();
       // I was told we don't care about resource usage, I'll take *all* that memory then.
       Scanner lineScan=new Scanner(line);
       // No one is allowed to have multiple names or a space in their name. If they do, we fire them.
       String name = lineScan.next();
       // If it's length 0, this fails, but we're taking the happy path :)
       char code = lineScan.next().charAt(0);
       // You don't get paid for half an hours work! Clock out! But you worked a total of 9 hours from partial hours? I don't care!
       // PS: Overtime is not permitted. Absolutely NO unapproved overtime, or, you guessed it, you're fired and no pay.
       int hours = lineScan.nextInt();
       if (hours > 40) throw new IllegalArgumentException("Overtime is not permitted. "+name+", come see me in my office.");
       if (hours < 0) throw new IllegalArgumentException("Stop trying to cheat the system. "+name+", fix it, then clock out and don't come back.");
       // If you mess up my program, you get *nothing*
       double wage=0.0;
       // Switch *statment*. If expressions were permitted, This could be one line, without a temporary assignment.
       switch(code){
       case 'A': wage=7.25;break;
       case 'B': wage=8.50;break;
       case 'C': wage=10.00;break;
       case 'D': wage=12.50;break;
       // Man, I need a raise.
       case 'E': wage=15.00;break;
       default: throw new IllegalArgumentException("I warned you "+name+". You're fired. Now fix the input and go home.");
       }
       // Overtime will not be paid. I told you to clock out.
       double totalPay = hours * wage;
       logf("%s's pay for %d hours worked is $%.2f", name, hours, totalPay);
     }
    } catch(Exception e){
      err("Man, something went wrong, but I don't have the time to figure it out. Here's the error: ", e);
      System.exit(1);
    }
  }
}