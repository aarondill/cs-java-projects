package structs;

import java.util.Objects;

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

  public final void add(T o) {
    ensureCapacity(this.size + 1);
    this.data[this.size] = o;
    this.size++;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < this.size; i++) {
      sb.append(this.data[i]);
      if (i != this.size - 1) sb.append(", ");
    }
    sb.append("]");
    return sb.toString();
  }

}
