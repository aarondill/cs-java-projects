import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Dominick {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dominick.dat";

  // Move disk from a to b if legal, otherwise move from b to a
  // Returns true if moved to b, false if moved to a
  private boolean move(Deque<Integer> a, Deque<Integer> b) {
    if (a.isEmpty() && b.isEmpty()) throw new IllegalStateException("Both deques are empty");
    // if b is empty, we move a->b;
    // if a is empty, we move b->a;
    // we move a->b if a is smaller than b and b->a otherwise
    boolean moveToB = b.isEmpty() ? true : a.isEmpty() ? false : a.peek() < b.peek();
    if (moveToB) b.push(a.pop());
    else a.push(b.pop());
    return moveToB;
  }

  private void moveTo(Deque<Integer> from, Deque<Integer> to) {
    if (move(from, to)) System.out.printf("Move snail %d from %s to %s\n", to.peek(), outputNum(from), outputNum(to));
    else System.out.printf("Move snail %d from %s to %s\n", from.peek(), outputNum(to), outputNum(from));
  };

  Deque<Integer> a, b, c, endingPeg;

  // Get the number of the rock for output (rock 3 is the end, which may be b or c)
  private String outputNum(Deque<Integer> deque) {
    if (deque == a) return "rock 1";
    if (deque == endingPeg) return "rock 3";
    return "rock 2";
  }

  private Dominick(Scanner scan) {
    int numDisks = scan.nextLine().split(" ").length; // it lists sizes, but they don't matter
    a = new ArrayDeque<Integer>(numDisks); // starting peg
    // The value is the index of the disk (ready for output). #1 is the top of the stack. The bottom is #numDisks
    for (int i = numDisks; i >= 1; i--)
      a.push(i);
    b = new ArrayDeque<Integer>(numDisks);
    c = new ArrayDeque<Integer>(numDisks);
    // If numDisks is odd, B is the final peg, otherwise C is the final peg
    endingPeg = numDisks % 2 == 0 ? c : b;
    // continue until all disks are moved to either b or c
    while (endingPeg.size() != numDisks) {
      moveTo(a, b); // 1. Move one disk from peg A to peg B or vice versa, whichever move is legal.
      if (endingPeg.size() == numDisks) break; // if all disks are moved, break
      moveTo(a, c); // 2. Move one disk from peg A to peg C or vice versa, whichever move is legal.
      if (endingPeg.size() == numDisks) break; // if all disks are moved, break
      moveTo(b, c); // 3. Move one disk from peg B to peg C or vice versa, whichever move is legal.
    }
    System.out.println(); // empty line between cases
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++) {
        new Dominick(scan);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
