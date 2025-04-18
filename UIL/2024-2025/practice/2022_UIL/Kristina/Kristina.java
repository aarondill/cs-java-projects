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

  public static int pre(List<String> list) {
    Stack<Integer> s = new Stack<>();
    // NOTE: reverse the list
    for (String val : list.reversed()) {
      if (!Operator.parseable(val)) {
        s.push(Integer.parseInt(val));
        continue;
      }
      int a = s.pop(), b = s.pop();
      s.push(Operator.fromSymbol(val).calculate(a, b));
    }
    if (s.size() != 1) throw new IllegalArgumentException("Invalid input: stack size is " + s.size());
    return s.pop();
  }

  private static int post(List<String> list) {
    Stack<Integer> s = new Stack<>();
    for (String val : list) {
      if (!Operator.parseable(val)) {
        s.push(Integer.parseInt(val));
        continue;
      }
      // NOTE: opposite order of pre
      int b = s.pop(), a = s.pop();
      s.push(Operator.fromSymbol(val).calculate(a, b));
    }
    if (s.size() != 1) throw new IllegalArgumentException("Invalid input: stack size is " + s.size());
    return s.pop();
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
