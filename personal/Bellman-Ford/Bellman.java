import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bellman {
  public final static record Result<T>(Map<Node<T>, Integer> distances, Map<Node<T>, Node<T>> prev) {}

  public static <T> Result<T> bellmanFord(List<Node<T>> nodes, Node<T> start) {
    Set<Edge<T>> edges = nodes.stream().flatMap(n -> n.getEdges()).collect(Collectors.toSet());
    // Initialize
    Map<Node<T>, Integer> distances = new HashMap<>(); // default to infinity
    Map<Node<T>, Node<T>> prev = new HashMap<>();
    distances.put(start, 0);
    // Relax edges v-1 times
    for (int i = 0; i < nodes.size() - 1; i++) {
      for (var edge : edges) {
        Node<T> u = edge.from(), v = edge.to();
        if (!distances.containsKey(u)) continue;
        int newDistance = distances.get(u) + edge.weight();
        if (newDistance < distances.getOrDefault(v, Integer.MAX_VALUE)) {
          distances.put(v, newDistance);
          prev.put(v, u);
        }
      }
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
    a.addEdge(b, 10).addEdge(c, 15);
    b.addEdge(d, 12).addEdge(f, 15);
    d.addEdge(f, 1).addEdge(e, 2);
    f.addEdge(e, 1);
    c.addEdge(e, 10);

    // Create graph
    var start = a;
    var end = e;
    var result = bellmanFord(List.of(a, b, c, d, e, f), start);

    // Retreive shortest path from end to start
    List<Node<String>> path = new ArrayList<>();
    for (var curr = end; curr != null; curr = result.prev().get(curr))
      path.add(curr);

    // Print the result
    System.out.println("Shortest distance from A to E:");
    System.out.println(path.reversed().stream().map(Node::toString).collect(Collectors.joining(" ")));
    System.out.println("Total cost: " + result.distances().get(e));
    if (result.distances().get(end) != 24) throw new IllegalStateException("Wrong result");
  }
}

record Edge<T>(Node<T> from, Node<T> to, int weight) {}

class Node<T> {
  final List<Edge<T>> edges = new ArrayList<>();
  final T value;

  public Node(T value) {
    this.value = value;
  }

  public Node<T> addEdge(Node<T> to, int weight) {
    edges.add(new Edge<>(this, to, weight));
    return this;
  }

  public Stream<Edge<T>> getEdges() {
    return edges.stream();
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
