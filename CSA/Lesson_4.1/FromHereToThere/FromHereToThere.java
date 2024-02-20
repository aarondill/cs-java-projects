import java.util.Scanner;

/**
 * Primary java class: FromHereToThere
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that allows the user to enter two whole numbers. Print all of
 * the numbers between the first and second number entered by the user. Print
 * each number on a separate line. If the first number is larger than the second
 * number, then the program should not print anything. Do not declare any
 * additional variables other than those shown in the starter file
 *
 */
public class FromHereToThere {
  public static void main(String... args) {
    int first, second;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("First number? ");
      first = scan.nextInt();
      System.out.print("Second number? ");
      second = scan.nextInt();
    }
    while (first <= second)
      System.out.println(first++);
  }
}
