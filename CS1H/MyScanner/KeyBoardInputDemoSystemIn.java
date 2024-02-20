package MyScanner;

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

    public static void main(String[] args) {
        System.out.println("Enter your name...");
        MyScanner myScanner = new MyScanner();
        String name = myScanner.nextLine();
        System.out.println("Hello, my name is " + name);
    }
}
