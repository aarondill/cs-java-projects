class Node<T> {
  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data) {
    this.data = data;
    left = null;
    right = null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('(').append(data).append(')');
    if (left == null && right == null) return sb.toString();

    sb.append('{');
    if (left != null) sb.append(left.toString());
    if (right != null) sb.append(',').append(right.toString());
    sb.append('}');
    return sb.toString();
  }

}

/**
 * A simple binary tree implementation.
 */
public class BinTree<T extends Comparable<T>> {
  public Node<T> root;

  public BinTree() {
    root = null;
  }

  public void insert(T data) {
    root = insert(root, data);
  }

  private Node<T> insert(Node<T> node, T data) {
    if (node == null) return new Node<>(data);
    if (data.compareTo(node.data) < 0) {
      node.left = insert(node.left, data);
    } else {
      node.right = insert(node.right, data);
    }
    return node;
  }

  public void clear() {
    root = null;
  }

  public void remove(T data) {
    root = remove(root, data);
  }

  private Node<T> remove(Node<T> node, T data) {
    if (node == null) return null;
    if (data.compareTo(node.data) < 0) {
      node.left = remove(node.left, data);
    } else if (data.compareTo(node.data) > 0) {
      node.right = remove(node.right, data);
    } else {
      if (node.left == null) return node.right;
      else if (node.right == null) return node.left;

      Node<T> temp = node.right;
      while (temp.left != null)
        temp = temp.left;
      node.data = temp.data;
      temp.data = node.data;
      node.right = remove(node.right, temp.data);
    }
    return node;
  }

  public boolean contains(T data) {
    return contains(root, data);
  }

  public boolean contains(Node<T> node, T data) {
    if (node == null) return false;
    if (data.compareTo(node.data) < 0) return contains(node.left, data);
    else if (data.compareTo(node.data) > 0) return contains(node.right, data);
    return true;
  }

  public String toString() {
    return root == null ? "" : root.toString();
  }

}
