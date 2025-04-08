import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Brian {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "brian.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int numNodes = scan.nextInt(); // number of nodes
    int numCons = scan.nextInt();
    scan.nextLine();
    Map<String, Node> nodes = new HashMap<>(numNodes);
    List<String[]> lines = new ArrayList<>();
    // Create nodes by names (so we can look them up and connect them later)
    for (int i = 0; i < numCons; i++) {
      String[] line = scan.nextLine().split(" ");
      lines.add(line);
      String n1 = line[0];
      String n2 = line[1];
      nodes.computeIfAbsent(n1, Node::new);
      nodes.computeIfAbsent(n2, Node::new);
    }

    // Get each of the connections and connect them
    for (String[] line : lines) {
      Node one = nodes.get(line[0]), two = nodes.get(line[1]);
      int weight = Integer.parseInt(line[2]);
      one.add(two, weight);
      // NOTE: **NOT** bidirectional, the quest doesn't make this clear, but
      // the correct answer is only gotten if you don't treat it as
      // bidirectional
    }

    // Get the start and end nodes
    Node start = nodes.computeIfAbsent(scan.next(), Node::new);
    Node end = nodes.computeIfAbsent(scan.next(), Node::new);
    scan.nextLine();

    Map<Node, Integer> dist = bellmanFord(start);
    if (dist == null) System.out.println("Take as long as you need.");
    else System.out.println(dist.get(end));
  }

  public static Map<Node, Integer> bellmanFord(Node start) {
    Map<Node, Integer> dist = new HashMap<>();
    dist.put(start, 0);
    for (int i = 0; i <= dist.size(); i++) { // loop V times
      // copy to avoid concurrent modification
      for (Node from : new HashSet<>(dist.keySet())) { // each seen node
        for (Node to : from.cons().keySet()) { // contract each edge
          int newDist = dist.get(from) + from.cons().get(to);
          if (newDist < dist.getOrDefault(to, Integer.MAX_VALUE)) {
            if (i == dist.size()) return null; // negative cycle
            dist.put(to, newDist);
          }
        }
      }
    }
    return dist;
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

record Node(Map<Node, Integer> cons, String name) {
  public Node(String n) {
    this(new HashMap<>(), n);
  }

  public boolean equals(Object o) {
    if (!(o instanceof Node n)) return false;
    return n.name == this.name;
  }

  public void add(Node n, int weight) {
    cons.put(n, weight);
  }

  public int hashCode() {
    return name.hashCode();
  }

  public String toString() {
    return name;
  }
}
