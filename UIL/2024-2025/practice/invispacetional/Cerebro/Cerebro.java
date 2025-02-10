import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Cerebro {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "cerebro.dat";

  private static void each(Scanner scan) {
    int destCount = scan.nextInt();
    int connectionCount = scan.nextInt();
    scan.nextLine();
    Map<String, Node> nodes = new HashMap<>();
    for (int i = 0; i < connectionCount; i++) {
      Node n = nodes.computeIfAbsent(scan.next(), Node::new);
      Node connectNode = nodes.computeIfAbsent(scan.next(), Node::new);
      n.connections().add(connectNode);
      scan.nextLine();
    }
    Node start = nodes.get("Xavier");
    if (start == null) throw new IllegalStateException("Could not find start node");
    for (int i = 0; i < destCount; i++) {
      Node end = nodes.get(scan.nextLine());
      if (dijkstra(start, end)) System.out.println("Mutant Located.");
      else System.out.println("Nowhere to be found.");
    }
  }

  public static boolean dijkstra(Node start, Node end) {
    Map<Node, Integer> distances = new HashMap<>();
    Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
    distances.put(start, 0);
    queue.add(start);
    while (!queue.isEmpty()) {
      Node current = queue.remove();
      if (current == end) return true;
      for (Node n : current.connections()) {
        int newDistance = distances.get(current) + 1;
        if (newDistance < distances.getOrDefault(n, Integer.MAX_VALUE)) {
          distances.put(n, newDistance);
          queue.add(n);
        }
      }
    }
    return false;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Node(String name, List<Node> connections) {
  public Node(String name) {
    this(name, new ArrayList<>());
  }

  @Override
  public String toString() {
    return name;
  }

  public boolean equals(Object o) {
    return o instanceof Node other && name.equals(other.name);
  }

  public int hashCode() {
    return name.hashCode();
  }
}
