import java.util.Scanner;

/**
 * public class AddOneTakeOne
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will allow the user to enter a single
 * whole number. Using the increment and decrement operator, add one to the
 * number entered and subtract one from the number entered then print all three
 * values in numerical order on one line with a single space between each value.
 * Here is a sample run and its output.
 * 
 * Enter a number: 5
 * 
 * 4 5 6
 *
 */
public class AddOneTakeOne {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter a number: ");
      int number = scan.nextInt();
      System.out.println();
      int num = number;
      number++;
      int plusOne = number;
      number--;
      number--;
      int minusOne = number;
      System.out.println(minusOne + " " + num + " " + plusOne);
    }
  }
}
