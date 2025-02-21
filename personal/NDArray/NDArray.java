import java.util.Arrays;
import java.util.Objects;

public class NDArray<T> {
  private final Object[] data;
  private final int dims;

  public int dims() {
    return dims;
  }

  NDArray(int... sizes) {
    this.dims = sizes.length;
    this.data = initialize(sizes, 0);
  }

  private Object[] initialize(int[] sizes, int sizeInd) {
    if (sizeInd == sizes.length - 1) return new Object[sizes[sizeInd]]; // We're at the last one, leave initialized to null
    Object[] data = new Object[sizes[sizeInd]];
    for (int i = 0; i < data.length; i++) {
      data[i] = initialize(sizes, sizeInd + 1);
    }
    return data;
  }

  // Returns the array at [n1][n2][n3][...][n]
  @SuppressWarnings("unchecked")
  private T[] inner(int len, int[] n) {
    if (n.length > dims()) throw new IllegalArgumentException("Too many indicies passed!");
    Object[] d = data;
    for (int ni = 0; ni < len; ni++) {
      int i = n[ni];
      if (d[Objects.checkIndex(i, d.length)] instanceof Object[] a) d = a;
      else throw new IllegalStateException("Not an array! This is a bug!");
    }
    return (T[]) d;
  }

  public int size(int... path) {
    T[] data = inner(path.length, path);
    return data.length;
  }

  public T set(T val, int... path) {
    if (path.length == 0) throw new IllegalArgumentException("zero length path passed");
    int end = path[path.length - 1];
    T[] data = inner(path.length - 1, path);
    T old = data[end];
    data[end] = val;
    return old;
  }

  public T get(int... path) {
    if (path.length == 0) throw new IllegalArgumentException("zero length path passed");
    int end = path[path.length - 1];
    T[] data = inner(path.length - 1, path);
    return data[end];
  }

  @Override
  public String toString() {
    return Arrays.deepToString(data);
  }
}
