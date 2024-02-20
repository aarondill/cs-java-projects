import java.util.Scanner;
import java.io.*;

/**
 * Class Lab3B2
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 12, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: take user input of three integers using a
 * {@link java.util.Scanner} from a {@link java.io.File} and output the sum of them all
 */
public class Lab3B2 {
    public static void main(String[] args) throws IOException {
        int num1, num2, num3, sum;
        Scanner file = new Scanner(new File("lab3b2.in"));
        // Input section
        num1 = file.nextInt();
        num2 = file.nextInt();
        num3 = file.nextInt();

        // Process section
        sum = num1 + num2 + num3;
        // Output section
        System.out.println("****.****.****.**");
        System.out.printf("%d\t%d\t%d\n", num1, num2, num3);
        System.out.println("Sum = " + sum);
        file.close();
    }
}
