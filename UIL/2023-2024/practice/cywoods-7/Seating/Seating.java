import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

enum Direction {
  LEFT, RIGHT, UP, DOWN
}

public class Seating {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "seating.dat";

  private static final List<String> trouble = List.of("Nik.S", "Bow.Y", "Hen.F", "Tro.D", "Bra.B", "Jar.A");

  private static void each(Scanner scan) {
    // Parse the input:
    int period = Integer.parseInt(scan.nextLine(), 10);
    List<String> students = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
    // Handle output:
    for (String t : trouble.reversed()) { // note: reversed order to add in correct order
      // If the student is in the seating chart, add them to the start
      if (students.remove(t)) students.add(0, t);
    }
    int chartSize = 1; // the length of each edge of the chart
    while (chartSize * chartSize < students.size()) // find the smallest chart size that will fit all the students
      chartSize++;

    // note: seatingChart.get(x) returns a vertical column of students (with 0 being the front of the class)
    List<List<String>> seatingChart = addToChart(students, chartSize);

    // Move all students to the front of the chart:
    for (List<String> column : seatingChart) {
      if (!column.contains(null)) continue; // there are no empty elements
      // shift all students to front of column
      for (int y = 0; y < column.size(); y++) {
        String student = column.get(y);
        if (student != null) {
          int minNull = column.indexOf(null);
          if (minNull == -1) break;
          column.set(minNull, student);
          column.set(y, null);
        }
      }

    }

    String header = "Period " + period;
    System.out.println(header);
    System.out.println("-".repeat(header.length()));
    printMatrix(seatingChart);
  }

  public static List<List<String>> addToChart(List<String> students, int size) {
    // Costruct the chart
    List<List<String>> seatingChart = new ArrayList<>(size);
    for (int x = 0; x < size; x++) {
      seatingChart.add(new ArrayList<>(size));
      for (int y = 0; y < size; y++)
        seatingChart.get(x).add(null); // default to null
    }

    Direction direction = Direction.RIGHT;
    int x = 0, y = 0;
    outer: while (true) {
      x = Math.clamp(x, 0, size - 1); // Reset x and y to valid values.
      y = Math.clamp(y, 0, size - 1);
      while (true) {
        if (students.size() <= 0) break outer;
        if (x >= size || x < 0) break;
        if (y >= size || y < 0) break;
        if (seatingChart.get(x).get(y) != null) {// we've hit a set value
          switch (direction) { // move backwards
            case RIGHT -> x--;
            case LEFT -> x++;
            case UP -> y++;
            case DOWN -> y--;
          };
          break;
        }
        seatingChart.get(x).set(y, students.remove(0));
        switch (direction) {
          case RIGHT -> x++;
          case LEFT -> x--;
          case UP -> y--;
          case DOWN -> y++;
        };
      }
      direction = switch (direction) { // Change direction
        case RIGHT -> Direction.DOWN;
        case LEFT -> Direction.UP;
        case UP -> Direction.RIGHT;
        case DOWN -> Direction.LEFT;
      };
      switch (direction) { // move in the new direction
        case RIGHT -> x++;
        case LEFT -> x--;
        case UP -> y--;
        case DOWN -> y++;
      };
    }

    return seatingChart;
  }

  private static void printMatrix(List<List<String>> seatingChart) {
    // Transpose the seating chart to an outputable format:
    int size = seatingChart.size();
    for (int y = 0; y < size; y++) {
      List<String> output = new ArrayList<>(size);
      for (int x = 0; x < size; x++) {
        List<String> column = seatingChart.get(x);
        String student = column.size() > y ? column.get(y) : null;
        output.add(student == null ? "     " : student);
      }
      System.out.println(String.join(" ", output));
    }
    System.out.println();
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
