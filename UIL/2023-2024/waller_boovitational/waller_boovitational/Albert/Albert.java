import java.util.Scanner;

public class Albert {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Albert.class.getResourceAsStream("./albert.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        System.out.println(dataScanner.nextLine() + "!!!");
      }
    }
  }
}
