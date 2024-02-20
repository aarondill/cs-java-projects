package KeyBoardInputDemo;

import java.io.IOException;

/**
 * Class KeyBoardInputDemo
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 21, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * demo the keyboard input in java using
 *
 */

public class KeyBoardInputDemoSystemIn {
    public static String nextLine() {
        return next(new char[] { '\n' });
    }

    public static String next() {
        return next(new char[] { ' ', '\t', '\n' });
    }
    
    public static String next(char end) {
        return next(new char[] { end });
    }

    public static String next(char[] end) {
        String line = "";
        int scan;
        read: while (true) {
            try {
                scan = System.in.read();
            } catch (IOException e) {
                scan = -1;
            }
            if (scan == -1)
                break;
            for (char c : end) {
                if (scan == (int) c)
                    break read;
            }

            line += (char) scan;
        }
        return line;
    }

    public static void main(String[] args) {
        System.out.println("Enter your name...");
        String name = nextLine();
        System.out.println("Hello, my name is " + name);
    }
}
