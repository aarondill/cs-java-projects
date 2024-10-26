import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

// A node with a value and neighbors.
class Node<T> {
  // The value of the node. This is immutable after construction.
  private T value;
  // A map of neighbors and their weights. This may only be added to.
  private Map<Node<T>, Integer> neighbors = new HashMap<>();

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  // Adds a neighbor to the node and returns this node (for chaining).
  public Node<T> addNeighbor(Node<T> neighbor, int weight) {
    neighbors.put(neighbor, weight);
    return this;
  }

  // Returns an immutable map of neighbors and their weights.
  public Map<Node<T>, Integer> getNeighbors() {
    return Collections.unmodifiableMap(neighbors);
  }

  @Override
  public String toString() {
    return "Node[" + value + "]";
  }
}

public class Dijkstra {
  // A simple class to hold the result of the Dijkstra algorithm.
  public final static record Result<T>(Map<Node<T>, Integer> distances, Map<Node<T>, Node<T>> prev) {}

  // Returns two maps: the first maps each node to its distance from the start node, and the second maps each node to its previous node in the shortest path.
  public static <T> Result<T> dijkstra(Set<Node<T>> graph, Node<T> start) {
    Map<Node<T>, Integer> distances = new HashMap<>(graph.size());
    Map<Node<T>, Node<T>> prev = new HashMap<>(graph.size());
    // Nodes are sorted by their distance from the start node.
    PriorityQueue<Node<T>> pq = new PriorityQueue<>((n1, n2) -> distances.get(n1).compareTo(distances.get(n2)));

    // Default all distances to "infinity" and no previous node.
    for (Node<T> node : graph) {
      distances.put(node, Integer.MAX_VALUE);
      prev.put(node, null);
    }
    // Set the start node's distance to 0 and add it to the priority queue.
    distances.put(start, 0);
    pq.add(start);

    // While we have nodes to visit, do so
    while (!pq.isEmpty()) {
      Node<T> current = pq.remove();
      // Iterate all the neighbors of the current node
      for (Map.Entry<Node<T>, Integer> neighbor : current.getNeighbors().entrySet()) {
        Node<T> node = neighbor.getKey();
        int weight = neighbor.getValue();

        // The new distance from the start node to the current node is the distance to the start node plus the weight of the edge.
        int newDistance = distances.get(current) + weight;
        // If this distance is less than the current distance, update the distance and previous node. This means we've found a shorter path than before.
        if (newDistance < distances.get(node)) {
          distances.put(node, newDistance);
          prev.put(node, current);
          // Add this node to our work queue, so we can find its neighbors.
          pq.add(node);
        }
      }
    }
    // once the queue is empty, we've found the shortest path from the start node to all nodes.
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
    a.addNeighbor(b, 10).addNeighbor(c, 15);
    b.addNeighbor(d, 12).addNeighbor(f, 15);
    d.addNeighbor(f, 1).addNeighbor(e, 2);
    f.addNeighbor(e, 1);
    c.addNeighbor(e, 10);

    // Create graph
    var graph = Set.of(a, b, c, d, e, f);
    var start = a;
    var result = Dijkstra.dijkstra(graph, start);

    var end = e;
    // Retreive shortest path from end to start
    List<Node<String>> path = new ArrayList<>();
    for (var curr = end; curr != null; curr = result.prev().get(curr))
      path.add(curr);

    // Print the result
    System.out.println("Shortest distance from A to E:");
    System.out.println(path.reversed().stream().map(Node::toString).collect(Collectors.joining(" ")));
    System.out.println("Total cost: " + result.distances().get(e));
  }
}
