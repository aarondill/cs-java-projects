/* A demo on various data structures */

import structs.DynamicArray;

public class DataStructures {
  public static void main(String... args) {
    DynamicArray<String> da = new DynamicArray<String>();
    da.add("Hello");
    da.add("World");
    System.out.println(da);
  }
}
