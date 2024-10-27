import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

record Point(int x, int y) {}

// Represents an available location in the maze.
class Node {
  final Point location;
  private HashSet<Node> neighbors = new HashSet<>(); // neighbors have weight of 1

  public Node addNeighbor(Node node) {
    neighbors.add(node);
    return this;
  }

  public Set<Node> neighbors() {
    return Collections.unmodifiableSet(neighbors);
  }

  public Node(Point location) {
    this.location = location;
  }
}

public class Frankenstein {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "frankenstein.dat";

  private record Result(Map<Node, Integer> distances, Map<Node, Node> previous) {}

  private static Result dijkstra(Node start) {
    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> previous = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> distances.get(n)));
    distances.put(start, 0);
    pq.add(start);
    while (!pq.isEmpty()) {
      var current = pq.poll();
      for (var neighbor : current.neighbors()) {
        int newDistance = distances.get(current) + 1;
        if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
          distances.put(neighbor, newDistance);
          previous.put(neighbor, current);
          pq.add(neighbor);
        }
      }
    }
    return new Result(distances, previous);
  }

  private static void each(Scanner scan) {
    int dim = Integer.parseInt(scan.nextLine(), 10);
    // Note: Nodes keep track of their own position, the array is only to link them together initially.
    Node[][] maze = new Node[dim][dim];

    // Parse the maze into a 2D array of Nodes and mark the start and end.
    Node start = null, end = null;
    for (int x = 0; x < dim; x++) {
      String line = scan.nextLine();
      for (int y = 0; y < dim; y++) {
        Point p = new Point(x, y);
        maze[x][y] = switch (line.charAt(y)) {
          case '*' -> new Node(p); // Path
          case '@' -> start = new Node(p); // Start (path)
          case '!' -> end = new Node(p); // End (path)
          default -> null; // Ignore walls '#'
        };
      }
    }

    // Connect to all adjacent paths
    for (int x = 0; x < dim; x++) {
      for (int y = 0; y < dim; y++) {
        if (maze[x][y] == null) continue;
        // All cardinal directions, if non-null
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i], ny = y + dy[i];
          if (nx >= 0 && nx < dim && ny >= 0 && ny < dim && maze[nx][ny] != null) {
            maze[x][y].addNeighbor(maze[nx][ny]);
          }
        }
      }
    }
    maze = null; // After this point, the array is no longer needed.

    // Get the shortest path from start to all other nodes
    Result result = dijkstra(start);

    // Get all Points in the shortest path from start to end
    Set<Point> path = new HashSet<>();
    for (var node = end; node != null; node = result.previous.get(node))
      path.add(node.location);

    // Print the maze, only showing points in the shortest path
    for (int x = 0; x < dim; x++) {
      for (int y = 0; y < dim; y++) {
        if (path.contains(new Point(x, y))) System.out.print('*');
        else System.out.print('#');
      }
      System.out.println();
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
