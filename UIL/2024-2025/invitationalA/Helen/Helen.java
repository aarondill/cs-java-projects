import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Helen {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "helen.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String[] tokens = scan.nextLine().split("\\s+");
    Character variable = null;
    int tokenWithX = -1;
    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      if (token.matches(".*[a-z].*")) {
        variable = token.charAt(token.length() - 1);
        tokenWithX = i;
      }
    }

    String token = tokens[tokenWithX];
    double res = Double.MIN_VALUE;
    if (tokenWithX == 0) {
      double fifth = Double.parseDouble(tokens[4]), three = Double.parseDouble(tokens[2]);
      String sign = tokens[1];
      res = switch (sign) {
        case "+" -> fifth - three;
        case "*" -> (long) fifth / (long) three;
        case "-" -> fifth + three;
        case "/" -> fifth * three;
        default -> throw new IllegalStateException();
      };
    } else if (tokenWithX == 2) {
      double first = Double.parseDouble(tokens[0]), fifth = Double.parseDouble(tokens[4]);
      String sign = tokens[1];
      res = switch (sign) {
        case "+" -> fifth - first;
        case "*" -> (long) fifth / (long) first;
        case "-" -> -(fifth + first);
        case "/" -> (long) first / (long) fifth;
        default -> throw new IllegalStateException();
      };
    } else if (tokenWithX == 4) {
      double first = Double.parseDouble(tokens[0]), three = Double.parseDouble(tokens[2]);
      String sign = tokens[1];
      res = switch (sign) {
        case "+" -> first + three;
        case "*" -> first * three;
        case "-" -> first - three;
        case "/" -> (long) first / (long) three;
        default -> throw new IllegalStateException();
      };
    }
    double coeef = token.length() == 1 ? 1 : Double.parseDouble(token.substring(0, token.length() - 1));
    double x = res / coeef;
    System.out.printf("%s = %.3f\n", variable, x);
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
