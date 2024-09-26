/* A demo on various data structures */

import structs.DynamicArray;
import structs.PriorityQueue;
import structs.Stack;
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

    Stack<Integer> st = new Stack<>();
    System.out.println("Add 1");
    st.push(1);
    System.out.println("Add 2");
    st.push(2);
    System.out.printf("Remove: %d\n", st.pop()); // Prints 2

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    System.out.println("Add 2,1,3");
    st.push(2);
    st.push(1);
    st.push(3);
    System.out.printf("Remove: %d\n", st.pop()); // Prints 2
  }
}
