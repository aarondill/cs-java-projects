package Set;

public interface SetInterface<T> {

  public boolean add(T o); // returns true if set is modified

  public boolean has(T o); // returns true if o is in the set

  public int size();

  public boolean remove(Object o); // returns true if set is modified

  public void clear();

  public Object[] toArray();
}
