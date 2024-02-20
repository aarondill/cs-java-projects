import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
 * Class Lab3B1
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 12, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * This lab inputs from a file a person's name and then outputs in three
 * different formats.
 * 
 */

public class Lab3B1 {
    public static void main(String[] args) throws IOException {
        String first, last;
        char middle;
        Scanner in = new Scanner(new File("lab3b1.in"));
        // INPUT
        first = in.nextLine();
        middle = in.nextLine().charAt(0);
        last = in.nextLine();
        in.close();
        // OUTPUT
        System.out.printf("%s %c. %s\n", first, middle, last);
        System.out.printf("%s, %s %c.\n", last, first, middle);
        System.out.printf("%c%c%c\n", first.charAt(0), middle, last.charAt(0));
    }
}
