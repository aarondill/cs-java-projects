/**
 * Primary java class: BooleanExpressionsWithLiterals
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/11/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will print the value of each of the expressions, as
 * shown below, on a separate line.
 * Evaluate each of the expressions by hand BEFORE you run your program and
 * compare your answers to what your program prints.
 *
 */
public class BooleanExpressionsWithLiterals {
  public static void main(String... args) {
    System.out.println(5 * 18 != 5 * 3 + 5 * 6); // true
    System.out.println(-13 == -13.0); // true
    System.out.println(-13 <= -13.0); // true
    System.out.println(15 % 5 == 0); // true
    System.out.println(7 + 9 / 2 >= 7 + 9 % 2); // true
    System.out.println(7.1 + 9.5 != 16.6); // false
    System.out.println(5.2 < 6.1); // true
    System.out.println(100 % 2 == 0); // true
    System.out.println(0 % 2 == 0); // true
    System.out.println(100 % 3 == 0); // false
  }
}
