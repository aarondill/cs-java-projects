import java.util.Scanner;

/**
 * Class Lab4B4
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   May 04, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: The Saffir/Simpson Hurricane Scale rates hurricanes on a
 * scale of 1 to 5, 1 being the weakest, 5 the strongest. Below is an
 * abbreviated version, with two items listed for each category: wind speed and
 * the expected storm surge water level.
 *
 * Write a program containing a switch case statement to input an integer value
 * representing the hurricane category and output a sentence describing what to
 * expect with each.
 *
 * <code>
 * - Category 1 – Winds 74-95 mph, storm surge of 4-5 ft.
 * - Category 2 – Winds 96-110 mph, storm surge of 6-8 ft.
 * - Category 3 – Winds 111-130 mph, storm surge of 9-12 ft.
 * - Category 4 – Winds 131-155 mph, storm surge of 13-18 ft.
 * - Category 5 – Winds 155 mph+, storm surge of 18+ feet.
 *</code>
 *
 * DATA FILE ("lab4B4.in") 1 3 5
 *
 * EXPECTED OUTPUT <code>
 * Category 1 - Winds 74-95 mph, storm surge of 4-5 ft.
 * Category 3 - Winds 111-130 mph, storm surge of 9-12 ft.
 * Category 5 - Winds 155 mph+, storm surge of 18+ feet.
 * </code>
 */
public class Lab4B4 {
  public static void main(String[] args) {
    // This closes the scanner
    try (Scanner f =
        new Scanner(Lab4B4.class.getResourceAsStream("./lab4b4.in"))) {
      while (f.hasNextInt()) {
        int cat = f.nextInt();
        String s = "";
        switch (cat) {
          case 1:
            s = "Category 1 - Winds 74-95 mph, storm surge of 4-5 ft.";
            break;
          case 2:
            s = "Category 2 - Winds 96-110 mph, storm surge of 6-8 ft.";
            break;
          case 3:
            s = "Category 3 - Winds 111-130 mph, storm surge of 9-12 ft.";
            break;
          case 4:
            s = "Category 4 - Winds 131-155 mph, storm surge of 13-18 ft.";
            break;
          case 5:
            s = "Category 5 - Winds 155 mph+, storm surge of 18+ feet.";
            break;
          default:
            throw new IllegalArgumentException("Scale must be between 1 and 5");
        }
        System.out.println(s);
      }
    }
  }
}
