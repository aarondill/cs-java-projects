import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Prachi {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "prachi.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int rows = scan.nextInt(), cols = scan.nextInt();
    int sourceY = scan.nextInt(), sourceX = scan.nextInt();
    Point source = new Point(sourceX, sourceY);
    scan.nextLine();
    Grid grid = new Grid(rows, cols);
    for (int y = 0; y < rows; y++) {
      String line = scan.nextLine();
      for (int x = 0; x < cols; x++)
        grid.set(new Point(x, y), Space.fromChar(line.charAt(x)));
    }
    if (grid.get(source) != Space.EMPTY) throw new IllegalArgumentException("Source is not empty");
    List<Point> occupied = recurse(grid, source, new HashSet<>());
    for (Point p : occupied)
      grid.set(p, Space.WATER);
    System.out.println(grid);
  }

  private static List<Point> recurse(Grid g, Point current, Set<Point> visited) {
    visited.add(current);
    List<Point> occupied = new ArrayList<>(List.of(current));
    current.cardinals().stream().filter(Predicate.not(visited::contains)).filter(g::valid)
        .filter(p -> g.get(p) == Space.EMPTY).map(p -> recurse(g, p, visited)).forEach(occupied::addAll);
    return occupied;
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

class Grid {
  private final List<List<Space>> graph = new ArrayList<>();

  Grid(int rows, int cols) {
    for (int i = 0; i < rows; i++)
      graph.add(new ArrayList<>(Collections.nCopies(cols, null)));
  }

  public Grid set(Point position, Space space) {
    graph.get(position.y()).set(position.x(), space);
    return this;
  }

  public Space get(Point position) {
    return graph.get(position.y()).get(position.x());
  }

  public boolean valid(Point position) {
    return position.y() >= 0 && position.y() < graph.size() && position.x() >= 0
        && position.x() < graph.get(position.y()).size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (List<Space> row : graph) {
      row.stream().map(Space::toChar).forEach(sb::append);
      sb.append('\n');
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
}

record Point(int x, int y) {
  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  public List<Point> cardinals() {
    return List.of(new Point(x, y - 1), new Point(x + 1, y), new Point(x, y + 1), new Point(x - 1, y));
  }
}

enum Space {
  EMPTY, WALL, WATER;

  public static Space fromChar(char c) {
    return switch (c) {
      case '.' -> EMPTY;
      case '#' -> WALL;
      default -> throw new IllegalArgumentException("Invalid character: " + c);
    };
  }

  public char toChar() {
    return switch (this) {
      case EMPTY -> '.';
      case WALL -> '#';
      case WATER -> '$';
    };
  }
}
