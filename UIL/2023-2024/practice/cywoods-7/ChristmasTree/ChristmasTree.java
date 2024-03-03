import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChristmasTree {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "ChristmasTree.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int rows = Integer.parseInt(scan.nextLine());
    String[] data = scan.nextLine().split("\\s+");
    char orn = data[0].charAt(0);
    List<Integer> locations = Arrays.asList(data).stream().skip(1).map(Integer::parseInt).toList();
    // Handle output:
    int cpos = 1; // 1-indexed
    for (int i = 0; i < rows; i++) {
      System.out.print(" ".repeat(rows - 1 - i));
      System.out.print("/");
      for (int j = 0; j < i * 2; j++, cpos++) {
        if (locations.contains(cpos)) System.out.print(orn);
        else System.out.print("-");
      }
      System.out.print("\\");
      System.out.println();
    }
    System.out.println(" ".repeat(rows - 1) + "||");
    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
