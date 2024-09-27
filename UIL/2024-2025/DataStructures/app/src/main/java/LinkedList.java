import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinkedList<T> implements Iterable<T> {
  private class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
      this.data = data;
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
    int i = 0;
    while (i++ < index)
      current = current.next;
    return current;
  }

  public T get(int index) {
    return getNode(index).data;
  }

  public boolean contains(T data) {
    for (int i = 0; i < size; i++) {
      if (get(i).equals(data)) return true;
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
    Node<T> current = head;
    int i = 0;
    while (i++ < index - 1)
      current = current.next;
    current.next = current.next.next;
    return true;
  }

  public boolean remove(T data) {
    if (head.data == data) {
      head = head.next;
      size--;
      return true;
    }
    Node<T> current = head;
    while (current.next != null) {
      if (current.next.data == data) {
        current.next = current.next.next;
        size--;
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public Stream<T> stream() {
    Iterator<T> iterator = iterator();
    return Stream.generate(iterator::next).limit(size);
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

  public Object[] toArray() {
    Object[] a = new Object[size];
    int i = 0;
    for (Node<T> current = head; current != null; current = current.next)
      a[i++] = current.data;
    return a;
  }

  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if (a.length < size) {
      a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
    }
    int i = 0;
    for (Node<T> current = head; current != null; current = current.next)
      a[i++] = current.data;
    if (a.length > size) a[size] = null;
    return a;
  }

  public String toString() {
    Node<T> current = head;
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (current != null) {
      sb.append(current.data);
      current = current.next;
      if (current != null) {
        // Only append comma if not last element
        sb.append(',').append(' ');
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
