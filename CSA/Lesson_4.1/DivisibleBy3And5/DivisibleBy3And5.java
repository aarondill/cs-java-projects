/**
 * Primary java class: DivisibleBy3And5
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: This is fizzbuzz.
 * Write a program that will print all of the numbers between 1 and 30 inclusive
 * that are divisible by 3, divisible by 5 and divisible by both
 * The output should be one of:
 * %d is divisible by %d
 * %d is divisible by both
 *
 * 
 */
public class DivisibleBy3And5 {
  public static void main(String... args) {
    for (int i = 1; i <= 30; i++) {
      boolean fizz = i % 3 == 0;
      boolean buzz = i % 5 == 0;
      if (fizz && buzz) {
        System.out.println(i + " is divisible by both.");
      } else if (fizz) {
        System.out.println(i + " is divisible by 3.");
      } else if (buzz) {
        System.out.println(i + " is divisible by 5.");
      }
    }

  }
}
