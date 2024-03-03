import java.util.Scanner;

public class Louis {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Louis.class.getResourceAsStream("./louis.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int num = dataScanner.nextInt();
        double log2 = Math.log10(num) / Math.log10(2);
        System.out.printf("%.0f\n", Math.floor(log2 + 1));
      }
    }
  }
}
