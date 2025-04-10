import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Trap {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "trap.dat";

  private static void each(Scanner scan) {
    Point start, center;
    PolarGraph<Tile> polarGraph;
    char direction;
    int intensity;
    {
      int width = scan.nextInt();
      int height = scan.nextInt();
      int starty = scan.nextInt();
      int startx = scan.nextInt();
      scan.nextLine();
      direction = scan.next().charAt(0);
      intensity = scan.nextInt(); // number of times it rotates each second
      scan.nextLine();
      Tile[][] graph = new Tile[height][width];
      for (int y = 0; y < height; y++) {
        String line = scan.nextLine();
        for (int x = 0; x < width; x++) {
          graph[y][x] = Tile.fromChar(line.charAt(x));
        }
      }
      start = new Point(startx, starty);
      center = new Point(width / 2, height / 2);
      polarGraph = new PolarGraph<>(graph, Direction.EAST);
    }
    Point p = start;
    Direction toCenter = start.directionTo(center);
    System.out.println(p);
    loop: while (!p.equals(center)) {
      for (int i = 0; i < intensity; i++) {
        if (direction == 'L') polarGraph.counterClockwise();
        else polarGraph.clockwise();
      }
      p = p.move(toCenter);
      System.out.println(p);
      switch (polarGraph.get(p)) {
        case EMPTY -> { // noop
        }
        case TRAP, VOLCANO -> {
          System.out.println("Trap at " + p);
          break loop;
        }
        case END -> {
          break loop;
        }
      }
    }
    Tile last = polarGraph.get(p);
    if (last == Tile.END) System.out.println("New candies are mine.");
    else if (last == Tile.TRAP) System.out.println("Trapped.");
    else System.out.println("Goodbye world.");
    System.out.println();

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

/**
 * Represents a 2 dimentional graph, accessed via rotation and distance instead
 * of [y][x]
 */
class PolarGraph<T> {
  // Index [y][x]
  private final T[][] graph;
  private final int width;
  private final int height;

  private Direction rotation;

  public PolarGraph(T[][] graph, Direction rotation) {
    this.graph = graph;
    this.width = graph.length;
    this.height = graph[0].length; // Rectangular graph
    this.rotation = rotation;
  }

  public void clockwise() {
    rotation = rotation.clockwise();
  }

  public void counterClockwise() {
    rotation = rotation.counterClockwise();
  }

  // Top left is 0,0
  public T get(Point p) {
    int x = p.x(), y = p.y();
    return get(x, y);
  }

  public T get(int x, int y) {
    // Indexed from the center (left side is -width/2, top is -height/2)
    int adjx = x - width / 2;
    int adjy = height / 2 - y; // y should decrease upwards; but mathematically it's the opposite
    double distance = Math.hypot(adjx, adjy);
    int theta = (int) Math.toDegrees(Math.atan2(adjy, adjx)) + rotation.deg;
    theta = (theta + 360) % 360;
    Direction rotation = Direction.closest(theta);
    if (rotation.deg != theta)
      throw new IllegalStateException("Rotation is not a multiple of 45: " + theta + " " + rotation.deg);
    System.out.println("get(" + x + "," + y + ") = d=" + distance + ",Θ=" + theta);
    return get(distance, theta);
  }

  /**
   * Returns the value at the given distance and rotation
   *
   * @param distance the distance from the center
   * @param rotation the rotation from the center
   * @return the value at the given distance and rotation
   */
  private T get(double distance, double rotation) {
    int x = (int) (distance * Math.round(Math.cos(Math.toRadians(rotation))));
    int y = (int) (distance * Math.round(Math.sin(Math.toRadians(rotation))));
    System.out.println("adjx=" + x + ",adjy=" + y);
    x += width / 2;
    y = height / 2 - y; // y should decrease upwards; but mathematically it's the opposite
    System.out.printf("Getting d=%s,Θ=%s => x=%s,y=%s at current graph rot %d\n", distance, rotation, x, y,
        this.rotation.deg);
    return graph[y][x];
  }

}

enum Direction {
  EAST(0, 1, 0), NORTH(90, 0, -1), WEST(180, -1, 0), SOUTH(270, 0, 1); // Order is important

  final int deg;
  final int dx;
  final int dy;

  Direction(int deg, int dx, int dy) {
    this.deg = deg;
    this.dx = dx;
    this.dy = dy;
  }

  public static Direction closest(int deg) {
    // Normalize (do twice to handle negatives)
    final int normal = ((deg % 360) + 360) % 360;
    return Arrays.stream(values()).min((a, b) -> Integer.compare(Math.abs(a.deg - normal), Math.abs(b.deg - normal)))
        .get();
  }

  public Direction clockwise() {
    int nextIndex = (ordinal() + 1) % values().length;
    return values()[nextIndex];
  }

  public Direction counterClockwise() {
    int nextIndex = (ordinal() + values().length - 1) % values().length;
    return values()[nextIndex];
  }
}

record Point(int x, int y) {
  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  public Point move(Direction direction) {
    return new Point(x + direction.dx, y + direction.dy);
  }

  // The direction from this point to the other point.
  public Direction directionTo(Point other) {
    if (x == other.x) {
      if (y < other.y) return Direction.NORTH; // NORTH
      if (y > other.y) return Direction.SOUTH; // SOUTH
    }
    if (y == other.y) {
      if (x < other.x) return Direction.EAST; // EAST
      if (x > other.x) return Direction.WEST; // WEST
    }
    throw new IllegalStateException("Points are not on a line: " + this + " and " + other);
  }
}

enum Tile {
  EMPTY('.'), TRAP('#'), VOLCANO('@'), END('E');

  final char ch;

  Tile(char ch) {
    this.ch = ch;
  }

  public static Tile fromChar(char ch) {
    for (Tile tile : values()) {
      if (tile.ch == ch) return tile;
    }
    throw new IllegalArgumentException("No tile for char " + ch);
  }
}
