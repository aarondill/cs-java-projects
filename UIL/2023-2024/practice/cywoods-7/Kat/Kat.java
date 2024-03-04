import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Friend {
  public String name;
  public Set<Friend> friends = new HashSet<>();

  Friend(String name) {
    this.name = name;
  }

  public void add(Friend f) {
    friends.add(f);
  }

  @Override
  public String toString() {
    return this.name;
  }
}

public class Kat {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kat.dat";

  private static Friend kat = new Friend("Kat");

  // Finds the length of the shortest path from a to b.
  // Returns -1 if there is no connection.
  private static int minConnectionLength(Friend a, Friend b) {
    return minConnectionLength(a, b, 1, new HashSet<>());
  }

  private static int minConnectionLength(Friend a, Friend b, int depth, Set<Friend> seen) {
    if (a.friends.contains(b)) return depth; // a and b are friends
    if (seen.contains(b)) return -1; // we've already seen b. There's no connection here.
    seen.add(b);
    int min = a.friends.stream().mapToInt(f -> minConnectionLength(f, b, depth + 1, seen)).filter(n -> n > 0).min()
        .orElse(-1);
    if (min == -1) return -1;
    return depth + min;

  }

  private static Friend mostFriend(Friend a, Friend b) {
    if (a == null) return b; // A doesn't exist, so b is the most friend (or null)
    if (b == null) return a; // B doesn't exist, so a is the most friend (or null)
    int depthA = minConnectionLength(kat, a);
    int depthB = minConnectionLength(kat, b);
    if (depthA == -1) return depthB < 0 ? null : b; // if a couldn't be found, b is the most friend (or null)
    if (depthB == -1) return depthA < 0 ? null : b; // if b couldn't be found, a is the most friend (or null)
    if (depthA < depthB) return a;
    if (depthA > depthB) return b;
    if (a.name.length() == b.name.length()) return a; // if same length, return a
    return a.name.length() < b.name.length() ? a : b; // return shorter name
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int friendsCount = scan.nextInt();
    int connectionsCount = scan.nextInt();
    scan.nextLine();
    Map<String, Friend> friendsMap = new HashMap<>();
    friendsMap.put(kat.name, kat);
    for (int i = 0; i < friendsCount; i++) {
      String a = scan.next();
      String type = scan.next();
      String b = scan.next();
      scan.nextLine();
      if (type.equals("NOT")) continue; // todo: special consideration?
      Friend fa = friendsMap.computeIfAbsent(a, Friend::new);
      Friend fb = friendsMap.computeIfAbsent(b, Friend::new);
      fb.add(fa);
      fa.add(fb); // two way friendships
    }
    for (int i = 0; i < connectionsCount; i++) {
      String a = scan.next();
      String b = scan.next();
      scan.nextLine();
      Friend most = mostFriend(friendsMap.get(a), friendsMap.get(b));
      if (most == null) System.out.println("NO FRIENDS");
      else System.out.println(most);
    }
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
