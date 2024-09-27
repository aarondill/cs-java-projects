import java.util.Objects;

public class LinkedList<T> {
  private static class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
      this.data = data;
    }

    public String toString() {
      return String.valueOf(data);
    }
  }

  private int size = 0;
  private Node<T> head;

  public int size() {
    return size;
  }

  public void add(T data) {
    size++;
    Node<T> newNode = new Node<T>(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node<T> current = head;
    // Find end of list
    while (current.next != null)
      current = current.next;
    current.next = newNode;
  }

  private Node<T> getNode(int index) {
    Objects.checkIndex(index, size);
    Node<T> current = head;
    for (int i = 0; i < index; i++)
      current = current.next;
    return current;
  }

  public T get(int index) {
    return getNode(index).data;
  }

  public boolean contains(T data) {
    for (int i = 0; i < size; i++) {
      Node<T> current = getNode(i);
      if (current.data == null) {
        if (current.data == data) return true;
        continue;
      }
      if (current.data.equals(data)) return true;
    }
    return false;
  }

  public boolean remove(int index) {
    Objects.checkIndex(index, size);
    size--;
    if (index == 0) {
      head = head.next;
      return true;
    }
    Node<T> current = getNode(index - 1);
    current.next = current.next.next;
    return true;
  }

  // Remove the first occurrence of data
  public boolean remove(T data) {
    if (head.data == data) {
      head = head.next;
      size--;
      return true;
    }
    for (Node<T> current = head; current != null; current = current.next) {
      if (current.next.data != data) continue; // Find the node with the correct data
      current.next = current.next.next;
      size--;
      return true;
    }
    return false;
  }

  public String toString() {
    // Guess that each node will be 5 chars
    StringBuilder sb = new StringBuilder(2 + size * 5).append('[');
    for (Node<T> current = head; current != null; current = current.next) {
      sb.append(current);
      if (current.next != null) sb.append(',').append(' ');
    }
    return sb.append(']').toString();
  }
}
