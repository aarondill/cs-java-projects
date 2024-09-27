import java.util.LinkedList;

public class Stack<T> {
  // This gives us O(1) insertion
  LinkedList<T> data = new LinkedList<>();

  // Add to the top
  public boolean push(T o) {
    data.addFirst(o);
    return true;
  }

  public T pop() {
    return data.removeFirst();
  }

  public int size() {
    return data.size();
  }

  public String toString() {
    return data.toString();
  }
}
