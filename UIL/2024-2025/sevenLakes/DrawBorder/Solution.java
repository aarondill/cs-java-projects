import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  private static void each(Scanner scan) {
    // Parse the input:
    int rows = scan.nextInt();
    int columns = scan.nextInt();
    int width = scan.nextInt();
    scan.nextLine();
    // Handle output:
    List<List<String>> output = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      List<String> row = new ArrayList<>();
      row.add(scan.nextLine());
      output.add(row);
    }
    for (int i = 0; i < width; i++) {
      List<String> first = new ArrayList<>();
      first.add("#".repeat(columns));
      output.add(0,first);;
    }

    for (int i = 0; i < width; i++) {
      List<String> last = new ArrayList<>();
      last.add("#".repeat(columns));
      output.add(output.size(), last);
    }

    for (var row : output) {
      row.add(0, "#".repeat(width));
      row.add(row.size(), "#".repeat(width));
    }

    for (List<String> row : output) {
      for (String s : row)
        System.out.print(s);
      System.out.println();
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
