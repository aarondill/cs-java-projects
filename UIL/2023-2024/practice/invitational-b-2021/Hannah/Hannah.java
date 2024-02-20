import java.util.Scanner;

/**
 * Primary java class: Hannah
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    12/04/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Hannah {
  private static String calculate(String op1, char operator, String op2, int base) {
    int one = Integer.parseInt(op1, base), two = Integer.parseInt(op2, base);
    int res = switch (operator) {
      case '+' -> one + two;
      case '-' -> one - two;
      case '*' -> one * two;
      case '/' -> one / two;
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
    return Integer.toString(res, base);
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Hannah.class.getResourceAsStream("./hannah.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int base = dataScanner.nextInt();
        if (base < 2 || base > 16) throw new IllegalArgumentException("Base must be between 2 and 16");
        dataScanner.nextLine();
        String eq = dataScanner.nextLine();
        String[] ops = eq.split("\\s+");
        if (ops.length != 3)
          throw new IllegalArgumentException("Equation is only permitted to have 2 operands seperated by an operator.");
        String op1 = ops[0], operator = ops[1], op2 = ops[2];
        if (operator.length() != 1) throw new IllegalArgumentException("Operator must be a single character");
        System.out.printf("%s = %s\n", eq, calculate(op1, operator.charAt(0), op2, base));
      }
    }
  }
}
