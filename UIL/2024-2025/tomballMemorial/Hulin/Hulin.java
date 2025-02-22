import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hulin {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "hulin.dat";

  private static void each(Scanner scan) {
    int dataCount = Integer.parseInt(scan.nextLine(), 10);
    List<List<Shift>> shifts = new ArrayList<>();
    for (int i = 0; i < dataCount; i++, caseNum++) {
      List<Shift> person = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        int start = scan.nextInt(), end = scan.nextInt();
        Shift s = new Shift(start, end);
        person.add(s);
      }
      scan.nextLine();
      shifts.add(person);
    }
    int max = 0;
    for (int time = 0; time < 86_400; time++) {
      int count = 0;
      for (List<Shift> person : shifts)
        for (Shift s : person)
          if (s.start() <= time && s.end() >= time) count++;
      max = Math.max(max, count);
    }
    System.out.println(max);

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

record Shift(int start, int end) {
  public boolean intersects(Shift s) {
    return s.start >= start && start <= s.end;
  }

}
