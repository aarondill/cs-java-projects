import java.util.Scanner;

/**
 * Primary java class: NumericComparisons
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/11/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 3.1.3 –NumericComparisons - Write a program that will print the value of
 * each of the expressions shown below each on a separate line. Evaluate each of
 * the expressions by hand BEFORE you run your program and compare your answers
 * to what your program prints.
 * 
 */
public class NumericComparisons {

  // Assign isEven the result of testing if num1 is even
  // output the result in tha same fashion shown above
  // Create the following boolean variables:
  // isZero, isPositive, isNegative, isNonnegative, isNonpositive
  // Use num1 and perform the appropriate comparisons assigned to the appropriate
  // boolean variable. Output the results in the same fashion shown above.
  private static void test(int num) {
    boolean isOdd = num % 2 != 0;
    boolean isEven = num % 2 == 0;
    boolean isZero = num == 0;
    boolean isPositive = num > 0;
    boolean isNegative = num < 0;
    boolean isNonnegative = num >= 0;
    boolean isNonpositive = num <= 0;

    System.out.println(num + " is odd: " + isOdd); // false
    System.out.println(num + " is even: " + isEven); // true
    System.out.println(num + " is zero: " + isZero); // false
    System.out.println(num + " is positive: " + isPositive); // true
    System.out.println(num + " is negative: " + isNegative); // false
    System.out.println(num + " is nonnegative: " + isNonnegative); // true
    System.out.println(num + " is nonpositive: " + isNonpositive); // false
  }

  // Input value for num2, then create two boolean variables: isFactor, isMultiple
  // Assign the variables the results of the appropriate comparisons to test if
  // num1 is a factor of num2 and if num1 is a multiple of num2.
  // Output the results in the same fashion as shown above.
  private static void test2nums(int num1, int num2) {
    boolean isFactor = num2 % num1 == 0; // Num2 must be larger for num1 to be a factor of num2
    boolean isMultiple = num1 % num2 == 0; // Num1 must be larger for num1 to be a multiple of num2

    System.out.println(num1 + " is a factor of " + num2 + ": " + isFactor); // false
    System.out.println(num1 + " is a multiple of " + num2 + ": " + isMultiple); // true
  }

  public static void main(String... args) {
    // Given: num1 = 8, num2 = 2
    try (Scanner kb = new Scanner(System.in)) {
      System.out.print("Enter num1 ==>");
      int num1 = kb.nextInt();
      test(num1);

      System.out.print("Enter num2 ==>");
      int num2 = kb.nextInt();
      test2nums(num1, num2);

    }

  }
}
