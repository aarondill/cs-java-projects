import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ricardo {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "ricardo.dat";

  private static double rec(String workout) {
    if (workout.length() == 0) return 0;
    if (workout.charAt(0) != '(') return 1;
    if (workout.charAt(workout.length() - 1) != ')') throw new IllegalArgumentException(workout);

    ArrayList<String> children = new ArrayList<>();
    // Each child is enclosed in parentheses.
    int depth = 0, start = 1;
    char type = 'j';
    for (int end = 1; end < workout.length() - 2; end++) {
      if (workout.charAt(end) == '(') depth++;
      if (workout.charAt(end) == ')') depth--;
      if (depth == 0) {
        if (workout.charAt(end) == ',' || workout.charAt(end) == '|') {
          type = workout.charAt(end);
          children.add(workout.substring(start, end));
          start = end + 1;
        }
      }
    }
    children.add(workout.substring(start, workout.length() - 1));
    children.replaceAll(String::trim);

    var nums = children.stream().map(Ricardo::rec).toList();
    if (type == ',') return nums.stream().reduce(1.0, (a, b) -> a * b);
    return nums.stream().reduce(0.0, (a, b) -> a + b);
  }

  private static void each(Scanner scan) {
    System.out.printf("Case #%d: %.0f\n", caseNum, rec(scan.nextLine()));
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
