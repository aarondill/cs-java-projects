import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: DotRacerList
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will allow the user to enter a list of
 * DotRacer objects that will be in a race. The program should prompt the user
 * for the number of DotRacers then prompt the user for the name of each of the
 * DotRacers. After the names have been entered the program should print the
 * name and position of each of the DotRacers.
 * 
 * Your program must meet the following specifications:
 * 
 * Declare and use an ArrayList to create the list of DotRacers You must prompt
 * the user for the number of DotRacers and enter that number from the keyboard
 * Include a static method to o prompt for the name of each DotRacer read the
 * name from the console instantiate a DotRacer object return the DotRacer
 * object to the calling method Use a for loop to add each DotRacer to the list
 * by calling the static method described above Print the ArrayList of
 * DotRacers. None of the DotRacers will be moved so all of the positions should
 * be zero. A sample run and the code for the DotRacer class are shown below.
 *
 * 
 */
public class DotRacerList {
  public static DotRacer newDotRacer(Scanner scan) {
    System.out.print("What is this DotRacer's name? ");
    return (new DotRacer(scan.next()));
  }

  public static void main(String... args) {
    List<DotRacer> drList = new ArrayList<>();
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("How many DotRacers are in this race? ");
      int num = scan.nextInt();
      for (int i = 0; i < num; i++)
        drList.add(newDotRacer(scan));
    }
    System.out.println(drList);
  }
}
