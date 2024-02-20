import java.util.Scanner;

/**
 * Primary java class: CountDown
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/06/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 4.2.2 – CountDown - Write a program that allows the user to enter two
 * whole numbers. The first number should be smaller than the second number.
 * Print all of the numbers from the second number down to the first number.
 * Print each number on same line. If the first number is larger than the second
 * number, then the program should not print anything. (see Topic 4.2 Practice
 * Labs
 *
 */
public class CountDown {
  public static void main(String... args) {
    int num1, num2;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("First number: ");
      num1 = scan.nextInt();
      System.out.print("Second number: ");
      num2 = scan.nextInt();
    }
    for (int i = num2; i >= num1; i--) {
      System.out.println(i);
    }
  }
}
