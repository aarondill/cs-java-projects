import java.util.Scanner;

public class Solution {
  private static void each(Scanner sc) {
    int h1 = sc.nextInt();
    int v1 = sc.nextInt();
    int h2 = sc.nextInt();
    int v2 = sc.nextInt();

    long d = (long) Math.sqrt(Math.pow(h1 - h2, 2) + Math.pow(v1 - v2, 2));
    if (d <= 46) {
      System.out.println("Spartans Win!");
    } else {
      System.out.println("Spartans Lose :(");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++)
      each(sc);
  }
}
