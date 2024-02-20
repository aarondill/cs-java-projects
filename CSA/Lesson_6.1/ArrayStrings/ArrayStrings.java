/**
 * Primary java class: ArrayStrings
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/26/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to create a String array called friends
 * using an initializer list to contain the first names of five of your
 * classmates.
 * 
 * Output each element of the array using the indexing process.
 * 
 * Change at least one of the names to another classmate's first name, and then
 * output all five names again, in the same order as the first output series.
 *
 * 
 * 
 */
public class ArrayStrings {
  // return number between min (inclusive) and max (exclusive)
  private static int random(int min, int max) {
    return (int) (Math.random() * (max - min)) + min;
  }

  public static void main(String... args) {
    String[] friends = {"Aaron", "Bob", "Martin", "John", "Emilio"};
    for (int i = 0; i < friends.length; i++)
      System.out.println(friends[i]);

    int randomIndex = random(0, friends.length), anotherRandomIndex;
    do {
      anotherRandomIndex = random(0, friends.length);
    } while (anotherRandomIndex == randomIndex);

    friends[randomIndex] = "Hayden"; // Set a new name
    friends[anotherRandomIndex] = "Flavio"; // and another

    System.out.println(); // empty line for readability
    for (int i = 0; i < friends.length; i++)
      System.out.println(friends[i]);
  }
}
