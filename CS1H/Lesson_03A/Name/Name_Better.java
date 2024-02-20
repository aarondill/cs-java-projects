package Name;

import java.util.Scanner;

/**
 * Class name
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
 * different formats. With better handling of user prompts.
 * 
 */

public class Name_Better {
    private static String getInput(String prompt, Scanner scan) {
        String val = "";
        while (val.length() == 0) {
            System.out.println(prompt);
            val = scan.nextLine().trim().replaceAll("\\s{2,}", " ");
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // INPUT
        String first = getInput("Enter your first name...", in);
        char middle = getInput("Enter your middle initial...", in).charAt(0);
        String last = getInput("Enter your last name...", in);
        in.close();
        // OUTPUT
        System.out.println();
        System.out.printf("%s %c. %s\n", first, middle, last);
        System.out.printf("%s, %s %c.\n", last, first, middle);
        System.out.printf("%c%c%c\n", first.charAt(0), middle, last.charAt(0));
    }
}
