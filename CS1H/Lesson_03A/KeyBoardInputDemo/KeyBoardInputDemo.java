package KeyBoardInputDemo;

import java.util.Scanner;

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
 * demo the keyboard input in java
 *
 * Step 1: Import java.util.Scanner
 * Step 2: create Scanner object for keyboard input
 * Step 3: prompt the user and tell them what to do
 * Step 4: use input method statement to capture the user's input
 * Step 5: use the data
 *
 */

public class KeyBoardInputDemo {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter your name...");
        String name = kb.nextLine();
        System.out.println("Hello, my name is " + name);
        kb.close();
    }
}
