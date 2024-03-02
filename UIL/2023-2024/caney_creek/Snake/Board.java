import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board<T> {
  // row { col, col, col }, row { col, col, col }, row { col, col, col }
  private final List<List<T>> list;

  public Board() {
    list = new ArrayList<>();
  }

  public Board(int x) {
    list = new ArrayList<>(x);
  }

  public Board(int x, int y) {
    this(x);
    for (int i = 0; i < x; i++)
      list.add(new ArrayList<>(y));
  }

  /** Constructs an IndexOutOfBoundsException detail message. */
  private String outOfBoundsMsg(int x, int y) {
    return "Index: " + x + ", " + y + " Size: " + list.get(x).size();
  }

  /** Constructs an IndexOutOfBoundsException detail message. */
  private String outOfBoundsMsg(int x) {
    return "Index: " + x + ", Size: " + list.size();
  }

  /** A version of rangeCheck used by add and addAll. */
  private void rangeCheckForAdd(int index) {
    if (index > list.size() || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  }

  private void rangeCheckForAdd(int x, int y) {
    if (x > list.size() || x < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(x));
    if (y > list.get(x).size() || y < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(x, y));
  }

  public void add(int x, int y, T v) {
    rangeCheckForAdd(x, y);
    List<T> row = (list.size() == x) ? new ArrayList<>() : list.get(x);
    list.set(x, row);
    row.add(y, v);
  }

  public void add(int x, T v) {
    rangeCheckForAdd(x);
    List<T> row = (list.size() == x) ? new ArrayList<>() : list.get(x);
    list.set(x, row);
    row.add(v);
  }

  public List<T> set(int x, List<T> row) {
    return list.set(x, row);
  }

  public T set(int x, int y, T e) {
    return list.get(x).set(y, e);
  }

  public T get(int x, int y) {
    return list.get(x).get(y);
  }

  public boolean validIndex(int x, int y) {
    if (x < 0 || x >= list.size()) return false;
    if (y < 0 || y >= list.get(x).size()) return false;
    return true;
  }

  public int size(int x) {
    return list.get(x).size();
  }

  public int size() {
    return list.size();
  }

  public List<T> get(int x) {
    return list.get(x);
  }

  @Override
  public Board<T> clone() {
    Board<T> res = new Board<>(list.size());
    for (List<T> row : list)
      res.list.add(new ArrayList<>(row));
    return res;
  }

  @Override
  public String toString() {
    String[][] strs = new String[size()][];
    for (int i = 0; i < size(); i++)
      strs[i] = new String[size(i)];

    for (int x = 0; x < size(); x++) {
      for (int y = 0; y < size(x); y++) {
        strs[y][x] = get(x, y).toString();
      }
    }
    int[] maxLengths =
        Arrays.stream(strs).mapToInt(s -> Arrays.stream(s).mapToInt(String::length).max().orElse(0)).toArray();

    // Attempt to find the final length of string. (sum of column lengths + 1 for each column) * (row length)
    int exp = (Arrays.stream(maxLengths).sum() + maxLengths.length)
        * Arrays.stream(strs).mapToInt(row -> row.length).max().orElse(0);
    StringBuilder result = new StringBuilder(exp);
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs[i].length; j++) {
        String s = strs[i][j];
        int spacing = maxLengths[i] - s.length();
        result.append(s).append(" ".repeat(spacing));
        if (j != strs[i].length - 1) result.append(" ");
      }
      if (i != strs.length - 1) result.append(System.lineSeparator());
    }
    return result.toString();
  }

}
