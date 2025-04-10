import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Finding {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "finding.dat";

  private static int dijkstra(Node start, Node end) {
    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> previous = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> distances.get(n)));
    distances.put(start, 0);
    queue.add(start);
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (current == end) return distances.get(end);
      for (Node neighbor : current.neighbors) {
        int newDistance = distances.get(current) + neighbor.cost;
        if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
          distances.put(neighbor, newDistance);
          queue.add(neighbor);
          previous.put(neighbor, current);
        }
      }
    }
    throw new IllegalStateException("No path found");
  }

  private static void each(Scanner scan) {
    List<Node> graph = new ArrayList<>();
    int stoplightCount = scan.nextInt();
    int roadCount = scan.nextInt();
    int students = scan.nextInt();
    scan.nextLine();
    Node start = new Node(0);
    graph.add(start);
    for (int i = 0; i < stoplightCount; i++) {
      int cost = scan.nextInt();
      graph.add(new Node(cost));
    }
    Node end = new Node(students);
    graph.add(end);
    scan.nextLine();
    for (int i = 0; i < roadCount; i++) {
      int from = scan.nextInt();
      int to = scan.nextInt();
      if (scan.hasNextLine()) scan.nextLine();
      graph.get(from).neighbors.add(graph.get(to));
      graph.get(to).neighbors.add(graph.get(from));
    }
    int cost = dijkstra(start, end);
    System.out.println(cost);
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
}class Node {
  int cost;
  List<Node> neighbors = new ArrayList<>();

  public Node(int cost) {
    this.cost = cost;
  }
}
