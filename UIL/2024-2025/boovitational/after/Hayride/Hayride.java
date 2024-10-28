import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

class Node {
  private final String name;
  private final Map<Node, Integer> connections = new HashMap<>();

  public String name() {
    return name;
  }

  public void addConnection(Node node, int weight) {
    connections.put(node, weight);
  }

  public Map<Node, Integer> connections() {
    return Collections.unmodifiableMap(connections);
  }

  Node(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

}

public class Hayride {
  private static final String INPUT_FILE = "hayride.dat";

  private static record Result(Map<Node, Integer> distances, Map<Node, Node> parents) {}

  private static Result dijkstra(Node start) {
    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> parents = new HashMap<>();
    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
    distances.put(start, 0);
    pq.add(start);
    while (!pq.isEmpty()) {
      Node current = pq.remove();
      for (var entry : current.connections().entrySet()) {
        Node neighbor = entry.getKey();
        int weight = entry.getValue();
        int newDistance = distances.get(current) + weight;
        if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
          distances.put(neighbor, newDistance);
          parents.put(neighbor, current);
          pq.add(neighbor);
        }
      }
    }
    return new Result(distances, parents);
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int connectionCount = Integer.parseInt(scan.nextLine());
    Map<String, Node> nodes = new HashMap<>();
    for (int i = 0; i < connectionCount; i++) {
      String first = scan.next();
      String second = scan.next();
      int weight = scan.nextInt();
      if (scan.hasNextLine()) scan.nextLine();
      Node firstNode = nodes.computeIfAbsent(first, Node::new);
      Node secondNode = nodes.computeIfAbsent(second, Node::new);
      firstNode.addConnection(secondNode, weight);
      // secondNode.addConnection(firstNode, weight); // Bidirectional? Check the problem statement.
    }
    Node start = Objects.requireNonNull(nodes.get("Start"), "Start node not found");
    Node stop = Objects.requireNonNull(nodes.get("Stop"), "Stop node not found");
    Result result = dijkstra(start);
    // Output? Check the problem statement.
    List<String> path = Stream.iterate(stop, Objects::nonNull, result.parents()::get).map(Node::name).toList();
    System.out.println("Shortest path from Start to Stop:");
    System.out.println(String.join(" -> ", path.reversed()));
    System.out.println("Cost: " + result.distances().get(stop));

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
