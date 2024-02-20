import java.util.Scanner;

/**
 * Class Lab4B2
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   May 04, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file:
 * 
 * Your physics teacher wants you to write a computer program for standard to
 * metric conversions. The input values will be a letter (‘P’ for pounds, ‘F’
 * for feet, or ‘M’ for miles) and a decimal value. The program is to make the
 * appropriate conversions. There are 4.9 newtons in a pound, 3.28 feet in a
 * meter, and 1.61 kilometers in a mile. The switch case action should produce
 * three values assigned to variables: the old unit label based on the input
 * character code, the new unit label based on the desired conversion unit, and
 * the calculated value of the desired conversion. No default case is necessary.
 * Output all values to two decimal places. The switch statement should NOT
 * directly produce any output.
 * 
 * EXPECTED OUTPUT
 * 3.11 miles = 5.00 kilometers
 * 125.00 pounds = 612.50 newtons
 * 120.00 feet = 36.59 meters
 * 7.20 pounds = 35.28 newtons
 * 56.00 feet = 17.07 meters
 * 100.00 miles = 161.00 kilometers
 */
public class Lab4B2 {
  public static void main(String[] args) {
    // This closes the scanner
    try (Scanner f = new Scanner(Lab4B2.class.getResourceAsStream("./lab4b2.in"))) {
      while (f.hasNext()) {
        char code = f.next().charAt(0);
        double measure1 = f.nextDouble();
        String unit1 = "", unit2 = "";
        double measure2;
        switch (code) {
          case 'M':
            measure2 = measure1 * 1.61;
            unit1 = "miles";
            unit2 = "kilometers";
            break;
          case 'P':
            measure2 = measure1 * 4.9;
            unit1 = "pounds";
            unit2 = "newtons";
            break;
          case 'F':
            measure2 = measure1 * 3.28;
            unit1 = "feet";
            unit2 = "meter";
            break;
          default:
            throw new IllegalArgumentException("Only M, P, and F are allowed.");
        }
        System.out.printf("%.2f %s = %.2f %s\n", measure1, unit1, measure2, unit2);
      }

    }

  }
}
