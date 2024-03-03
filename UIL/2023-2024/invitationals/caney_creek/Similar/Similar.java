import java.util.Scanner;

public class Similar {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Similar.class.getResourceAsStream("./similar.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int one = dataScanner.nextInt();
        int two = dataScanner.nextInt();
        int three = dataScanner.nextInt();
        int four = dataScanner.nextInt();
        int five = dataScanner.nextInt();
        double ratio = (double) four / one;
        int six = (int) (three * ratio);
        System.out.println(four + " " + five + " " + six);
      }
    }

  }
}
