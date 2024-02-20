
/**
 * Primary java class: FindingPrimes2
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
import java.util.Scanner;

public class FindingPrimes2 {
  private static void assert_args(String[] args, String... argsNames) {
    final String usage = String.format("Usage: %s %s", FindingPrimes2.class.getSimpleName(),
        String.join(" ", argsNames));
    for (String a : args) {
      boolean isHelpFlag = a.equals("--help") || (a.startsWith("-") && !a.startsWith("--") && a.contains("h"));
      if (isHelpFlag) {
        System.err.println(usage);
        System.exit(0);
      }
    }
    if (args.length != argsNames.length) {
      System.err.println(usage);
      System.exit(2);
    }
  }

  public static void main(String[] args) {
    int start, end;
    if (args.length > 0) {
      assert_args(args, "<start>", "<end>");
      start = Integer.parseInt(args[0]);
      end = Integer.parseInt(args[1]);
    } else {
      try (Scanner kb = new Scanner(System.in)) {
        System.err.print("Enter two positive numbers: ");
        start = kb.nextInt();
        end = kb.nextInt();
        while (start <= 0 || end <= 0) { // Loop until the user inputs valid numbers
          System.err.print("Numbers must be greater than zero: ");
          start = kb.nextInt();
          end = kb.nextInt();
        }
      }
    }
    if (start <= 0 || end <= 0) {
      System.err.print("Numbers must be greater than zero!");
      System.exit(1);
    }
    int max = Math.max(start, end);
    int min = Math.min(start, end);
    // Don't start at 1!
    for (int num = Math.max(min, 2); num <= max; num++) {
      int divisor = 2;
      boolean isPrime = true;
      double sqrtNum = Math.sqrt(num);
      while (isPrime && divisor <= sqrtNum) {
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
