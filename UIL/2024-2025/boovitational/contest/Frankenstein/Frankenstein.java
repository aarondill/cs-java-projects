import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

record Point(int x, int y) {};

public class Frankenstein {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "frankenstein.dat";

  static Point start = new Point(-1, -1);
  static Point end = new Point(-1, -1);

  private static void each(Scanner scan) {
    List<List<Integer>> maze = new ArrayList<>();
    int size = scan.nextInt();
    scan.nextLine();
    start = new Point(-1, -1);
    end = new Point(-1, -1);
    for (int x = 0; x < size; x++) {
      List<Integer> row = new ArrayList<>();
      String[] irow = scan.nextLine().split("");
      for (int y = 0; y < size; y++) {
        String c = irow[y];
        if (c.equals("@")) {
          row.add(0);
          start = new Point(x, y);
        } else if (c.equals("!")) {
          row.add(1);
          end = new Point(x, y);
        } else if (c.equals("#")) {
          row.add(0);
        } else {
          row.add(1);
        }
      }
      maze.add(row);
    }
    trueLowest = Integer.MAX_VALUE;
    truePath.clear();
    shortest(maze, new ArrayList<>(), start, 0);
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        if (truePath.contains(new Point(x, y))) {
          System.out.print('*');
        } else System.out.print('#');
      }
      System.out.println();
    }
    System.out.println();
  }

  static int trueLowest = Integer.MAX_VALUE;
  static List<Point> truePath = new ArrayList<>();

  public static int shortest(List<List<Integer>> maze, List<Point> prev, Point curr, int len) {
    prev = new ArrayList<>(prev);
    prev.add(curr);
    if (curr.equals(end)) {
      if (len < trueLowest) {
        trueLowest = len;
        truePath = prev;
      }
      return len;
    }

    int lowest = Integer.MAX_VALUE;

    Point hNext = new Point(curr.x() + 1, curr.y());
    if (hNext.x() >= maze.size() || hNext.y() >= maze.size() || hNext.x() < 0 || hNext.y() < 0) {
    } else if (maze.get(hNext.x()).get(hNext.y()) == 0) {
    } else if (prev.contains(hNext)) {
    } else {
      int hLen = shortest(maze, prev, hNext, len + 1);
      if (hLen < lowest) lowest = hLen;
    }

    Point hPrev = new Point(curr.x() - 1, curr.y());
    if (hPrev.x() >= maze.size() || hPrev.y() >= maze.size() || hPrev.x() < 0 || hPrev.y() < 0) {
    } else if (maze.get(hPrev.x()).get(hPrev.y()) == 0) {
    } else if (prev.contains(hPrev)) {
    } else {
      int hLen = shortest(maze, prev, hPrev, len + 1);
      if (hLen < lowest) lowest = hLen;
    }

    Point vNext = new Point(curr.x(), curr.y() + 1);
    if (vNext.x() >= maze.size() || vNext.y() >= maze.size() || vNext.x() < 0 || vNext.y() < 0) {
    } else if (maze.get(vNext.x()).get(vNext.y()) == 0) {
    } else if (prev.contains(vNext)) {
    } else {
      int hLen = shortest(maze, prev, vNext, len + 1);
      if (hLen < lowest) lowest = hLen;
    }

    Point vPrev = new Point(curr.x(), curr.y() - 1);
    if (vPrev.x() >= maze.size() || vPrev.y() >= maze.size() || vPrev.x() < 0 || vPrev.y() < 0) {
    } else if (maze.get(vPrev.x()).get(vPrev.y()) == 0) {
    } else if (prev.contains(vPrev)) {
    } else {
      int hLen = shortest(maze, prev, vPrev, len + 1);
      if (hLen < lowest) lowest = hLen;
    }

    return lowest;
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
