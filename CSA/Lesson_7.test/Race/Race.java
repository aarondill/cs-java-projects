import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * class: Race
 *
 * <pre>
 * Author: Aaron Dill
 * Date: 03/07/2024
 * Course: CSA
 * Period: 3rd
 * </pre>
 *
 * Summary of file: The Race class's main method should print a greeting and
 * then prompt the user for the name of each DotRacer in the race, until the
 * user indicates they're done by inputting 'done' in any case. Instantiate each
 * DotRacer object using the names provided by the user. Assign the DotRacers to
 * an ArrayList. Next, prompt the user for the number of moves each DotRacer
 * will make. Use selection sort to sort the DotRacer objects based on position
 * from greatest to least. Print the racers in the order that they finished and
 * print the names of the winner or winners. ¡Summary go!
 */
public class Race {
  private static Scanner kb = new Scanner(System.in);
  private static ArrayList<DotRacer> racers = new ArrayList<>();

  public static void selectionSortDesc(List<DotRacer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      int largestI = i;
      for (int j = i + 1; j < list.size(); j++)
        if (list.get(j).getPosition() > list.get(largestI).getPosition()) largestI = j;
      Collections.swap(list, i, largestI);
    }
  }

  public static void main(String[] args) {
    System.out.println("Let's see who has the fastest DotRacer!");
    System.out.println();
    System.out.println("Now enter the name of each of the racers:");
    DotRacer r;
    while ((r = makeRacer()) != null)
      racers.add(r); // user is done when makeRacer returns null
    System.out.println();
    System.out.println("How many moves in today's race?");
    int moves = kb.nextInt();
    race(moves);
    selectionSortDesc(racers);
    printRaceResults();
  }

  // Returns null when the user is done creating racers.
  public static DotRacer makeRacer() {
    System.out.print("Racer name? ");
    String name = kb.nextLine(); //use nextLine so multi-word names can be used
    if (name.toLowerCase().equals("done")) return null; // User is done. Tell the main method!
    return new DotRacer(name);
  }

  public static void race(int moves) {
    for (int x = 1; x <= moves; x++)
      racers.forEach(DotRacer::move);
  }

  public static void printRaceResults() {
    if (racers.size() == 0) throw new IllegalArgumentException("There are no racers! I can't determine the winner!");
    racers.forEach(System.out::println);
    DotRacer first = racers.get(0); // get the first one (sorted list, so we know they've won)
    // An unacceptable solution?:
    //List<String> winnerNames = racers.stream()
    //                               .filter(r->r.getPosition()==first.getPosition())
    //                               .map(r->r.getName())
    //                               .toList();
    List<String> winnerNames = new ArrayList<>();
    for (int i = 0; i < racers.size() && racers.get(i).getPosition() == first.getPosition(); i++)
      winnerNames.add(racers.get(i).getName());
    System.out.println();
    System.out.print("The winners are ");
    System.out.print(String.join(" ", winnerNames));
    System.out.println("!");
  }
}
