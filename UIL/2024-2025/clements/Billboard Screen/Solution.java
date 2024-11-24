import java.util.Scanner;

public class Solution {

  private static String centered(String title, int w, int h) {
    if (title.length() > w * h) return null;
    throw new UnsupportedOperationException("This is hard.");
  }

  private static void each(Scanner scan) {
    int w = scan.nextInt();
    int h = scan.nextInt();
    scan.nextLine();
    String title = scan.nextLine();
    String content = centered(title, w, h);
    if (content == null) System.out.println("Title not compatible with size.");
    System.out.println("#".repeat(w + 2));
    for (String line : content.split("\n"))
      System.out.println("# " + line + " #");
    System.out.println("#".repeat(w + 2));
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
