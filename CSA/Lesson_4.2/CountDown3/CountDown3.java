import java.util.Scanner;

/**
 * Primary java class: CountDown3
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/06/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 4.2.2 – CountDown3 - Write a program that allows the user to enter two
 * whole numbers. The first number should be smaller than the second number.
 * Print all of the numbers from the second number down to the first number.
 * Print each number on same line. If the first number is larger than the second
 * number, then the program should not print anything. (see Topic 4.2 Practice
 * Labs
 * 
 * Modify CountDown from lab 4.2.2 so that it does not matter which number is
 * the largest. The program should always count down from the largest number to
 * the smallest number
 *
 */
public class CountDown3 {
  public static void main(String... args) {
    int num1, num2;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("First number: ");
      num1 = scan.nextInt();
      System.out.print("Second number: ");
      num2 = scan.nextInt();
    }
    int min = Math.min(num1, num2), max = Math.max(num1, num2);
    for (int i = max; i >= min; i--) {
      System.out.println(i);
    }
  }
}
