import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: Duplicates
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/21/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will read all the values saved in each
 * of two files and store those values in two different ArrayLists. The files
 * are named file1.dat and file2.dat and each file contains a random list of
 * exactly 20 integers. Your program should include a method that accepts two
 * lists and returns a new list that contains only the duplicate values in the
 * lists passed as parameters. The programs output should include the original
 * lists and the list of duplicates.
 */
public class Duplicates {
  // Returns null if a FileNotFoundException is thrown.
  private static List<Integer> getListFromFile(String path) {
    List<Integer> list = new ArrayList<>();
    try (Scanner scan = new Scanner(new File(path))) {
      while (scan.hasNextInt())
        list.add(scan.nextInt());
    } catch (FileNotFoundException e) {
      return null;
    }
    return list;
  }

  public static void main(String... args) throws IOException {
    List<Integer> list1 = getListFromFile("file1.dat");
    List<Integer> list2 = getListFromFile("file2.dat");
    System.out.println("List 1: " + list1);
    System.out.println("List 2: " + list2);
    System.out.println("Duplicates: " + duplicates(list1, list2));
  }

  public static List<Integer> duplicates(List<Integer> list1, List<Integer> list2) {
    // List<Integer> intersect = new ArrayList<>(list1);
    // intersect.retainAll(list2);
    // return intersect
    List<Integer> intersect = new ArrayList<>();
    for (int i = 0; i < list1.size(); i++) {
      if (list2.contains(list1.get(i))) {
        intersect.add(list1.get(i));
      }
    }
    return intersect;
  }

}
