import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("(%d, %d)", x, y);
  }
}

class Node {
  Point pos;
  List<Node> neighbors = new ArrayList<>();
  int price = 0;

  Node(Point pos, int price) {
    this.pos = pos;
    this.price = price;
  }

  public String toString() {
    return String.format("Node(pos=%s, price=%d, numNeighbors=%d)", pos, price, neighbors.size());
  }
}

class Result {
  Map<Node, Integer> distances;
  Map<Node, Node> bestRoute;

  Result(Map<Node, Integer> distances, Map<Node, Node> bestRoute) {
    this.distances = distances;
    this.bestRoute = bestRoute;
  }
}

public class Solution {
  @SuppressWarnings("unused")
  private static int caseNum = 1;

  private static Result astar(Node start, Node end) {
    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> bestRoute = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(
        Comparator.comparingInt(n -> distances.get(n) + (int) Math.hypot(n.pos.x - end.pos.x, n.pos.y - end.pos.y)));
    distances.put(start, 0);
    queue.add(start);
    // use the pythag distance as the heuristic
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      // System.out.println("visiting " + current + " queue size: " + queue.size());
      if (current.equals(end)) break;
      for (Node n : current.neighbors) {
        int newDist = distances.get(current) + n.price;
        if (newDist < distances.getOrDefault(n, Integer.MAX_VALUE)) {
          // System.out.println(n + " is " + newDist + " away (old dist: " + distances.get(n) + ")");
          distances.put(n, newDist);
          bestRoute.put(n, current);
          queue.add(n);
        }
      }
    }
    return new Result(distances, bestRoute);
  }

  private static void each(Scanner scan) {
    int m = Integer.parseInt(scan.nextLine(), 10);
    List<List<Node>> graph = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        Point p = new Point(i, j);
        int price = scan.nextInt();
        Node n = new Node(p, price);
        if (graph.size() <= i) graph.add(new ArrayList<>());
        graph.get(i).add(n);
      }
      if (scan.hasNextLine()) scan.nextLine();
    }
    boolean isNative = false;
    boolean shouldFlipOnRow = m % 2 == 0; // Should only flip if there is an even number of columns
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        Node n = graph.get(i).get(j);
        if (i + 1 < graph.size()) n.neighbors.add(graph.get(i + 1).get(j)); // East
        if (j + 1 < graph.get(i).size()) n.neighbors.add(graph.get(i).get(j + 1)); // South
        // Natives only allow down and right
        if (!isNative) {
          if (i - 1 >= 0) n.neighbors.add(graph.get(i - 1).get(j)); // West
          if (j - 1 >= 0) n.neighbors.add(graph.get(i).get(j - 1)); // North
        }

        isNative = !isNative;
      }
      if (shouldFlipOnRow) isNative = !isNative;
    }

    // cheat by increasing all prices so the least is 1
    int minPrice = Integer.MAX_VALUE;
    for (List<Node> row : graph) {
      for (Node n : row)
        minPrice = Math.min(minPrice, n.price);
    }
    int adjust = minPrice > 0 ? 0 : -minPrice + 1;
    for (List<Node> row : graph) {
      for (Node n : row)
        n.price += adjust;
    }

    // (0, 0) to (m - 1, m - 1)
    Node start = graph.get(0).get(0);
    Node end = graph.get(m - 1).get(m - 1);
    var result = astar(start, end);

    int cost = 0;
    // NOTE: we aren't paid for the start node
    for (Node c = end; c != null && c != start; c = result.bestRoute.get(c))
      cost += c.price - adjust;
    System.out.println(cost);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    }
  }
}
