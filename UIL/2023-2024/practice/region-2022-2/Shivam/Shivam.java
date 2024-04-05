import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shivam {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "shivam.dat";

  private static int pi(String s, int defaultval) {
    if (s == null || s.length() == 0) return defaultval;
    if (s.equals("+") || s.equals("-")) s += "1";
    return Integer.parseInt(s);
  }

  private static double r(double a) {
    return Math.round(a * 100.0) / 100.0;
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String eq = scan.nextLine().trim();
    Pattern p = Pattern.compile("f\\(x\\)=(-?\\d*)?x\\^2(([+-]\\d*)x)?([+-]\\d*)?");
    Matcher m = p.matcher(eq);
    if (!m.matches()) throw new IllegalArgumentException("Invalid line: " + eq);
    int a = pi(m.group(1), 1);
    int b = pi(m.group(3), 0);
    int c = pi(m.group(4), 0);
    // Handle output:
    double dis = b * b - 4 * a * c;
    System.out.print("Function " + caseNum + ": ");
    if (dis < 0) System.out.print("There are no real roots to the function");
    else if (dis == 0) {
      double x = (-b + Math.sqrt(dis)) / (2 * a);
      double y = (a * x * x + b * x + c);
      x = r(x);
      y = r(y);
      if (x == 0) x = 0;
      if (y == 0) y = 0;
      System.out.print("There is one real root at ");
      System.out.printf("(%.2f,%.2f)", x, y);

    } else {
      double x1 = ((-b + Math.sqrt(dis)) / (2 * a));
      double x2 = ((-b - Math.sqrt(dis)) / (2 * a));
      double y1 = (a * x1 * x1 + b * x1 + c);
      double y2 = (a * x2 * x2 + b * x2 + c);
      if (x2 < x1) {
        double temp = x1;
        x1 = x2;
        x2 = temp;
        temp = y1;
        y1 = y2;
        y2 = temp;
      }
      // Here be dragons.
      x1 = r(x1);
      x2 = r(x2);
      y1 = r(y1);
      y2 = r(y2);
      if (x1 == 0) x1 = 0;
      if (x2 == 0) x2 = 0;
      if (y1 == 0) y1 = 0;
      if (y2 == 0) y2 = 0;
      System.out.print("There are two real roots at ");
      System.out.printf("(%.2f,%.2f) and (%.2f,%.2f)", x1, y1, x2, y2);
    }
    System.out.println(".");
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
