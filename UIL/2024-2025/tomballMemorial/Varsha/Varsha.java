import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Varsha {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "varsha.dat";

  // [z][y][x]

  private static void each(Scanner scan) {
    int z = scan.nextInt(), y = scan.nextInt(), x = scan.nextInt();
    List<List<List<Boolean>>> grid = new ArrayList<>(z);
    for (int zi = 0; zi < z; zi++) {
      List<List<Boolean>> layers = new ArrayList<>(y);
      for (int yi = 0; yi < y; yi++) {
        List<Boolean> row = new ArrayList<>(x);
        for (int xi = 0; xi < x; xi++) {
          row.add(null);
        }
        layers.add(row);
      }
      grid.add(layers);
    }

    scan.nextLine();
    for (int zi = 0; zi < z; zi++) {
      for (int yi = 0; yi < y; yi++) {
        String line = scan.nextLine();
        for (int xi = 0; xi < x; xi++) {
          boolean isV = line.charAt(xi) == 'V';
          grid.get(zi) //
              .get(yi) //
              .set(xi, isV);
        }
      }
    }

    int max = 0;
    for (int zi = 0; zi < z; zi++) {
      for (int yi = 0; yi < y; yi++) {
        for (int xi = 0; xi < x; xi++) {
          max = Math.max(max, maxVein(new Point(xi, yi, zi), grid, 0, new HashSet<>()));
        }
      }
    }
    System.out.println(max);
  }

  public static int maxVein(Point p, List<List<List<Boolean>>> grid, int count, Set<Point> visited) {
    visited.add(p);
    int ret = 1;
    for (Direction d : Direction.values()) {
      Point i = p.add(d);
      if (i.z() < 0 || i.x() < 0 || i.y() < 0) continue;
      if (i.z() >= grid.size() || i.y() >= grid.get(i.z()).size() || i.x() >= grid.get(i.z()).get(i.y()).size())
        continue;

      if (!grid.get(i.z()).get(i.y()).get(i.x())) continue;
      ret += maxVein(i, grid, count + 1, visited);
    }
    return ret;

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

record Point(int x, int y, int z) {
  public Point add(Direction d) {
    return new Point(x + d.x, y + d.y, z + d.z);
  }

}

enum Direction {
  UP(0, 0, 1), DOWN(0, 0, -1), LEFT(-1, 0, 0), RIGHT(1, 0, 0), FORWARD(0, 1, 0), BACKWARD(0, -1, 0);

  int x, y, z;

  Direction(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

}
