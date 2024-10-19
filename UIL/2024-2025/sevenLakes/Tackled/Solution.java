import java.util.Scanner;

public class Solution {

  private static void each(Scanner scan) {
    // Parse the input:
    String name = scan.nextLine();
    System.out.printf("ANTHONY LI TACKLED BY %s!!!!!\n", name.toUpperCase());
    // Handle output:
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
