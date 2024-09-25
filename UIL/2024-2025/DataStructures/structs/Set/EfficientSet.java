package structs.Set;

import java.util.HashMap;

public class EfficientSet<T> implements SetInterface<T> {
  static final Object EXISTS = new Object();
  HashMap<T, Object> map = new HashMap<>();

  // Returns true if set was modified
  public boolean add(T o) {
    return map.putIfAbsent(o, EXISTS) != EXISTS;
  }

  // returns true if o is in the set
  public boolean has(T o) {
    return map.containsKey(o);
  }

  public int size() {
    return map.size();
  }

  public boolean remove(Object o) {
    return map.remove(o) == EXISTS;
  }

  public void clear() {
    map.clear();
  }

  public Object[] toArray() {
    return map.keySet().toArray();
  }

  public String toString() {
    return map.keySet().toString();
  }
}
