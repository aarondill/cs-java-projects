/* A demo on various data structures */

import structs.DynamicArray;
import structs.Set.*;

public class DataStructures {
  public static void main(String... args) {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    da.add("World");
    System.out.println(da);

    SetInterface<String> s = new Set<>();
    s.add("Hello");
    s.add("World");
    s.add("Hello");
    System.out.println(s);

    SetInterface<String> es = new EfficientSet<>();
    es.add("Hello");
    es.add("World");
    es.add("Hello");
    System.out.println(es);
  }
}
