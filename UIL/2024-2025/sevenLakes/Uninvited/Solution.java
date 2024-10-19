import java.util.Scanner;

public class Solution {

  private static void each(Scanner scan) {
    int a = scan.nextInt();
    int t = scan.nextInt();
    int b = scan.nextInt();
    int d = scan.nextInt();
    // how many combinations of two of a, t, and b are greater than d?
    int count = 0;
    if (a + t >= d) count++;
    if (a + b >= d) count++;
    if (b + t >= d) count++;
    System.out.println(count);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
