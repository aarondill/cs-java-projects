import java.util.Scanner;

/**
 * Class Lab4B1
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   May 04, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file:
 * Lab name: Phone Call 2
 * 
 * WAP to calculate the cost of a telephone call when a code number and the
 * length of the call is input. Output the two input values in a sentence along
 * with the cost of the call. Use a switch statement in which the case action
 * calculates by assigning to a variable the cost of the phone call based on the
 * code and number of minutes. The output statement should follow the switch
 * case statement. NO OUTPUT should be produced directly by the switch
 * statement.
 */
public class Lab4B1 {
  public static void main(String[] args) {
    // This closes the scanner
    try (Scanner f = new Scanner(Lab4B1.class.getResourceAsStream("./lab4B1.in"))) {
      // Processing loop, contains input, process and output
      while (f.hasNext()) {
        int code = f.nextInt();
        int min = f.nextInt();
        double cost = 0.0;
        switch (code) {
          case 1:
            cost = 0.22 * min;
            break;
          case 2:
            cost = .14 * min;
            break;
          case 3:
            cost = .73 * min;
            break;
          case 4:
            cost = 1.12 * min;
            break;
          case 5:
            cost = 2.38 * min;
            break;
        }
        System.out.printf("A code %d phone call for %d minutes costs $%.2f.\n", code, min, cost);
      }
    }
  }
}
