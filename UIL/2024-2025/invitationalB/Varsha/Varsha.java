import static java.util.function.Predicate.not;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    Set<Point> visited = new HashSet<>(); // used to avoid visiting the same point twice
    for (int zi = 0; zi < z; zi++) {
      for (int yi = 0; yi < y; yi++) {
        for (int xi = 0; xi < x; xi++) {
          max = Math.max(max, maxVein(new Point(xi, yi, zi), grid, visited));
        }
      }
    }
    System.out.println(max);
  }

  public static int maxVein(Point p, List<List<List<Boolean>>> grid, Set<Point> visited) {
    if (!p.get(grid)) return 0;
    visited.add(p);
    int x = grid.size(), y = grid.get(0).size(), z = grid.get(0).get(0).size();
    // This point counts as 1
    return 1 + Arrays.stream(Direction.values()).map(p::add).filter(i -> i.valid(x, y, z)) // valid
        .filter(i -> i.get(grid)) // is ore
        .filter(not(visited::contains)) // already found this
        .mapToInt(i -> maxVein(i, grid, visited)).sum();
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

  public boolean valid(int z, int y, int x) {
    return this.z >= 0 && this.y >= 0 && this.x >= 0 && this.z < z && this.y < y && this.x < x;
  }

  public <T> T get(List<List<List<T>>> grid) {
    return grid.get(z).get(y).get(x);
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
