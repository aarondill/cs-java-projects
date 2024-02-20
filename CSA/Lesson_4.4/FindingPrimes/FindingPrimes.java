import java.util.Scanner;

/**
 * Primary java class: FindingPrimes
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
 */
public class FindingPrimes {
  public static void main(String... args) {
    int start, end;
    try (Scanner kb = new Scanner(System.in)) {
      System.out.print("Enter two positive numbers: ");
      start = kb.nextInt();
      end = kb.nextInt();
    }
    for (int num = start; num <= end; num++) {
      int divisor = 2;
      boolean isPrime = true;
      while (isPrime && divisor <= Math.sqrt(num)) {
        if (num % divisor == 0)
          isPrime = false;
        divisor++;
      }
      if (isPrime)
        System.out.print(num + " ");
    }
    System.out.println();
  }
}
