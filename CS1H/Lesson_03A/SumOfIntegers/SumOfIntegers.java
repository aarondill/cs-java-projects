package SumOfIntegers;

import java.util.Scanner;

/**
 * Class SumOfIntegers
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 27, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: take user input of three integers using a
 * {@link java.util.Scanner} and output the sum of them all
 */
public class SumOfIntegers {
    public static void main(String[] args) {
        int num1, num2, num3, sum;
        Scanner kb = new Scanner(System.in);
        // Input section
        System.out.print("Enter a number-->");
        num1 = kb.nextInt();
        System.out.print("Enter another number-->");
        num2 = kb.nextInt();
        System.out.print("Enter a third number-->");
        num3 = kb.nextInt();

        // Process section
        sum = num1 + num2 + num3;
        // Output section
        System.out.println();
        System.out.println("****.****.****.**");
        System.out.printf("%d\t%d\t%d\n", num1, num2, num3);
        System.out.println("Sum = " + sum);
        kb.close();
    }
}
