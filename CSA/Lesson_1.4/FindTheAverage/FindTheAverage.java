import java.util.Scanner;

/**
 * public class FindTheAverage
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will print the average of 4 decimal
 * values that have been entered by the user. Include meaningful prompts and
 * label the output. Your program will need a double type variable to store the
 * values entered by the user and a double type variable to store a running
 * total of the values. You must use compound assignment to add up the values
 * each time the user enters a value. Here is a sample run and its output. You
 * may declare up to three (3) variables.
 * 
 * <pre>
 * Enter four values.
 * Value 1: 15.25
 * Value 2: 14.10
 * Value 3: 18.75
 * Value 4: 10.90
 * Average = 14.75
 * </pre>
 * 
 */
public class FindTheAverage {
  private static int NUM_PROMPTS = 4;

  private static double promptDbl(Scanner scan, String prompt) {
    System.out.print(prompt);
    return scan.nextDouble();
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Enter four values.");
      double total = 0, count = 0;
      for (int i = 0; i < NUM_PROMPTS; i++) {
        double val = promptDbl(scan, String.format("Value %d: ", i + 1));
        total += val;
        count++;
      }
      System.out.println("Average = " + total / count);

    }
  }
}
