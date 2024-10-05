import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Deck {
  private LinkedList<Character> upper = new LinkedList<>();
  private LinkedList<Character> lower = new LinkedList<>();

  public Deck(List<Character> cards) {
    init(cards);
  }

  private void init(List<Character> cards) {
    upper.clear();
    lower.clear();
    int endTop = Math.ceilDiv(cards.size(), 2); // if odd, extra card is in upper half
    cards.stream().limit(endTop).forEach(upper::add);
    cards.stream().skip(endTop).forEach(lower::add);
  }

  public Deck(CharSequence cards) {
    this(cards.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
  }

  public void shuffle() {
    LinkedList<Character> result = new LinkedList<>();
    while (!upper.isEmpty()) { // upper must always have >= lower
      result.addFirst(upper.removeLast());
      if (!lower.isEmpty()) result.addFirst(lower.removeLast());
    }
    init(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    upper.stream().forEach(sb::append);
    lower.stream().forEach(sb::append);
    return sb.toString();
  }

}

public class Facundo {
  private static final String INPUT_FILE = "facundo.dat";

  private static void each(Scanner scan) {
    String cards = scan.next();
    int n = scan.nextInt();
    scan.nextLine();
    Deck deck = new Deck(cards);
    for (int i = 0; i < n; i++)
      deck.shuffle();
    System.out.println(deck);
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
