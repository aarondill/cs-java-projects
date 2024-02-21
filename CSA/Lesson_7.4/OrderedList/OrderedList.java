import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: OrderedList
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/21/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will read all of the numbers in a file
 * named file1.dat (you may use the same file you used in problem 7.4.2) and
 * place them into an ArrayList in ascending order then print the list. You must
 * insert each number in the list as it is read from the file. Do not sort the
 * list after reading the values.
 *
 * 
 * 
 */
public class OrderedList {
  // Returns null if a FileNotFoundException is thrown.
  public static void main(String... args) {
    List<Integer> numbers = new ArrayList<>(); // I can't use getListFromFile because I have do sort *while* inserting :(
    try (Scanner scan = new Scanner(new File(("./file1.dat")))) {
      scan.tokens().map(Integer::parseInt).forEach(n -> {
        int i = 0;
        while (i < numbers.size() && numbers.get(i) < n)
          i++;
        numbers.add(i, n);
      });
    } catch (FileNotFoundException e) {
      System.err.println("Yo! Your file doesn't exist! What do you think you're doing here?");
      System.err.println("Try again when you have the right file.");
      System.err.println(e);
      return;
    }
    System.out.println(numbers);
  }
}
