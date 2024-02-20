import java.util.ArrayList;
import java.util.Scanner;

/**
 * Primary java class: ListOfStates
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/15/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will allow the user to enter the names
 * of states that they would like to visit. Stop prompting for states when the
 * user enters "Stop". Store all of the state names entered in an ArrayList. Do
 * not store "Stop". After all of the states have been entered, the program
 * should print the state names all on one line each separated by a space, an
 * arrow (->) and a space. Do not print an arrow at the end of the list of
 * states. You must use a for loop to traverse the list. The prompts and output
 * must be formatted exactly as is shown in the sample run shown on the right.
 *
 * 
 */
public class ListOfStates {
  public static void main(String... args) {
    ArrayList<String> states = new ArrayList<String>();
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter the name of a state or \"Stop\" to quit: ");
      String state = scan.nextLine();
      while (!state.equals("Stop")) {
        states.add(state);
        System.out.print("Next state or \"Stop\": ");
        state = scan.nextLine();
      }
    }
    System.out.println();
    // System.out.println(states.stream().collect(java.util.stream.Collectors.joining(" -> ")));
    for (int i = 0; i < states.size(); i++) {
      System.out.print(states.get(i));
      if (i != states.size() - 1) System.out.print(" -> ");
    }
    System.out.println();
  }
}
