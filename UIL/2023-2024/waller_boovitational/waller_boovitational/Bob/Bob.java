import java.util.Scanner;

public class Bob {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Bob.class.getResourceAsStream("./bob.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int num1 = dataScanner.nextInt();
        int num2 = dataScanner.nextInt();
        String op = dataScanner.next("\\*|\\+");
        System.out.println(switch (op) {
          case "*" -> (num1 * num2);
          case "+" -> (num1 + num2);
          default -> "invalid op " + op;
        });
      }
    }
  }
}
