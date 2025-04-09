import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Luke {
  private static final String INPUT_FILE = "luke.dat";

  // BFS from `this` to `end`
  // Only returns paths that have capacity > 0
  public static Map<Station, Station> bfs(Station start, Station end) {
    Map<Station, Station> parents = new HashMap<>();
    Set<Station> visited = new HashSet<>(Set.of(start)); // avoid cycles
    Queue<Station> queue = new LinkedList<>(Set.of(start));
    while (!queue.isEmpty()) {
      Station station = queue.poll();
      if (station.equals(end)) break; // Found the end station, we're done
      for (Station other : station.getNeighbors()) {
        int remainingCapacity = station.remainingCapacity(other);
        if (!visited.contains(other) && remainingCapacity > 0) {
          queue.add(other); // this is a possible path, since it has remaining capacity
          visited.add(other);
          parents.put(other, station);
        }
      }
    }
    return parents;
  }

  public static int edmondsKarp(Station source, Station sink) {
    int maxFlow = 0;
    Map<Station, Station> parents;
    while ((parents = bfs(source, sink)).containsKey(sink)) {
      int pathFlow = Integer.MAX_VALUE;
      {// Find bottleneck (min capacity of path from source to sink)
        Station curr = sink;
        while (curr != source) {
          Station prev = parents.get(curr);
          pathFlow = Math.min(pathFlow, prev.remainingCapacity(curr));
          curr = prev;
        }
      }

      maxFlow += pathFlow; // add flow to max flow

      {// update capacities
        Station curr = sink;
        while (curr != source) {
          Station prev = parents.get(curr); // This is where the flow *comes from*
          prev.remainingCapacity(curr, prev.remainingCapacity(curr) - pathFlow);
          // Back-edges. I don't know why this is necessary, but it is.
          curr.remainingCapacity(prev, curr.remainingCapacity(prev) + pathFlow);
          curr = prev;
        }
      }
    }
    return maxFlow;
  }

  private static void each(Scanner scan) {
    int numPipes = scan.nextInt();
    int numCases = scan.nextInt();
    scan.nextLine();

    Map<String, Station> stations = new HashMap<>();
    // Create the stations from the pipe names
    for (int i = 0; i < numPipes; i++) {
      Station s = stations.computeIfAbsent(scan.next(), Station::new);
      Station t = stations.computeIfAbsent(scan.next(), Station::new);
      s.remainingCapacity(t, scan.nextInt());
      scan.nextLine();
    }

    // copy original capacities
    // I hate mutable objects, but i don't want to rewrite the whole thing
    Map<Station, Map<Station, Integer>> connectionsCopy =
        stations.values().stream().collect(Collectors.toMap(Function.identity(), s -> new HashMap<>(s.connections)));

    // For each case, get the source and sink
    for (int i = 0; i < numCases; i++) {
      connectionsCopy.forEach((s, m) -> {
        s.connections.clear();
        s.connections.putAll(m);
      }); // reset connections to original capacities

      Station source = stations.get(scan.next());
      Station sink = stations.get(scan.next());
      scan.nextLine();
      if (source.equals(sink)) throw new IllegalArgumentException("Source and sink are the same (flow is unlimited)");

      // If either is null, there's no pipe connecting them, so the flow is 0
      if (source == null || sink == null) {
        System.out.println(0);
      } else {
        int maxFlow = edmondsKarp(source, sink);
        System.out.println(maxFlow);
      }
    }
  }

  interface TriConsumer<T, U, V> {
    void accept(T t, U u, V v);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

class Station {
  final Map<Station, Integer> connections = new HashMap<>(); // These are edges with (remaining) capacity of `value`
  final public String name;

  public Set<Station> getNeighbors() {
    return connections.keySet();
  }

  /**
   * Sets the remaining capacity of the connection between `this` and `other` to
   * `capacity`
   */
  public void remainingCapacity(Station other, int capacity) {
    connections.put(other, capacity);
  }

  /**
   * Returns the remaining capacity of the connection between `this` and `other`
   */
  public int remainingCapacity(Station other) {
    return connections.getOrDefault(other, 0);
  }

  public Station(String name) {
    this.name = name;
  }
}
