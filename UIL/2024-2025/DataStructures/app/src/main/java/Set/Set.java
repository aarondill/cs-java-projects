package Set;

import java.util.ArrayList;

/**
 * This is an easier to understand Set, sacrificing performance to use ArrayList
 */
public class Set<T> implements SetInterface<T> {
  ArrayList<T> data = new ArrayList<>();

  /* NOTE: This is O(n) instead of O(1) */
  public boolean add(T o) {
    if (has(o)) return false;
    return data.add(o);
  }

  /* NOTE: This is O(n) instead of O(1) */
  public boolean has(T o) {
    return data.contains(o);
  }

  public int size() {
    return data.size();
  }

  public boolean remove(Object o) {
    // we don't need removeAll, since we check before inserting that only one can be contained
    return data.remove(o);
  }

  public void clear() {
    data.clear();
  }

  public Object[] toArray() {
    return data.toArray();
  }

  public String toString() {
    return data.toString();
  }

}
