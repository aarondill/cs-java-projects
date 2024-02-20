import java.util.Scanner;

/**
 * Primary java class: TestThatNumber
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will allow the user to enter an
 * int. Using if statements, test the following and print out the following:
 * 1. if the number is positive
 * 2. if the number is 0
 * 3. if the number is negative
 * 4. if the number is nonnegative
 * 5. if the number is nonpositive
 * 6. if the number is even
 * 7. if the number is odd
 * 8. if the number is divisible by 10
 * 9. if the number is not divisible by 10
 *
 */
public class TestThatNumber {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter an integer ==> ");
      int x = scan.nextInt();
      if (x > 0)
        System.out.println("The number is positive");
      if (x == 0)
        System.out.println("The number is 0");
      if (x < 0)
        System.out.println("The number is negative");
      if (x >= 0)
        System.out.println("The number is nonnegative");
      if (x <= 0)
        System.out.println("The number is nonpositive");
      if (x % 2 == 0)
        System.out.println("The number is even");
      if (x % 2 != 0)
        System.out.println("The number is odd");
      if (x % 10 == 0)
        System.out.println("The number is divisible by 10");
      if (x % 10 != 0)
        System.out.println("The number is not divisible by 10");

    }
  }
}
