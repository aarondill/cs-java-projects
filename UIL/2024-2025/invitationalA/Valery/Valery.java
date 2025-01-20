import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Valery {
  private static final String INPUT_FILE = "valery.dat";

  private static void each(Scanner scan) {
    int numOffice = Integer.parseInt(scan.nextLine(), 10);
    // Construct offices
    List<Office> offices = new ArrayList<>(numOffice);
    Map<Office, List<String>> temporaryConnections = new HashMap<>();
    for (int i = 0; i < numOffice; i++) {
      String from = scan.next();
      int numDeliveries = scan.nextInt();
      scan.nextLine();
      List<String> deliveries = new ArrayList<>(numDeliveries);
      for (int j = 0; j < numDeliveries; j++)
        deliveries.add(scan.next());
      Office o = new Office(from);
      temporaryConnections.put(o, deliveries);
      offices.add(o);
      if (numDeliveries > 0) scan.nextLine();
    }
    for (Office from : temporaryConnections.keySet()) {
      List<String> deliveries = temporaryConnections.get(from);
      for (String to : deliveries) {
        Office toOffice = offices.stream().filter(c -> c.name().equals(to)).findFirst().get();
        toOffice.incomingDeliveries().add(from);
        from.deliveries().add(toOffice);
      }
    }

    // Find office with no incoming deliveries
    Office start = offices.stream().filter(o -> o.incomingDeliveries().isEmpty()).findAny().get();
    List<Office> path = findPath(start);
    System.out.println(path.stream().map(Office::name).collect(Collectors.joining("->")));
  }

  public static List<Office> findPath(Office start) {
    List<Office> path = new LinkedList<>();
    PriorityQueue<Office> queue = new PriorityQueue<>(Comparator.comparing(Office::name));
    queue.add(start);
    while (!queue.isEmpty()) {
      Office o = queue.poll();
      if (!o.incomingDeliveries().isEmpty())
        throw new IllegalStateException("Min Office " + o + " has incoming deliveries");
      path.add(o);
      for (Office to : o.deliveries()) {
        to.incomingDeliveries().remove(o);
        if (to.incomingDeliveries().isEmpty()) queue.add(to);
      }
    }
    return path;
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

// deliveries are outgoing connections
record Office(String name, List<Office> deliveries, List<Office> incomingDeliveries) {
  public Office(String name) {
    this(name, new ArrayList<>(), new ArrayList<>());
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Office office && name == office.name;
  }

  @Override
  public String toString() {
    return name + "";
  }
}
