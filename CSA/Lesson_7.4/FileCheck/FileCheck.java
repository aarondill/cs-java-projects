import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Primary java class: FileCheck
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/21/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class FileCheck {
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

  private static <T> boolean listMatch(List<T> file1, List<T> file2) {
    if (file1.size() != file2.size()) return false;
    for (int i = 0; i < file1.size(); i++) {
      if (!file1.get(i).equals(file2.get(i))) return false;
    }
    return true;
  }

  // This method is extremely inefficient. Instead, each line (byte) should be compared as it's read.
  public static void main(String... args) {
    List<String> file1 = getListFromFile("./time1.txt", Scanner::hasNext, Scanner::next); // Note: there's no reason not to use nextLine here
    List<String> file2 = getListFromFile("./time2.txt", Scanner::hasNext, Scanner::next);
    if (listMatch(file1, file2)) System.out.println("The files are an exact match.");
    else System.out.println("The files do not match.");
  }
}
