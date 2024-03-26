import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Kristina {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kristina.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String op = scan.next();
    String[] line = scan.nextLine().split("\\s+");
    String[] line2 = new String[line.length - 1];
    for (int i = 1; i < line.length; i++)
      line2[i - 1] = line[i];
    line = line2;
    // Handle output:
    System.out.println(op.equals("PRE") ? pre(line) : post(line));
  }

  private static String pre(String[] line) {
    line = (Arrays.asList(line).reversed().toArray(String[]::new));
    Stack<String> s = new Stack<>();
    for (String x : line) {
      switch (x) {
        case "+" -> s.push("" + (Integer.parseInt(s.pop()) + Integer.parseInt(s.pop())));
        case "-" -> s.push("" + (Integer.parseInt(s.pop()) - Integer.parseInt(s.pop())));
        case "*" -> s.push("" + Integer.parseInt(s.pop()) * Integer.parseInt(s.pop()));
        case "/" -> s.push("" + Integer.parseInt(s.pop()) / Integer.parseInt(s.pop()));
        case "^" -> s.push("" + (int) Math.pow(Integer.parseInt(s.pop()), Integer.parseInt(s.pop())));
        default -> s.push(x);
      }
    }
    return s.pop();
  }

  private static String post(String[] line) {
    Stack<String> s = new Stack<>();
    for (String x : line) {
      switch (x) {
        case "+" -> s.push("" + (Integer.parseInt(s.pop()) + Integer.parseInt(s.pop())));
        case "-" -> s.push("" + (-Integer.parseInt(s.pop()) + Integer.parseInt(s.pop())));
        case "*" -> s.push("" + Integer.parseInt(s.pop()) * Integer.parseInt(s.pop()));
        case "/" -> {
          String a = s.pop(), b = s.pop();
          s.push("" + Integer.parseInt(b) / Integer.parseInt(a));
        }
        case "^" -> s.push("" + (int) Math.pow(Integer.parseInt(s.pop()), Integer.parseInt(s.pop())));
        default -> s.push(x);
      }
    }
    return s.pop();
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
