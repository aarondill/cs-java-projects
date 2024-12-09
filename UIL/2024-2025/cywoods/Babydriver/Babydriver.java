import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

record Point(int x, int y) {}

enum Type {
  ROAD, EXIT, POLICE;

  public static Type fromChar(char c) {
    return switch (c) {
      case '-' -> ROAD;
      case 'E' -> EXIT;
      case 'P' -> POLICE;
      default -> throw new IllegalArgumentException("Invalid type: " + c);
    };
  }
}

class Node {
  Type type;
  List<Node> neighbors = new ArrayList<>();

  public Node(Type type) {
    this.type = type;
  }

}

public class Babydriver {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "babydriver.dat";

  private static boolean dijkstra(Node start) {
    if (start.type == Type.EXIT) return true;

    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> previous = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> distances.get(n)));
    distances.put(start, 0);
    queue.add(start);
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      for (Node neighbor : current.neighbors) {
        //  Check if neighbor is a police station
        if (neighbor.type == Type.POLICE) continue;
        if (neighbor.neighbors.stream().anyMatch(n -> n.type == Type.POLICE)) continue;

        if (neighbor.type == Type.EXIT) return true;

        int newDistance = distances.get(current) + 1;
        if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
          distances.put(neighbor, newDistance);
          previous.put(neighbor, current);
          queue.add(neighbor);
        }
      }
    }
    return false;

  }

  private static void each(Scanner scan) {
    // Parse the input:
    int rows = scan.nextInt();
    int columns = scan.nextInt();
    int testNumbers = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();
    Node[][] grid = new Node[rows][columns];
    for (int i = 0; i < rows; i++) {
      String row = scan.nextLine();
      for (int j = 0; j < columns; j++) {
        if (row.charAt(j) == '#') continue;
        grid[i][j] = new Node(Type.fromChar(row.charAt(j)));
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == null) continue;
        if (i + 1 < grid.length && grid[i + 1][j] != null) grid[i][j].neighbors.add(grid[i + 1][j]);
        if (j + 1 < grid[i].length && grid[i][j + 1] != null) grid[i][j].neighbors.add(grid[i][j + 1]);
        if (i - 1 >= 0 && grid[i - 1][j] != null) grid[i][j].neighbors.add(grid[i - 1][j]);
        if (j - 1 >= 0 && grid[i][j - 1] != null) grid[i][j].neighbors.add(grid[i][j - 1]);
      }
    }
    for (int i = 0; i < testNumbers; i++) {
      Node start = grid[scan.nextInt()][scan.nextInt()];
      if (scan.hasNextLine()) scan.nextLine();
      boolean canExit = start == null ? false : dijkstra(start);
      System.out.println(canExit ? "We're gonna make it out!" : "We're a little cooked.");
    }
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
