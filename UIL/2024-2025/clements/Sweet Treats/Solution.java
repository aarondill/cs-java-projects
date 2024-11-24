import java.util.Scanner;

public class Solution {

  private static void each(Scanner scan) {
    int n = scan.nextInt();
    double tolerance = scan.nextDouble();
    if (scan.hasNextLine()) scan.nextLine();
    double total = 0;
    for (int i = 0; i < n; i++) {
      /* String name= */ scan.next();
      double price = scan.nextDouble();
      double sweet = scan.nextDouble();
      if (scan.hasNextLine()) scan.nextLine();
      if (sweet <= tolerance) {
        total += price;
      }
    }
    System.out.printf("$%,.3f\n", total);

  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      each(scan);
    }
  }
}
