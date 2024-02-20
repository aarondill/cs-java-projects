import java.util.Scanner;

public class Ian {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Ian.class.getResourceAsStream("./ian.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        double orig = dataScanner.nextDouble();
        double disc = dataScanner.nextDouble();
        System.out.printf("%.2f\n", 1.1 * (orig * (1 - disc / 100)));
      }
    }
  }
}
