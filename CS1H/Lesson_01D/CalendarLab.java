
/**
 * Class CalendarLab
 *
 *
 * Author1: Aaron Dill 
 * Author2: None 
 * Date: January 09, 2023
 * Course: Computer
 * Science I Honors
 *
 *
 * Summary of file: Write a program using the Calendar class to output a summary
 * of your birthday. The output should match in format exactly, except for the
 * information, of course.
 *
 *
 */
import java.util.Calendar;

class CalendarLab {
    /**
     * <pre>
     * output:
     * The current date and time is: Thu Jan 06 08:05:09 CST 2022
     * My name is Aaron J. Dill.
     * I was born at 06:15:36 AM on a Tuesday,
     * the 21st day of July in the year 1964.
     * This was the 203rd day of the year.
     * </pre>
     */
    public static void main(String[] args) {
        String name = "Aaron J Dill";
        Calendar today = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        birthday.set(2006, 3, 14, 0, 0, 0);
        System.out.printf("The current date and time is: %tc\n", today);
        System.out.printf("My name is %s.\n", name);
        System.out.printf("I was born at %tr on a %tA,\n", birthday, birthday);
        System.out.printf("the %teth day of %tB in the year %tY.\n", birthday, birthday, birthday);
        System.out.printf("This was the %tjth day of the year.\n", birthday);
    }
}
