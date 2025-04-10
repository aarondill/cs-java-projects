import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Trap {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "trap.dat";

  // Returns the last tile that can be reached from the start point
  private Tile canReachEnd(Point p, Direction toCenter) {
    while (p.get(graph) == Tile.EMPTY) {
      rotateGrid(graph, intensity);
      p = p.move(toCenter);
    }
    return p.get(graph);
  }

  Tile[][] graph;
  int intensity;

  private Trap(Scanner scan) {
    int height = scan.nextInt(), width = scan.nextInt();
    int starty = scan.nextInt(), startx = scan.nextInt();
    scan.nextLine();
    char direction = scan.next().charAt(0);
    intensity = scan.nextInt(); // number of times it rotates each second
    scan.nextLine();
    // normalize for rotateGrid
    if (direction == 'R') intensity = -intensity;
    else if (direction != 'L') throw new IllegalArgumentException("Invalid direction: " + direction);

    graph = new Tile[height][width];
    for (int y = 0; y < height; y++) {
      String line = scan.nextLine();
      for (int x = 0; x < width; x++) {
        graph[y][x] = Tile.fromChar(line.charAt(x));
      }
    }
    Point start = new Point(startx, starty), center = new Point(width / 2, height / 2);
    Tile last = canReachEnd(start, start.directionTo(center));
    System.out.println(switch (last) {
      case END -> "New candies are mine.";
      case TRAP -> "Trapped.";
      case VOLCANO -> "Goodbye world.";
      default -> throw new IllegalStateException("Unexpected tile: " + last);
    });
  }

  // Rotates the grid counterclockwise k times in place; Pass a negative k to rotate clockwise
  // Source: https://blog.heycoach.in/cyclically-rotating-a-grid-solution-in-java/
  public static <T> T[][] rotateGrid(T[][] grid, int k) {
    final int height = grid.length, width = grid[0].length;
    // The window of the edges we're rotating
    int top = 0, left = 0, bottom = height - 1, right = width - 1;
    if (k == 0) return grid; // No rotation needed
    while (top < bottom && left < right) {
      final int elementInThisLayer = 2 * (bottom - top + 1) + 2 * (right - left + 1) - 4;
      final int netRotations = (elementInThisLayer + (k % elementInThisLayer)) % elementInThisLayer; // Handle negative k
      for (int rotate = 0; rotate < netRotations; ++rotate) {
        final T topLeft = grid[top][left];
        for (int x = left; x < right; ++x)
          grid[top][x] = grid[top][x + 1];
        for (int y = top; y < bottom; ++y)
          grid[y][right] = grid[y + 1][right];
        for (int x = right; x > left; --x)
          grid[bottom][x] = grid[bottom][x - 1];
        for (int y = bottom; y > top; --y)
          grid[y][left] = grid[y - 1][left];
        grid[top + 1][left] = topLeft;
      }
      // Move towards the center
      ++top;
      ++left;
      --bottom;
      --right;
    }
    return grid;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Trap(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

enum Direction {
  EAST(1, 0), NORTH(0, -1), WEST(-1, 0), SOUTH(0, 1), NONE(0, 0);

  final int dx;
  final int dy;

  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

}

record Point(int x, int y) {
  public <T> T get(T[][] grid) {
    return grid[y][x];
  }

  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  public Point move(Direction direction) {
    return new Point(x + direction.dx, y + direction.dy);
  }

  // The direction from this point to the other point.
  public Direction directionTo(Point other) {
    if (equals(other)) return Direction.NONE;
    if (x == other.x) return y > other.y ? Direction.NORTH : Direction.SOUTH;
    return x < other.x ? Direction.EAST : Direction.WEST;
  }
}

enum Tile {
  EMPTY('.'), TRAP('#'), VOLCANO('@'), END('E');

  final char ch;

  Tile(char ch) {
    this.ch = ch;
  }

  public static Tile fromChar(char ch) {
    return Arrays.stream(values()).filter(tile -> tile.ch == ch).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid tile: " + ch));
  }
}
