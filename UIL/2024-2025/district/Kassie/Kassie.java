import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kassie {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kassie.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String[] ops = scan.nextLine().split(" ");
    int a = Integer.parseInt(ops[0]);
    char op = ops[1].charAt(0);
    int b = Integer.parseInt(ops[2]);
    int res = switch (op) {
      case '-' -> a - b;
      case '+' -> a + b;
      case '*' -> a * b;
      case '/' -> a / b;
      default -> throw new IllegalAccessError();
    };
    System.out.println(res);
    // Handle output:
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
