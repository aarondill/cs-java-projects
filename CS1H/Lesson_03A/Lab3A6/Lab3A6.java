import java.util.Scanner;

/**
 * Class Lab3A6
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    March 29, 2023
 * Course:  Computer Science I Honors
 * Period:  4th
 * </pre>
 *
 * Summary of file: WAP to input a 4-digit integer, assign to variables the
 * thousands, the hundreds, the tens, and the ones digits, and output each one
 * separately with a label indicating its place value. Use / and % operators to
 * mathematically separate out the digits. Create EXACT OUTPUT. DO NOT
 * trivialize this task by inputting the value as a String and then using the
 * charAt method. Make your program run with two sets of data, indented and
 * formatted exactly as shown in the example below. Hint: To isolate a place
 * digit in a number, first mod the number by the place BEFORE, then div by the
 * place OF the digit you want. For example, to isolate the hundreds digit of
 * the value 4528, you would do 4528 % 1000 / 100. The first operation gives you
 * 528, and the second operation results in 5.
 */
public class Lab3A6 {
    public static void main(String[] args) {
        try (Scanner kb = new Scanner(System.in)) {
            final int ITERATIONS = 2;
            for (int i = 0; i < ITERATIONS; i++) {
                // Input section
                System.out.print("Enter a number...");
                int num = kb.nextInt();
                // Process section
                int thou = num / 1000;
                int hun = num % 1000 / 100;
                int ten = num % 100 / 10;
                int one = num % 10;
                // Output section
                System.out.println("****.****.****.****.");
                System.out.printf("%14s%d equals\n", "", num);
                System.out.printf("%14s%d thousands\n", "", thou);
                System.out.printf("%14s%d hundreds\n", "", hun);
                System.out.printf("%14s%d tens\n", "", ten);
                System.out.printf("%14s%d ones\n", "", one);
            }
        }

    }
}
