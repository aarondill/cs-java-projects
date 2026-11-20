import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  enum SortType {
    Price, Duration
  }
  record Request(String from, String to, SortType sortBy) {}
  record Path(Request source, List<String> cities, long price, long duration) implements Comparable<Path> {
    Path {
      if (cities.isEmpty()) throw new IllegalArgumentException();
    }
    /** Returns a new path containing this path + the city in e */
    public Path with(Graph.Edge e) {
      var newList = new ArrayList<>(cities);
      newList.add(e.to());
      return new Path(source, newList, price + e.prince(), duration + e.duration());
    }
    @Override
    public String toString() {
      // Dallas -> Houston. Time: 51 Cost: 101.00
      var path = String.join(" -> ", cities.toArray(new String[0]));
      return "%s. Time: %d. Cost: %d.00.".formatted(path, duration, price);
    }
    public int compareTo(Path o) {
      return switch (source.sortBy) {
        case Price -> Long.compare(price, o.price);
        case Duration -> Long.compare(duration, o.duration);
      };
    }
  }

  /** The (max) number of paths to output */
  public static final int NUMBER_OUTPUT = 3;

  public static void main(String[] args) {
    // Construct graph from input
    Graph g;
    try (var in = new Scanner(new File("./flights.dat"))) {
      g = parseFlights(Long.parseLong(in.nextLine()), in);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(2);
      return;
    }

    // parse the request input
    List<Request> requests;
    try (var in = new Scanner(new File("./requests.dat"))) {
      requests = parseRequests(Long.parseLong(in.nextLine()), in);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(2);
      return;
    }

    // process each request
    int flight_num = 1;
    for (var it = requests.iterator(); it.hasNext();) {
      Request r = it.next();
      // Flight 1: Dallas, Houston (Time)
      System.out.printf("Flight %d: %s, %s (%s)\n", flight_num++, r.from, r.to, switch (r.sortBy) {
        case Price -> "Cost";
        case Duration -> "Time";
      });

      // DO BFS
      var paths = bfs(g, r);
      // Sort all paths
      paths = Heap.heapsort(paths);

      // Output the paths
      // Path 1: Dallas -> Houston. Time: 51 Cost: 101.00
      for (int i = 0; i < Math.min(NUMBER_OUTPUT, paths.size()); i++)
        System.out.printf("Path %d: %s\n", i + 1, paths.get(i));

      if (it.hasNext()) System.out.println(); // seperator line
    }
  }

  static Graph parseFlights(long n, Scanner in) {
    Graph g = new Graph();
    while (n-- > 0) {
      String line = in.nextLine();
      String[] parts = line.split("\\|");
      String a = parts[0], b = parts[1];
      int price = Integer.parseInt(parts[2]), duration = Integer.parseInt(parts[3]);
      g.connect(a, b, price, duration);
    }
    return g;
  }
  static List<Request> parseRequests(long n, Scanner in) {
    List<Request> ret = new ArrayList<>();
    while (n-- > 0) {
      String line = in.nextLine();
      String[] parts = line.split("\\|");
      String from = parts[0], to = parts[1];
      ret.add(new Request(from, to, switch (parts[2]) {
        case "T" -> SortType.Duration;
        case "C" -> SortType.Price;
        default -> throw new IllegalArgumentException("Invalid sort type: " + parts[2]);
      }));
    }
    return ret;
  }

  static List<Path> bfs(Graph g, Request r) {
    List<Path> ret = new ArrayList<>();

    String start = r.from(), end = r.to();
    Queue<Path> queue = new LinkedList<>();
    queue.offer(new Path(r, List.of(start), 0, 0));
    while (!queue.isEmpty()) {
      Path currentPath = queue.poll();
      var visited = currentPath.cities();
      String c = visited.getLast();
      if (c.equals(end)) {
        ret.add(currentPath);
        continue; // we've reached the end city :)
      }

      for (var edge : g.getAdjecent(c)) {
        // NOTE: visited can't be function-local because we need to see *all* possible paths, not just the shortest!
        if (visited.contains(edge.to())) continue;
        queue.offer(currentPath.with(edge));
      }
    }

    return ret;
  }
}
