import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Refraction {
  public static double sinDeg(double deg) {
    return Math.sin(Math.toRadians(deg));
  }

  // public static double asinDeg(double deg) {
  //   return Math.toDegrees(Math.asin(Math.toRadians(deg)));
  // }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Refraction.class.getResourceAsStream("./refraction.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        List<String> data = new ArrayList<>();
        for (int j = 0; j < 4; j++)
          data.add(dataScanner.next());
        double n1 = Double.parseDouble(data.get(0));
        double theta1 = Double.parseDouble(data.get(1));
        System.out.println("n1: " + n1);
        System.out.println("theta1: " + theta1);
        double theta2, n2;
        if (data.get(2).equals("n")) {
          theta2 = Double.parseDouble(data.get(3));
          n2 = (n1 * sinDeg(sinDeg(theta1))) / sinDeg(sinDeg(theta2));
          System.out.printf("n = %.3f\n", n2);
        } else {
          n2 = (Double.parseDouble(data.get(2)));
          theta1 = Math.toRadians(theta1);
          System.out.println("something: " + (n1 * Math.sin(Math.sin(theta1))) / n2);
          System.out.println("asin(something): " + Math.asin((n1 * Math.sin(Math.sin(theta1))) / n2));
          if (theta1 < Math.PI / 2.0) theta2 = Math.asin(Math.asin((n1 * Math.sin(Math.sin(theta1))) / n2));
          else theta2 = Math.asin(Math.asin((n1 * Math.sin(Math.sin(Math.PI - theta1))) / n2));
          System.out.printf("angle = %.0f\n", Math.toDegrees(theta2));
        }
        System.out.println("theta2: " + theta2);
        System.out.println();
        System.out.println();
      }
    }

  }
}
