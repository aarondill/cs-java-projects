import java.util.Scanner;

/**
 * Primary java class: DaysInAMonth
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/19/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 3.4.2 – DaysInAMonth - Write a program that will ask the user for a month
 * number, (1 – 12), and will output the month as a String and the number of
 * days in that month. If the user inputs a number that is out of range, print
 * an appropriate message.
 *
 */
public class DaysInAMonth {
  static String name;
  static int days;

  private static void set(String pname, int pdays) {
    name = pname;
    days = pdays;
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the month number (1 - 12): ");
      int month = scan.nextInt();
      if (month < 1 || month > 12) {
        System.err.printf("Invalid month '%d'. Valid months are between 1 and 12.", month);
        System.exit(1);
      }
      if (month == 1)
        set("January", 31);
      else if (month == 2)
        set("February", 29);
      else if (month == 3)
        set("March", 31);
      else if (month == 4)
        set("April", 30);
      else if (month == 5)
        set("May", 31);
      else if (month == 6)
        set("June", 30);
      else if (month == 7)
        set("July", 31);
      else if (month == 8)
        set("August", 31);
      else if (month == 9)
        set("September", 30);
      else if (month == 10)
        set("October", 31);
      else if (month == 11)
        set("November", 30);
      else if (month == 12)
        set("December", 31);
      System.out.printf("%s has %d days.\n", name, days);
    }
  }
}
