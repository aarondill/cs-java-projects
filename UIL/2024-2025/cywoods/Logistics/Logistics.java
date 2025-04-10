import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * <pre>
 * 3 4 3
 * Mafia_A A B C
 * Mafia_B D E F
 * Mafia_C G H I
 * Site_A A B D E G
 * Site_B A C D I H
 * Site_C B C D E I
 * Site_D I C G H
 * A Site_A -> C Site_C
 * E Site_C -> H Site_B
 * G Site_D -> D Site_A
 * </pre>
 */
public class Logistics {
  private static final String INPUT_FILE = "logistics.dat";

  /**
   * it is guaranteed the start person will have access to the start site, the end
   * person will have access to the end site, they will be different, and that a
   * path is possible between them.
   */
  private Logistics(Scanner scan) {
    int O = scan.nextInt(), S = scan.nextInt(), J = scan.nextInt();
    scan.nextLine();
    Map<String, Person> people = new HashMap<>(); // Name -> Person
    Map<String, List<Person>> organizations = new HashMap<>();
    Map<String, List<Person>> sites = new HashMap<>();
    for (int i = 0; i < O; i++) { // Mafias
      List<String> line = Arrays.asList(scan.nextLine().split(" "));
      String name = line.get(0);
      List<Person> peopleInOrganization =
          line.subList(1, line.size()).stream().map(n -> people.computeIfAbsent(n, Person::new)).toList();
      peopleInOrganization.forEach(p -> p.organization = name);
      organizations.put(name, peopleInOrganization);
    }
    for (int i = 0; i < S; i++) { // Sites
      // Site_A A B D E G
      List<String> line = Arrays.asList(scan.nextLine().split(" "));
      String name = line.get(0);
      List<Person> peopleInSite =
          line.subList(1, line.size()).stream().map(n -> people.computeIfAbsent(n, Person::new)).toList();
      peopleInSite.forEach(p -> p.sites.add(name));
      sites.put(name, peopleInSite);
    }

    // create Nodes before pathfinding
    Map<IndexName, Node> nodes = new HashMap<>();
    for (Person person : people.values()) {
      List<Node> personNodes = person.sites.stream() // Each site gets it's own node
          .map(site -> new IndexName(person, site)) // IndexName
          .map(indexName -> nodes.computeIfAbsent(indexName, Node::new)) // Node
          .toList();
      // Connect each personNode to every other personNode at the cost of site transfer
      for (Node p : personNodes) {
        for (Node other : personNodes) {
          if (p == other) continue; // Don't connect to yourself.
          p.link(other);
        }
      }
    }
    // Connect each personNode in a site to every other personNode in the same site
    for (String site : sites.keySet()) {
      List<Person> sitePeople = sites.get(site);
      // A list of personNodes in the site
      List<Node> personNodes = sitePeople.stream().map(p -> new IndexName(p, site)).map(nodes::get).toList();
      for (Node p : personNodes) {
        for (Node other : personNodes) {
          if (p == other) continue; // Don't connect to yourself.
          p.link(other);
        }
      }
    }

    for (int i = 0; i < J; i++) { // Jobs
      String[] line = scan.nextLine().split(" -> ");
      String[] fromStr = line[0].split(" "), toStr = line[1].split(" ");
      Node from = nodes.get(new IndexName(people.get(fromStr[0]), fromStr[1]));
      Node to = nodes.get(new IndexName(people.get(toStr[0]), toStr[1]));
      double cost = bellmanFord(from, to);
      System.out.printf("%s -> %s $%.2f\n", from.indexName(), to.indexName(), cost);
    }
  }

  /*
   * Returns the cost of the shortest path from from to to end
   */
  public double bellmanFord(Node from, Node to) {
    Map<Node, Double> distances = new HashMap<>();
    Queue<Node> queue = new ArrayDeque<>();
    distances.put(from, 0.0);
    queue.add(from);
    while (!queue.isEmpty()) {
      Node current = queue.remove();
      if (current.equals(to)) return distances.get(to);
      for (Node next : current.links().keySet()) {
        double newDistance = distances.get(current) + current.links().get(next).cost;
        if (newDistance < distances.getOrDefault(next, Double.POSITIVE_INFINITY)) {
          distances.put(next, newDistance);
          queue.add(next);
        }
      }
    }
    return distances.get(to);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        new Logistics(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

// Each person can be in only one organization (mafia)
// Each person can be at multiple sites
class Person {
  final Set<String> sites = new HashSet<>();
  String name;
  String organization;

  public Person(String name) {
    this.name = name;
  }

  public String toString() {
    return "%s(%s) @ %s".formatted(name, organization, sites);
  }
}

enum TransferType {
  /** Between two sites, the same person */
  INTERSITE(7.50),
  /** Within one site, two people in different organizations */
  INTRAORG(12.50),
  /** Within one site, two people in the same organization */
  INTERORG(19.75);

  final double cost;

  TransferType(double cost) {
    this.cost = cost;
  }
}

record IndexName(Person person, String site) {
  public String toString() {
    return site + ' ' + person.name;
  }
}

/**
 * A Node is a person at a site. Each person can have multiple Nodes
 *
 * @param indexName "Name Site"
 *
 *        <pre>
 * SiteA PersonA -> SiteB PersonA costs $7.50
 * SiteA PersonA -> SiteA PersonB costs $12.50 *if* A and B are in the same organization
 * SiteA PersonA -> SiteA PersonB costs $19.75 *if* A and B are in different organizations
 *        </pre>
 *
 */
record Node(IndexName indexName, Map<Node, TransferType> links) {
  public Node(IndexName indexName) {
    this(indexName, new HashMap<>());
  }

  public boolean equals(Object o) {
    return this == o || (o instanceof Node node && indexName.equals(node.indexName));
  }

  public int hashCode() {
    return indexName.hashCode();
  }

  /**
   * Links this node to another node (note: not the other way around) Calculates
   * the correct {@link TransferType}
   */
  public void link(Node other) {
    if (other.equals(this)) throw new IllegalArgumentException("Cannot transfer to self");
    links().put(other, siteTransferType(other));
  }

  public TransferType siteTransferType(Node other) {
    if (indexName.person().equals(other.indexName.person())) {
      if (indexName.site().equals(other.indexName.site()))
        throw new IllegalArgumentException("Cannot transfer to self (in same site)");
      return TransferType.INTERSITE; // Same person, different sites
    }
    // person != other.person
    // You aren't allowed to transfer from SiteA PersonA -> SiteB PersonB
    if (!indexName.site().equals(other.indexName.site())) {
      throw new IllegalArgumentException(
          "Can't transfer between people in different sites! %s->%s".formatted(indexName, other.indexName));
    }

    if (indexName.person().organization.equals(other.indexName.person().organization)) return TransferType.INTRAORG; // Same organization
    else return TransferType.INTERORG;
  }
}
