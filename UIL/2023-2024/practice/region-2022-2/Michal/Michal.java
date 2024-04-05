import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Michal {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "michal.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int[] nums = Stream.of(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
    // Handle output:
    List<List<String>> output = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      output.add(new ArrayList<>());
      var row = output.get(i);
      if (i % 2 == 0) row.add("*");
      else row.add(" ");
    }

    for (int n : nums) {
      output.get(0).add("***");
      output.get(1).add("   ");
      output.get(2).add("   ");
      output.get(8).add("   ");
      output.get(9).add("   ");
      output.get(10).add("***");
      switch (n) {
        case 0:
          output.get(3).add(" - ");
          output.get(4).add("| |");
          output.get(5).add("   ");
          output.get(6).add("| |");
          output.get(7).add(" - ");
          break;
        case 1:
          output.get(3).add("   ");
          output.get(4).add("  |");
          output.get(5).add("   ");
          output.get(6).add("  |");
          output.get(7).add("   ");
          break;
        case 2:
          output.get(3).add(" - ");
          output.get(4).add("  |");
          output.get(5).add(" - ");
          output.get(6).add("|  ");
          output.get(7).add(" - ");
          break;
        case 3:
          output.get(3).add(" - ");
          output.get(4).add("  |");
          output.get(5).add(" - ");
          output.get(6).add("  |");
          output.get(7).add(" - ");
          break;
        case 4:
          output.get(3).add("   ");
          output.get(4).add("| |");
          output.get(5).add(" - ");
          output.get(6).add("  |");
          output.get(7).add("   ");
          break;
        case 5:
          output.get(3).add(" - ");
          output.get(4).add("|  ");
          output.get(5).add(" - ");
          output.get(6).add("  |");
          output.get(7).add(" - ");
          break;
        case 6:
          output.get(3).add(" - ");
          output.get(4).add("|  ");
          output.get(5).add(" - ");
          output.get(6).add("| |");
          output.get(7).add(" - ");
          break;
        case 7:
          output.get(3).add(" - ");
          output.get(4).add("  |");
          output.get(5).add("   ");
          output.get(6).add("  |");
          output.get(7).add("   ");
          break;
        case 8:
          output.get(3).add(" - ");
          output.get(4).add("| |");
          output.get(5).add(" - ");
          output.get(6).add("| |");
          output.get(7).add(" - ");
          break;
        case 9:
          output.get(3).add(" - ");
          output.get(4).add("| |");
          output.get(5).add(" - ");
          output.get(6).add("  |");
          output.get(7).add("   ");
          break;
      }
    }
    for (int i = 0; i < 11; i++) {
      var row = output.get(i);
      if (i % 2 == 0) row.add("*");
      else row.add(" ");
    }
    for (var row : output) {
      System.out.println(String.join("", row));
    }

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
