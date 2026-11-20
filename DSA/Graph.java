import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/** A *undirected* graph containing airports and flights between them */
public class Graph {
  public record Edge(String to, long prince, long duration) {}

  // This would be better represented as a Node which contains a List<Edge> :(
  private Map<String, List<Edge>> adjecencyList = new HashMap<>();

  /***
   * Connects city a and city b.
   * If either city doesn't yet exist, creates it.
   */
  public void connect(String a, String b, long price, long duration) {
    var aList = adjecencyList.computeIfAbsent(a, _ -> new ArrayList<>());
    var bList = adjecencyList.computeIfAbsent(b, _ -> new ArrayList<>());

    // Check that none of the edges in A's list have b already
    if (aList.stream().anyMatch(e -> e.to == b))
      throw new IllegalArgumentException("%s and %s are already connected!".formatted(a, b));
    assert !bList.stream().anyMatch(e -> e.to == a); // if not in a, shouldn't be in b

    // connect a->b and b->a
    aList.add(new Edge(b, price, duration));
    bList.add(new Edge(a, price, duration));
  }
  public Set<String> getNodes() {
    return adjecencyList.keySet();
  }
  /**
   * Returns list of edges adjecent to a
   * Throws if a is not in the graph
   */
  public List<Edge> getAdjecent(String a) {
    return Objects.requireNonNull(adjecencyList.get(a), () -> a + " is not in the graph");
  }
}
