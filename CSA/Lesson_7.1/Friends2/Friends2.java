import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: Friends2
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Modify the Friends class that you created in 7.1.1 so that
 * the user may input the names of their friends. Prompt the user for the number
 * of friends to be added and then prompt the user for the names of that many
 * friends. After each name has been entered, print the entire list.
 *
 * 
 */
public class Friends2 {
  static Scanner scan = new Scanner(System.in);

  private static String line(String prompt) {
    System.out.print(prompt + ": ");
    return scan.nextLine();
  }

  public static void main(String... args) {
    List<String> friends = new ArrayList<>();
    System.out.print("How many friends would you like to place in your list? ");
    int num = scan.nextInt();
    scan.nextLine();
    // friends = java.util.stream.IntStream.rangeClosed(1, num).mapToObj(i -> "Friend #" + i).map(Friends2::line).toList();
    for (int i = 1; i <= num; i++)
      friends.add(line("Friend #" + i));
    System.out.println(friends);

  }
}
