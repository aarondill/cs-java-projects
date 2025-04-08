import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * <pre>
 * This is two problems in one:
 *   1. Find the part of the map that is island / ocean / lake
 *   2. Having found the islands (lake can be considered island), find the sum of perimeters of all the islands
 *
 * For part 1, ocean is defined as water that is connected to the border of the map by water
 * For this, we can start of each water tile along the border, then flood fill (not seen) tiles until we've seen all the ocean water
 * All other tiles can be considered land (includes lakes, but they aren't part of perimeter (coastline) )
 *
 * For part 2, we can consider each island tile indiviually. Each tile contributes 4-adjecent_island_tiles to the perimeter.
 * </pre>
 */

/**
 * Example Input:
 *
 * <pre>
 * 6 8
 * ....##..
 * .#####..
 * .###..#.
 * ...####.
 * ##......
 * .#......
 * </pre>
 *
 */
public class Erbatur {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "erbatur.dat";

  TileType[][] map;
  Boolean[][] ocean;
  int width;
  int height;

  // Cardinal directions
  final Point[] DIRECTIONS = {new Point(0, -1), new Point(-1, 0), new Point(0, 1), new Point(1, 0)};

  private Erbatur(Scanner scan) {
    height = scan.nextInt();
    width = scan.nextInt();
    scan.nextLine();
    map = new TileType[height][width];
    for (int y = 0; y < height; y++) {
      String line = scan.nextLine();
      for (int x = 0; x < width; x++) {
        map[y][x] = line.charAt(x) == '#' ? TileType.LAND : TileType.WATER;
      }
    }

    // Part 1
    ocean = new Boolean[height][width];
    for (int y = 0; y < height; y++)
      Arrays.fill(ocean[y], false);
    for (int y = 0; y < height; y++) {
      flood(new Point(0, y)); // left column
      flood(new Point(width - 1, y)); // right column
    }
    for (int x = 0; x < width; x++) {
      flood(new Point(x, 0)); // top row
      flood(new Point(x, height - 1)); // bottom row
    }
    long totalPerimeter = 0;
    // Anywhere where ocean[y][x] is *false* is island tiles (could still be lake)
    // Part 2
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Point cur = new Point(x, y);
        if (cur.access(ocean)) continue;
        long landNeighbors = Arrays.stream(DIRECTIONS).map(cur::add) // Get all adjacent tiles
            .filter(p -> p.valid(width, height)) // Only valid tiles
            .filter(p -> !p.access(ocean)) // Only count island tiles
            .count(); // Count adjacent island tiles
        totalPerimeter += 4 - landNeighbors;
      }
    }
    System.out.println(totalPerimeter);
  }

  // flood(y,x) because the map is [y][x]
  private void flood(Point p) {
    Stack<Point> stack = new Stack<>();
    stack.push(p);
    // must use an iterative method to avoid stack overflow
    // Each iteration is like a recursive flood(p) call
    while (!stack.isEmpty()) {
      p = stack.pop();
      if (p.access(map) != TileType.WATER) continue; // Only flood water!
      p.set(ocean, true);
      for (var dir : DIRECTIONS) {
        Point next = p.add(dir);
        if (!next.valid(width, height)) continue;
        if (next.access(ocean)) continue; // Already seen this tile
        if (next.access(map) == TileType.LAND) continue; // This is island
        stack.push(next);
      }
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Erbatur(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Point(int x, int y) {
  public Point add(Point p) {
    return new Point(this.x + p.x, this.y + p.y);
  }

  public boolean valid(int width, int height) {
    return x >= 0 && y >= 0 && x < width && y < height;
  }

  /** array[y][x] = value */
  public <T> void set(T[][] arr, T value) {
    arr[y][x] = value;
  }

  /** Access array[y][x] */
  public <T> T access(T[][] arr) {
    return arr[y][x];
  }
}

enum TileType {
  WATER, LAND
}
