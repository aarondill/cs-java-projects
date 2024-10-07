import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

enum Type {
  PRE, POST
}

enum Operator {
  PLUS, MINUS, MULTIPLY, DIVIDE, EXP;

  public static Operator fromSymbol(String s) {
    return switch (s) {
      case "+" -> PLUS;
      case "-" -> MINUS;
      case "*" -> MULTIPLY;
      case "/" -> DIVIDE;
      case "^" -> EXP;
      default -> throw new IllegalArgumentException("Invalid operator: " + s);
    };
  }

  public static boolean parseable(String word) {
    return switch (word) {
      case "+", "-", "*", "/", "^" -> true;
      default -> false;
    };
  }

  public int calculate(int a, int b) {
    int val = switch (this) {
      case PLUS -> a + b;
      case MINUS -> a - b;
      case MULTIPLY -> a * b;
      case DIVIDE -> a / b;
      case EXP -> (int) Math.pow(a, b);
    };
    System.out.printf("> %s %s %s = %s\n", a, this, b, val);
    return val;
  }

  public String toString() {
    return switch (this) {
      case PLUS -> "+";
      case MINUS -> "-";
      case MULTIPLY -> "*";
      case DIVIDE -> "/";
      case EXP -> "^";
    };
  }
}

public class Kristina {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kristina.dat";

  private static int pre(List<String> list) {
    System.out.println("> pre");
    Stack<String> s = new Stack<>();
    boolean hasOtherOperand = false;
    for (String word : list) {
      s.push(word);
      if (Operator.parseable(word)) continue; // this is an opperator
      if (!hasOtherOperand) { // we need one more operand
        hasOtherOperand = true;
        continue;
      }

      Integer a = Integer.parseInt(s.pop()), b = null;
      Operator op = null;
      Iterator<String> it = s.reversed().iterator();
      while (it.hasNext() && (op == null || b == null)) {
        String v = it.next();
        if (Operator.parseable(v)) {
          if (op == null) { // this is an operator, do we need it?
            op = Operator.fromSymbol(v);
            it.remove();
          }
        } else if (b == null) { // this is not an operator, do we need it?
          b = Integer.parseInt(v);
          it.remove();
        }
      }
      s.push(String.valueOf(op.calculate(a, b))); // add the calculated value to the stack
      hasOtherOperand = false;
    }
    if (s.size() != 1) throw new IllegalArgumentException("Invalid input: stack size is " + s.size());
    return Integer.parseInt(s.pop());
  }

  private static int post(List<String> list) {
    System.out.println("> post");
    Stack<String> s = new Stack<>();
    for (String word : list) {
      s.push(word);
      if (!Operator.parseable(word)) continue; // this is an opperand

      Operator op = Operator.fromSymbol(s.pop());
      Integer b = Integer.parseInt(s.pop()), a = Integer.parseInt(s.pop());
      s.push(String.valueOf(op.calculate(a, b))); // add the calculated value to the stack
    }
    if (s.size() != 1) throw new IllegalArgumentException("Invalid input: stack size is " + s.size());
    return Integer.parseInt(s.pop());
  }

  private static void each(Scanner scan) {
    // Parse the input:
    List<String> list = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
    Type type = Type.valueOf(list.remove(0));
    int res = switch (type) {
      case PRE -> pre(list);
      case POST -> post(list);
    };
    // Print the result:
    System.out.println(res);
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
