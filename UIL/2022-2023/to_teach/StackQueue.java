import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class StackQueue {
    public static void show(Object... args) {
        for (Object arg : args)
            System.out.println(arg);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        System.out.println("add(1)");
        q.add(1);
        s.add(1);
        show(q, s);

        System.out.println("add(2)");
        q.add(2);
        s.add(2);
        show(q, s);

        System.out.println("add(3)");
        q.add(3);
        s.add(3);
        show(q, s);

        System.out.println("size()");
        show(q.size(), s.size());

        System.out.println("remove() / pop()");
        q.remove();
        s.pop();
        show(q, s);

        System.out.println("remove() / pop()");
        q.remove();
        s.pop();
        show(q, s);

    }
}
