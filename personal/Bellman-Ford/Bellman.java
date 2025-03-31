import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bellman {
  public final static record Result<T>(Map<Node<T>, Integer> distances, Map<Node<T>, Node<T>> prev) {}

  /**
   * Returns the shortest path from start to every node in the graph. The result
   * is a map of nodes to their distances from start. This is slower than
   * Dijkstra's algorithm, but it works for negative weights!
   */
  public static <T> Result<T> bellmanFord(Node<T> start) {
    Map<Node<T>, Integer> distances = new HashMap<>();
    Map<Node<T>, Node<T>> prev = new HashMap<>();
    distances.put(start, 0);
    // Keep relaxing edges until we have no more new edges (i=0, size=1; i=1, size>1; i=V-1, size=V)
    // Run until <= size to detect negative cycles
    for (int i = 0; i <= distances.size(); i++) {
      boolean changed = false;
      // copy to avoid concurrent modification
      for (var from : new HashSet<>(distances.keySet())) { // seen nodes
        for (Node<T> to : from.edges.keySet()) {
          int newDistance = distances.get(from) + from.edges.get(to);
          if (newDistance < distances.getOrDefault(to, Integer.MAX_VALUE)) {
            // If we find a shorter path after considering all edges, there is a negative cycle
            if (i == distances.size()) throw new IllegalStateException("Negative cycle detected");
            distances.put(to, newDistance);
            prev.put(to, from);
            changed = true;
          }
        }
      }
      if (!changed) break; // no changes, we're done!
    }
    return new Result<>(distances, prev);
  }

  public static void main(String[] args) {
    // Create nodes
    var a = new Node<>("A");
    var b = new Node<>("B");
    var c = new Node<>("C");
    var d = new Node<>("D");
    var e = new Node<>("E");
    var f = new Node<>("F");

    // Connect nodes
    a.addEdge(c, -1);
    c.addEdge(e, -20);
    e.addEdge(a, 1);
    a.addEdge(b, 6);
    b.addEdge(d, 2);

    // Create graph
    var start = a;
    var end = d;
    var result = bellmanFord(start);

    // Retreive shortest path from end to start
    List<Node<String>> path = new ArrayList<>();
    for (var curr = end; curr != start; curr = result.prev().get(curr))
      path.add(curr);
    path.add(start);

    // Print the result
    System.out.printf("Shortest distance from %s to %s:\n", start, end);
    System.out.println(path.reversed().stream().map(Node::toString).collect(Collectors.joining(" ")));
    System.out.println("Total cost: " + result.distances().get(end));
    // if (result.distances().get(end) != 24) throw new IllegalStateException("Wrong result");
  }
}

record Edge<T>(Node<T> from, Node<T> to, int weight) {}

class Node<T> {
  final Map<Node<T>, Integer> edges = new HashMap<>();
  final T value;

  public Node(T value) {
    this.value = value;
  }

  public Node<T> addEdge(Node<T> to, int weight) {
    edges.put(to, weight);
    return this;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Node<?> other && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}
