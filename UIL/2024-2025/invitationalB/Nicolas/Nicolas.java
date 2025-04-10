import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * 5 6
 * S###.E
 * .#.#.#
 * .#.#.#
 * ......
 * #..#..
 * </pre>
 */
public class Nicolas {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "nicolas.dat";
  // Indexed [y][x]
  private char[][] grid;

  public boolean walkable(Point p) {
    return p.valid(grid) && p.access(grid) == '.';
  }

  /**
   * Return shortest path from start to end. If multiple paths exist, return the
   * lexographically first one. Visited cells aren't considered.
   */
  public List<Direction> breadthFirstSearch(Point start, Point end) {
    Map<Point, Point> prev = new HashMap<>();
    Set<Point> visited = new HashSet<>(List.of(start));
    Queue<Point> queue = new ArrayDeque<>(List.of(start));
    outer: while (!queue.isEmpty()) {
      Point node = queue.remove();
      for (Direction dir : Direction.values()) {
        Point edge = step(node, dir, end);
        if (!walkable(edge) || !visited.add(edge)) continue;
        prev.put(edge, node);
        if (edge.equals(end)) break outer; // end node was found
        queue.add(edge);
      }
    }
    return Stream.iterate(end, p -> p != start, prev::get).map(p -> prev.get(p).direction(p)).toList().reversed();
  }

  /*
   * Note: may return an invalid path if start+1 is a wall/invalid. Moves one step
   * in the given direction. Returns the new position (after sliding). *always*
   * takes at least one step.
   */
  public Point step(Point start, Direction dir, Point end) {
    Point next = (start = start.move(dir)); // *always* move at least one step
    // if next=invalid/wall, return start; If start=end, return start
    while (walkable(next) && !start.equals(end))
      next = (start = next).move(dir);
    return start;
  }

  private Nicolas(Scanner scan) {
    int height = scan.nextInt(), width = scan.nextInt();
    scan.nextLine();
    grid = new char[height][];
    for (int y = 0; y < height; y++) {
      grid[y] = scan.nextLine().toCharArray();
    }

    Point start = IntStream.range(0, height).boxed()
        .flatMap(y -> IntStream.range(0, width).mapToObj(x -> new Point(x, y)).filter(p -> p.access(grid) == 'S'))
        .findAny().get();
    Point end = IntStream.range(0, height).boxed()
        .flatMap(y -> IntStream.range(0, width).mapToObj(x -> new Point(x, y)).filter(p -> p.access(grid) == 'E'))
        .findAny().get();
    // Reset these in the grid
    grid[start.y()][start.x()] = '.';
    grid[end.y()][end.x()] = '.';

    List<Direction> path = breadthFirstSearch(start, end);
    System.out.println(path.stream().map(Direction::toString).collect(Collectors.joining()));
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Nicolas(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Point(int x, int y) {
  public Point move(Direction dir) {
    return add(dir.point());
  }

  /**
   * returns the direction from this point to the other point, such that
   * p.move(p.direction(other)) == other
   */
  public Direction direction(Point other) {
    if (x == other.x) return y < other.y ? Direction.SOUTH : Direction.NORTH;
    return x < other.x ? Direction.EAST : Direction.WEST;
  }

  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  public char access(char[][] grid) {
    return grid[y][x];
  }

  public boolean valid(char[][] grid) {
    return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
  }
}

enum Direction {
  // NOTE: This order is important. Lexographical order.
  EAST(1, 0), NORTH(0, -1), SOUTH(0, 1), WEST(-1, 0);

  private final int dx, dy;

  public Point point() {
    return new Point(dx, dy);
  }

  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  public String toString() {
    return switch (this) {
      case NORTH -> "N";
      case SOUTH -> "S";
      case EAST -> "E";
      case WEST -> "W";
    };
  }
}
