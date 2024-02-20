/**
 * Primary java class: MultiplicationTable
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 * Write a program that will print a multiplication table for the digits 1
 * through 9. The table must be formatted so that each column has three spaces
 * and each number is right aligned in the column.
 */
public class MultiplicationTable {
  public static void main(String... args) {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.printf("%3d", i * j);
      }
      System.out.println();
    }
  }
}
