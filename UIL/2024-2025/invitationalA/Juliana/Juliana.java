import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Juliana {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "juliana.dat";

  private static void each(Scanner scan) {
    int cases = scan.nextInt();
    int peopleNumber = scan.nextInt();
    scan.nextLine();

    Map<String, Person> people = new HashMap<>();
    // Parse the input:
    Map<String, List<String>> temporaryConnections = new HashMap<>();
    for (int i = 0; i < peopleNumber; i++) {
      String firstName = scan.next();
      String lastName = scan.next();
      String name = firstName + " " + lastName.substring(0, lastName.length() - 1);
      int years = scan.nextInt();
      String major = scan.next(), field = scan.next();
      String[] connections = scan.nextLine().trim().split(" ");
      List<String> connectionFullNames = new ArrayList<>();
      for (int j = 0; j < connections.length - 1; j += 2) {
        connectionFullNames.add(connections[j] + " " + connections[j + 1]);
      }
      temporaryConnections.put(name, connectionFullNames);
      people.put(name, new Person(name, years, List.of(major, field), new ArrayList<>()));
    }

    for (String name : temporaryConnections.keySet()) {
      Person p = people.get(name);
      p.connections().addAll(temporaryConnections.get(name).stream().map(people::get).toList());
    }

    for (int i = 0; i < cases; i++) {
      String name = scan.nextLine();
      int years = scan.nextInt();
      String field = scan.next();
      if (scan.hasNextLine()) scan.nextLine();
      Set<Person> validPeople = find(people.get(name), years, field, Collections.emptySet());
      System.out.println(validPeople.stream().filter(p -> p != people.get(name)).sorted().map(Person::name)
          .collect(Collectors.joining(", ")));
    }
  }

  static public Set<Person> find(Person p, int years, String field, Set<Person> visited) {
    if (visited.contains(p)) return Collections.emptySet();
    visited = new HashSet<>(visited);
    visited.add(p);
    Set<Person> valid = new HashSet<>();
    if (p.field().contains(field) && p.years() >= years) valid.add(p);
    for (Person connect : p.connections()) {
      valid.addAll(find(connect, years, field, visited));
    }
    return valid;
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Person(String name, int years, List<String> field, List<Person> connections) implements Comparable<Person> {
  public int compareTo(Person other) {
    return name.split(" ")[1].compareTo(other.name.split(" ")[1]);
  }

  // Needed to prevent stackoverflow on connections hash
  public int hashCode() {
    return name.hashCode();
  }

  public boolean equals(Object o) {
    return o instanceof Person p && p.name == name;
  }

}
