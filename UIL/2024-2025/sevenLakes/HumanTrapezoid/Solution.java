import java.util.Scanner;

public class Solution {
  private static void each(Scanner scan) {
    // Parse the input:
    long end = scan.nextLong();
    long start = scan.nextLong();
    long minus = scan.nextLong();

    long sumToStart = (start) * (start + 1) / 2 - start; // exclude start
    long sumToEnd = end * (end + 1) >> 1;
    long sum = sumToEnd - sumToStart;

    if (sum > minus) System.out.println(sum - minus);
    else System.out.println(0);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
