import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: FirstAndLast
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/13/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will prompt the user for a list of
 * decimal numbers. The program should stop prompting for and entering numbers
 * when the user enters 0. After the user has entered all of their numbers, the
 * program should print how many numbers were entered (not counting the 0), the
 * first number and the last number. The numbers entered may be different,
 * however, format and label the output just as you see in this sample run:
 *
 * 
 */
public class FirstAndLast {
  public static void main(String... args) {
    List<Double> numbers = new ArrayList<>(5); // we really don't need a list here...
    try (Scanner input = new Scanner(System.in)) {
      do {
        System.out.print("Enter a decimal number (0 to quit): ");
        if (!input.hasNextDouble()) break;
        numbers.add(input.nextDouble());
      } while (numbers.getLast() != 0.0);
      if (!numbers.isEmpty() && numbers.getLast() == 0.0) numbers.removeLast(); // remove the 0
    }
    System.out.println("There are " + numbers.size() + " numbers in your list.");
    System.out.println("First number is: " + (numbers.isEmpty() ? null : numbers.getFirst()));
    System.out.println("Last number is: " + (numbers.isEmpty() ? null : numbers.getLast()));
  }
}
