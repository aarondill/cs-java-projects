import java.util.Arrays;
import java.util.PriorityQueue;

class PriorityQueueOrdering {
    private static void clearTTY() {
        if (System.console() != null) {
            char ESC = 27;
            System.console().printf(ESC + "c");
        }
    }

    private static void test(Integer[] x) {
        PriorityQueue<Integer> pq;
        pq = new PriorityQueue<Integer>();
        System.out.printf("%-30s: %s\n", "Input Array", Arrays.toString(x));
        for (Integer i : x)
            pq.add(i);
        System.out.printf("%-30s: %s\n\n", "Output PriorityQueue Ordering", pq);
    }

    private static void howToOrder() {
        System.out.println("How To Order:");
        System.out.println("Add the object to the leftmost free space in the tree.");
        System.out.println("Compare with it's parent. If it fails the comparison, swap it and it's parent.");
        System.out.println("Continue until it passes the comparison with its parent.");
    }

    public static void main(String[] args) {
        clearTTY();
        test(new Integer[] { 17, 38, 2, 22, 30, 10, 10 });
        test(new Integer[] { 17, 38, 2, 9, 30, 10, 8 });
        System.out.println("Order Matters:");
        test(new Integer[] { 2, 8, 9, 10, 17, 30, 38 });
        howToOrder();
    }
}
