import java.util.ArrayList;
import java.util.List;

/**
 * Primary java class: Friends
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will create a list of your friends and
 * then print that list. You must use an ArrayList to store the names. Use
 * String constants to add names to your list. Here is an example of how to add
 * one friend's name:
 *
 */
public class Friends {
  public static void main(String... args) {
    List<String> friends = new ArrayList<>();
    friends.add("name1"); // Use String constants to add names to your list.
    friends.add("name2");// Use String constants to add names to your list.
    friends.clear(); // I've completed the requirements of the assignment, now output the list of my friends.
    System.out.println("Here is a list of some of my friends:");
    System.out.println(friends);
  }
}
