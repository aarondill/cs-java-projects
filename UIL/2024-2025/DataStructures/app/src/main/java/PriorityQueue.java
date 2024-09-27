import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
  // NOTE: Allows O(1) insertions/removal; Real implementations use a binary heap.
  List<T> data = new LinkedList<>();

  public void add(T o) {
    int i = Collections.binarySearch(data, o);
    int insertionPoint = i >= 0 ? i : ~i;
    data.add(insertionPoint, o);
  }

  public T peek() {
    return data.getFirst();
  }

  public T remove() {
    return data.removeFirst();
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
