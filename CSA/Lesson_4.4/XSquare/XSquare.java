/**
 * Primary java class: XSquare
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/13/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will print a 5 by 5 square filled with capital X.
 *
 */
public class XSquare {
  public static void main(String... args) {
    for (int x = 0; x < 5; x++) {
      // OR skip the loop: System.out.println("X".repeat(5));
      for (int y = 0; y < 5; y++) {
        System.out.print("X");
      }
      System.out.println();
    }
  }
}
