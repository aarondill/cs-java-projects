import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sarac {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "sarac.dat";

  private boolean hasCycle(Node node) {
    Set<Node> visited = new HashSet<>();
    Deque<Node> stack = new ArrayDeque<>(List.of(node));
    while (!stack.isEmpty()) {
      visited.add(node = stack.pop());
      for (Node neighbor : node.neighbors()) {
        if (visited.contains(neighbor)) return true;
        stack.push(neighbor);
      }
    }
    return false;
  }

  /**
   * <pre>
   * 4 3
   * P1 P2 R1 R2
   * R1->P1 P1->R2 P2->R1
   * </pre>
   */
  private Sarac(Scanner scan) {
    /* int nodeCount = */ scan.nextInt();
    int connectionCount = scan.nextInt();
    scan.nextLine();
    Map<String, Node> nodes =
        Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toMap(Function.identity(), Node::new));
    for (int i = 0; i < connectionCount; i++) {
      String[] parts = scan.next().split("->");
      Node from = nodes.get(parts[0]), to = nodes.get(parts[1]);
      from.neighbors().add(to);
    }
    scan.nextLine();
    boolean cyclic = nodes.values().stream().filter(n -> n.name().startsWith("P")).anyMatch(this::hasCycle);
    if (cyclic) System.out.println("Deadlock exists; not good...");
    else System.out.println("Deadlock free; all is well");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Sarac(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

/**
 * A node is either a resource or a process. Recources can only have connection
 * to processes and vice versa.
 */
record Node(String name, List<Node> neighbors) {
  public Node(String name) {
    this(name, new ArrayList<>());
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Node n && name.equals(n.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
