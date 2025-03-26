import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Brian {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "brian.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int nodsafndsaelkfn = scan.nextInt();
    int numCons = scan.nextInt();
    scan.nextLine();
    Map<String, Node> nodes = new HashMap<>();
    List<String[]> lines = new ArrayList<>();
    for (int i = 0; i < numCons; i++) {
      String[] line = scan.nextLine().split(" ");
      lines.add(line);
      String n1 = line[0];
      String n2 = line[1];
      nodes.computeIfAbsent(n1, Node::new);
      nodes.computeIfAbsent(n2, Node::new);
    }

    List<Connection> allCon = new ArrayList<>();
    for (String[] line : lines) {
      Node one = nodes.get(line[0]);
      Node two = nodes.get(line[1]);
      int weight = Integer.parseInt(line[2]);
      Connection c = new Connection(one, two, weight);
      allCon.add(c);
      one.cons().add(c);
      two.cons().add(c); // NOTE: bidirectional
    }
    int minCon = allCon.stream().mapToInt(c -> c.weight).min().orElse(0);
    if (minCon < 0) {
      allCon.stream().forEach(c -> c.weight += Math.abs(minCon));
    }

    Node start = nodes.computeIfAbsent(scan.next(), Node::new);
    Node end = nodes.computeIfAbsent(scan.next(), Node::new);
    scan.nextLine();

    Map<Node, Node> prev = dijkstra(start, end);

    if (minCon < 0) {
      allCon.stream().forEach(c -> c.weight -= Math.abs(minCon));
    }
    int dist = 0;
    Node c = end;
    while (c != null) {

      c = prev.get(c);
    }
    System.out.println(prev);
  }

  public static Map<Node, Node> dijkstra(Node start, Node end) {
    Map<Node, Integer> distance = new HashMap<>();
    Map<Node, Node> prev = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(start);
    distance.put(start, 0);
    while (pq.isEmpty()) {
    }

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

class Connection {
  Node one;
  Node two;
  int weight;

  public Connection(Node one, Node two, int weight) {
    this.one = one;
    this.two = two;
    this.weight = weight;
  }
}

record Node(Set<Connection> cons, String name) {
  public Node(String n) {
    this(new HashSet<>(), n);
  }

  public boolean equals(Object o) {
    if (!(o instanceof Node n)) return false;
    return n.name == this.name;
  }

  public int hashCode() {
    return name.hashCode();
  }
}
