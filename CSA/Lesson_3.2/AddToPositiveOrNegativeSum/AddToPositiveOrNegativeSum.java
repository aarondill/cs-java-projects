import java.util.Scanner;

/**
 * Primary java class: AddToPositiveOrNegativeSum
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 3.2.3 – AddToPositiveOrNegativeSum - Write a program that will allow the
 * user to input an int. If the number is negative, add the number to a variable
 * to store a negative sum. If the number is positive, add the number to a
 * different variable to store a positive sum. At the conclusion of the program,
 * output the sums. Use the starter file and enter your code segments in the
 * commented areas that describe the given tasks. You will notice that your code
 * for user input and the conditional adding to one of the sums will be inside a
 * for loop. You will learn about for loops in the next unit, but you will use a
 * loop in this program now.
 *
 * 
 */
public class AddToPositiveOrNegativeSum {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      // declare and initialize a positive and negative sum
      int negativeSum = 0;
      int positiveSum = 0;
      for (int i = 1; i <= 10; i++) {
        // in this block, allow the user to input a number and add the number
        // to the appropriate sum
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        if (number < 0) {
          negativeSum += number;
        } else { // 0 is irrelevant for this program
          positiveSum += number;
        }
      }
      // output the sums
      System.out.println("The sum of the positive numbers is " + positiveSum + '.');
      System.out.println("The sum of the negative numbers is " + negativeSum + '.');
    } catch (java.util.InputMismatchException e) {
      System.out.println();
      System.err.println("I told you to input an integer");
      char[] msg = new char[] { 73, 32, 100, 111, 110, 39, 116, 32, 104, 97, 118, 101, 32, 116, 104, 101, 32, 116, 105,
          109, 101, 32, 116, 111, 32, 99, 111, 109, 101, 32, 117, 112, 32, 119, 105, 116, 104, 32, 97, 32, 119, 105,
          116, 116, 121, 32, 101, 114, 114, 111, 114, 32, 109, 101, 115, 115, 97, 103, 101 };
      System.err.println(new String(msg));
      System.exit(2);
    }

  }
}
