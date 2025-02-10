import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nightcrawler {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "nightcrawler.dat";

  private static void each(Scanner scan) {
    String[] points = scan.nextLine().split(" ");
    List<Point> list = new ArrayList<>();
    for (String point : points)
      list.add(Point.parse(point));
    double maxDistance = -1;
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        double distance = list.get(i).distance(list.get(j));
        if (distance > maxDistance) maxDistance = distance;
      }
    }
    System.out.printf("%.2f\n", maxDistance);

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

record Point(double x, double y) {
  public static Point parse(String s) {
    String[] parts = s.substring(1, s.length() - 1).split(","); // remove () and split by ,
    return new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
  }

  public double distance(Point other) {
    return Math.hypot(other.x - x, other.y - y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
