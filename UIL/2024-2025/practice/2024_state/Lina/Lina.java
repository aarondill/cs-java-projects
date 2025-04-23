import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Lina {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "lina.dat";

  // The constructor is called on each case
  private Lina(Scanner scan) {
    List<String> line = Arrays.asList(scan.nextLine().split(" "));
    Node root = new Node(line.getFirst());
    line.stream().skip(1).map(Node::new).forEach(root::add);

    System.out.println("TEST CASE #" + caseNum + ":");
    System.out.println("DIAMETER OF THE TREE: " + (root.diameter() - 1)); // -1 because "diameter" is the number of connections
    System.out.println("WIDTH OF THE TREE: " + root.width());
    System.out.println("HEIGHT OF THE TREE: " + (root.maxDepth() - 1)); // -1 because "maxDepth" is the number of connections
    System.out.println("NUMBER OF LEAVES IN THE TREE: " + root.leaves());
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Lina(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

class Node {
  Node left;
  Node right;
  String value;

  Node(String value) {
    this.value = value;
  }
  // Returns the depth in which the node is inserted
  public void add(Node node) {
    if (node.value.compareTo(value) <= 0) { // equal goes left
      if (left != null) left.add(node);
      else left = node;
    } else {
      if (right != null) right.add(node);
      else right = node;
    }
  }
  // Count the number of leaves in the tree
  public int leaves() {
    if (left == null && right == null) return 1; // this is a leaf
    int r = right == null ? 0 : right.leaves();
    int l = left == null ? 0 : left.leaves();
    return r + l;
  }
  // Returns the maxmimum depth of the tree
  public int maxDepth() {
    int r = right == null ? 0 : right.maxDepth();
    int l = left == null ? 0 : left.maxDepth();
    return 1 + Math.max(r, l); // Current node and the max of its children
  }
  // Return the number of nodes in the diameter of the tree (max path from farthest leaf to farthest leaf - always passes through the root)
  public int diameter() {
    int r = right == null ? 0 : right.maxDepth();
    int l = left == null ? 0 : left.maxDepth();
    // left depth + right depth + 1 (the root)
    return r + l + 1;
  }
  // Returns number of node in the width of the tree
  public int width() {
    return IntStream.range(0, maxDepth()).map(this::width).max().orElse(1);
  }
  // Returns width of the tree at the given depth (count the nodes at that depth)
  private int width(int depth) {
    if (depth == 0) return 1; // we've reached the desired depth, this node counts
    int r = right == null ? 0 : right.width(depth - 1);
    int l = left == null ? 0 : left.width(depth - 1);
    return r + l; // reach down until we find all the nodes at the desired depth
  }
}
