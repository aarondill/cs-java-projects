import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A (bad) max-heap implementation for use in heapsort.
 * You can create a heap with values using the constructor, then remove values one-at-a-time.
 * Please use PriorityQueue instead for any real use-cases!
 */
public class Heap<T extends Comparable<T>> {
  private List<T> data;

  public Heap(List<T> list) {
    data = new ArrayList<>(list);
    // Make-heap
    for (int i = (data.size() / 2) - 1; i >= 0; i--)
      siftDown(i);
  }
  public T removeMin() {
    if (data.isEmpty()) throw new IllegalStateException("empty");
    T min = data.getFirst();
    T last = data.removeLast();
    if (!data.isEmpty()) {
      data.set(0, last);
      siftDown(0);
    }
    return min;
  }

  private void siftDown(int i) {
    int size = data.size();
    while (true) {
      int max = i, left = 2 * i + 1, right = 2 * i + 2;
      if (left < size && data.get(left).compareTo(data.get(max)) >= 0) max = left;
      if (right < size && data.get(right).compareTo(data.get(max)) >= 0) max = right;

      if (max == i) break;

      Collections.swap(data, i, max);
      i = max;
    }
  }
}
