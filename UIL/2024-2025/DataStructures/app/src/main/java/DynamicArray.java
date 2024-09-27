import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DynamicArray<T> {
  private final int DEFAULT_CAPACITY = 10;
  private Object[] data = new Object[DEFAULT_CAPACITY];
  private int size = 0;

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    Objects.checkIndex(index, this.size);
    return (T) this.data[index];
  }

  public void ensureCapacity(int capacity) {
    if (capacity <= this.data.length) return; // already enough space
    int newSize = this.data.length * 2; // double the size
    if (newSize < capacity) newSize = capacity; // if it's still too small, use the new size

    Object[] newData = new Object[newSize];
    System.arraycopy(this.data, 0, newData, 0, this.data.length); // copy the old data (this is O(n))
    this.data = newData;
  }

  public void add(T o) {
    ensureCapacity(this.size + 1);
    this.data[this.size] = o;
    this.size++;
  }

  public void remove(int index) {
    Objects.checkIndex(index, this.size);
    System.arraycopy(this.data, index + 1, this.data, index, this.size - index - 1);
    this.size--;
  }

  public Stream<T> stream() {
    return IntStream.range(0, this.size).mapToObj(this::get);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder().append('[');
    Arrays.stream(this.data).limit(this.size - 1).forEach(o -> sb.append(o).append(',').append(' '));
    sb.append(this.data[this.size - 1]);
    return sb.append(']').toString();
  }

}
