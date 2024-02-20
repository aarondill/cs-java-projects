/**
 * Class Lab2A3
 *
 *
 * Author1: Aaron Dill
 * Author2: None
 * Date: January 20, 2023
 * Course: Computer Science I Honors
 *
 *
 * Summary of file:
 * Experiment with Max and Min_VALUEs in Java
 *
 *
 */
class Lab2A3 {
    public static void main(String[] args) {

        byte b = Byte.MIN_VALUE;
        b--;
        System.out.printf("%+28d\n", b);

        b = Byte.MAX_VALUE;
        // Increase by 2 instead of just the one.
        // Should = Byte.MIN_VALUE + 1
        b += 2;
        System.out.printf("%+28d\n", b);

        short s = Short.MIN_VALUE;
        // Decrease by 5 instead of just the one.
        // Should = SHORT.MAX_VALUE - 4
        s--;
        System.out.printf("%+,28d\n", s);

        s = Short.MAX_VALUE;
        s++;
        System.out.printf("%+,28d\n", s);

        int i = Integer.MIN_VALUE;
        // i = MIN_VALUE+MIN_VALUE = 0
        i = i + i;
        System.out.printf("%+,28d\n", i);

        i = Integer.MAX_VALUE;
        i++;
        System.out.printf("%+,28d\n", i);

        long l = Long.MIN_VALUE;
        l--;
        System.out.printf("%,+28d \n", l);

        l = Long.MAX_VALUE;
        l++;
        System.out.printf("%,+28d\n", l);

    }
}
