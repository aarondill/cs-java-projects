import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Missions {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "missions.dat";

  static Map<String, List<String>> people = Map.of( //
      "Colossus", Arrays.asList("Strength,Invulnerability".split(",")), //
      "Wolverine", Arrays.asList("Hand-to-Hand,Invulnerability".split(",")), //
      "Nightcrawler", Arrays.asList("Teleportation,Swords,Hand-to-Hand,Agility".split(",")), //
      "Storm", Arrays.asList("Flight,Electric,Cold".split(",")), //
      "Banshee", Arrays.asList("Flight,Energy-Blasts".split(",")), //
      "Cyclops", Arrays.asList("Hand-to-Hand,Energy-Blasts".split(",")), //
      "Phoenix", Arrays.asList("Flight,Telekinesis,Telepathy,Energy-Blasts".split(",")), //
      "Iceman", Arrays.asList("Cold,Invulnerability".split(",")), //
      "Beast", Arrays.asList("Strength,Agility".split(",")), //
      "Angel", Arrays.asList("Flight,Swords".split(","))//
  );

  private static void each(Scanner scan) {
    // Parse the input:
    List<String> abilities = Arrays.asList(scan.nextLine().split("\\s+"));
    Set<Set<String>> people = combos(abilities);
    System.out.println(people.size());
    Optional<Set<String>> first = people.stream().sorted((a, b) -> ("" + a).compareTo("" + b)).findFirst(); // find alphabetically first list
    if (!first.isPresent()) System.out.println();
    else System.out.println(String.join(" ", first.get()));
  }

  public static Set<Set<String>> combos(List<String> abilities) {
    return combos(abilities, new LinkedHashSet<>());
  }

  // Find all possible combinations of people with abilities
  public static Set<Set<String>> combos(List<String> abilities, Set<String> current) {
    if (current.size() == abilities.size()) {
      return Set.of(new LinkedHashSet<>(current));
    }

    Set<Set<String>> combos = new HashSet<>();
    String ability = abilities.get(current.size());
    for (String person : people.keySet()) {
      if (!people.get(person).contains(ability)) continue;
      if (current.contains(person)) continue; // no duplicates!
      current.add(person);
      Set<Set<String>> res = (combos(abilities, current));
      for (Set<String> combo : res) {
        if (combos.contains(combo)) {
          Set<String> o = (combos.stream().filter(c -> c.equals(combo)).findFirst().get());
          if (combo.toString().compareTo(o.toString()) < 0) {
            combos.remove(combo);
            combos.add(combo);
          }
        } else combos.add(combo);
      }
      current.remove(person);
    }
    return combos;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
