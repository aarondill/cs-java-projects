package Name;

import java.util.Scanner;

/**
 * Class Name
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 23, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * This lab inputs from the keyboard a person's name and then outputs in three
 * different formats.
 * 
 */

public class Name {
    public static void main(String[] args) {
        String first, last;
        char middle;
        Scanner in = new Scanner(System.in);
        // INPUT
        System.out.print("Enter your first name...");
        first = in.nextLine();
        System.out.print("Enter your middle initial...");
        middle = in.nextLine().charAt(0);
        System.out.print("Enter your last name...");
        last = in.nextLine();
        in.close();
        // OUTPUT
        System.out.println();
        System.out.printf("%s %c. %s\n", first, middle, last);
        System.out.printf("%s, %s %c.\n", last, first, middle);
        System.out.printf("%c%c%c\n", first.charAt(0), middle, last.charAt(0));
    }
}
