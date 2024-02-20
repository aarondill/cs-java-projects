import java.util.Collections;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> bp;
        bp = new LinkedList<>(); // extends AbstractSequentialList<E>; implements List<E>, Deque<E>

        bp.add("A"); // Can throw; addLast();
        bp.push("F"); // addFirst()
        bp.offer("C"); // returns false on fail; addLast();
        System.out.println(bp.element()); // 1 // peek(); throws if empty
        System.out.println(bp.peek()); // doesn't throw, else returns null

        bp.set(2, "B"); // throws if index is out of range
        bp.addLast("G");
        bp.remove("D"); // returns true if was contained; removes first instance
        bp.remove(); // removes first item of list
        Collections.sort(bp); // sorts inline by e1.compareTo(e2);

        System.out.println(bp.indexOf(("C"))); // 2
    }

}
