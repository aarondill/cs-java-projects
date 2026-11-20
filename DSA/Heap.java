import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T extends Comparable<T>> {
  private ArrayList<T> data;

  public Heap(List<T> list) {
    // TODO: heapify
    throw new UnsupportedOperationException("not yet implemented");
  }
  public T removeMin() {
    throw new UnsupportedOperationException("not yet implemented");
  }
  // other methods eventually go here
  public static <T> List<T> heapsort(List<T> list) {
    // TODO: make heap, then successively remove
    return list;
  }
}
