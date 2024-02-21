import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Primary java class: Duplicates2
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/21/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will remove all duplicate entries in a
 * list of names. The list will be saved in a file named names.txt. Your program
 * should read the names from the file and then print the original list and a
 * list of those names without any duplicate entries. You should have a method
 * that returns true if a name is duplicated in the list and a void method that
 * removes any duplicates AFTER the first occurrence of the duplicated word. Do
 * not remove duplicate names as they are read from the file. You must traverse
 * the list to remove the duplicates. The output should be the original list
 * with each name separated by a single space and the list with duplicates
 * removed shown with a space between each.
 *
 * 
 */
public class Duplicates2 {
  private static boolean isDuplicate(List<String> list, String name) {
    // return list.subList(list.indexOf(name) + 1, list.size()).contains(name);
    int start = list.indexOf(name);
    for (int i = start + 1; i < list.size(); i++)
      if (list.get(i).equals(name)) return true;
    return false;
  }

  // Only removes the duplicates of `word`. Keeps the first occurrence.
  private static void removeDuplicates(List<String> list, String name) {
    int start = list.indexOf(name);
    // Note: i-- because removing this element will change the position of the next element in the list.
    for (int i = start + 1; i < list.size(); i++)
      if (list.get(i).equals(name)) list.remove(i--);
  }

  // Returns null if a FileNotFoundException is thrown.
  private static <T> List<T> getListFromFile(String path, Predicate<Scanner> hasNext, Function<Scanner, T> next) {
    List<T> list = new ArrayList<>();
    try (Scanner scan = new Scanner(new File((path)))) {
      while (hasNext.test(scan))
        list.add(next.apply(scan));
    } catch (FileNotFoundException e) {
      return null;
    }
    return list;
  }

  public static void main(String... args) {
    List<String> names = getListFromFile("./names.txt", Scanner::hasNextLine, Scanner::nextLine);
    System.out.println(String.join(" ", names));
    // names=names.stream().distinct().toList();
    for (int i = 0; i < names.size(); i++) {
      String name = names.get(i);
      if (isDuplicate(names, name)) removeDuplicates(names, name);
    }
    System.out.println(String.join(" ", names));
  }
}
