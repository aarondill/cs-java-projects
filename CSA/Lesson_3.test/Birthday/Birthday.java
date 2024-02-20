/**
 * Primary java class: name of the java class
 *  
 * Author:  your name here
 * Date:    mm/dd/yyyy
 * Course:  enter your course info here
 * Period:  enter your class period here
 *  
 * Summary of file:
 *      Short summary about the program
 *        - What does the program do
 *        - What are the inputs/outputs
 *
 */
 import java.util.Scanner;
 import java.util.InputMismatchException;
 import static java.lang.System.out;
 import static java.lang.System.err;
 public class Birthday {
   private static String getDay(int month, int day, int year){
     int total = (year % 100) / 4; // Divide the last two digits of the birth year by 4. Integer division!
     total += year % 100; // Add the last two digits of year to total
     total %= 7; // Divide total by 7 and put remainder back (mod)
     if (year >= 2100) total += 0; // Years > 21st century are undefined!
     else if (year >= 2000) total += 6; // See step d
     else if (year >= 1900) total += 0;
     else if (year >= 1800) total += 2;
     else if (year >= 1700) total += 4;
     else; // Years before 1700 are undefined!
     
     total += day; // Add the day integer to total
     
     // Magic numbers!! -- Much better as a switch expression.
     if(month == 1) total+=1; // January
     else if(month == 2) total+=4; // Feburary
     else if(month == 3) total+=4; // March
     else if(month == 4) total+=0; // April
     else if(month == 5) total+=2; // May
     else if(month == 6) total+=5; // June
     else if(month == 7) total+=0; // July
     else if(month == 8) total+=3; // August
     else if(month == 9) total+=6; // September
     else if(month == 10) total+=1; // October
     else if(month == 11) total+=4; // November
     else if(month == 12) total+=6; // December
     else throw new IllegalArgumentException("Why is month greater than 12 or less than 1? Do some data validation!");
     
     boolean isLeap;
     if (year % 100 == 0) isLeap = (year % 400) == 0;
     else isLeap = (year % 4) == 0;
     
     if(isLeap && month < 3) total -= 1; // If year is a leap year and month is January or February, subtract 1 from total
     
     total %= 7; // Find the remainder when total is divided by 7 (mod)
     return total == 1 ? "Sunday" // A set of magic numbers based on that remainder:
            : total == 2 ? "Monday"
            : total == 3 ? "Tuesday"
            : total == 4 ? "Wednesday"
            : total == 5 ? "Thursday"
            : total == 6 ? "Friday"
            : total == 0 ? "Saturday"
            : "Impossible";
   }
   public static void main(String[] args){
     int month, day, year;
     try(Scanner scan = new Scanner(System.in)){
        out.print("Enter the birth year: ");
        year = scan.nextInt();
        out.print("Enter the month [1 - 12]: ");
        month = scan.nextInt();
        if (month < 1 || month > 12) throw new IllegalArgumentException("Month must be between 1 - 12!");
        out.print("Enter the day of month [1 - 31]: ");
        day = scan.nextInt();
        if (day < 1 || day > 31) throw new IllegalArgumentException("Month must be between 1 - 31!");
     } catch (InputMismatchException e){
        err.println("Were my instructions unclear? Why did you think you could input a non-integer??");
        System.exit(1);
        return;
     }
     String dayOfWeek = getDay(month, day, year);
     out.printf("Your birthday, %d/%d/%d was on a %s.\n", month, day, year, dayOfWeek);
   }
 }