import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

class Node {
  public List<Node> connections = new ArrayList<>();

  public void connect(Node n) {
    connections.add(n);
  }

  public int index;

  Node(int i) {
    this.index = i;
  }

  @Override
  public String toString() {
    return String.format("Node [%d]", this.index);
  }

  /** Note: a recursive method! *Could* hit StackOverflow, but unlikely. */
  private static boolean isCyclic(Node n, Set<Node> seen, Node lastVisited) {
    if (seen.contains(n)) return true;
    seen.add(n);
    for (Node connection : n.connections) {
      if (connection == lastVisited) continue; // Connections are bi-directional -- we don't want to revisit the parent
      if (isCyclic(connection, seen, n)) return true;
    }
    return false;
  }

  public static boolean isCyclic(Node n) {
    return isCyclic(n, new HashSet<>(), null);
  }
}

public class Gardener {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "gardener.dat";

  private static boolean isTree(List<Node> nodes) {
    for (Node n : nodes) {
      if (n.connections.size() == 0) return false; // This graph is not connected!
    }
    return !Node.isCyclic(nodes.get(0)); // This graph is cyclic!
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int nodeCount = scan.nextInt();
    int edgeCount = scan.nextInt();
    scan.nextLine();
    List<Node> nodes = IntStream.range(0, nodeCount).mapToObj(Node::new).toList();
    for (int i = 0; i < edgeCount; i++) {
      Node startNode = nodes.get(scan.nextInt());
      Node endNode = nodes.get(scan.nextInt());
      scan.nextLine();
      startNode.connect(endNode);
      endNode.connect(startNode); // Note: BI-directional edges
    }
    System.out.println(isTree(nodes) ? "yes" : "no");
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
