import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sage {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "sage.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Student> s = new ArrayList<>();
    while (scan.hasNextLine()) {
      int id = scan.nextInt();
      int score = scan.nextInt();
      scan.nextLine();
      s.add(new Student(id, score));
    }
    double avg = s.stream().mapToInt(Student::score).average().getAsDouble();
    long numAbv = s.stream().mapToInt(Student::score).filter(stud -> stud > avg).count();

    int high = s.stream().mapToInt(Student::score).max().getAsInt();
    List<Integer> highStudents = s.stream().filter(stud -> stud.score() == high).map(Student::id).toList();
    int low = s.stream().mapToInt(Student::score).min().getAsInt();
    List<Integer> lowStudents = s.stream().filter(stud -> stud.score() == low).map(Student::id).toList();
    // Handle output:
    System.out.printf("Average score: %.2f\n", avg);
    System.out.printf("   Highest score: %d\n", high);
    System.out.printf("      Students with highest score:\n");
    for (int sc : highStudents)
      System.out.printf("         %d\n", sc);
    System.out.printf("   Lowest score: %d\n", low);
    System.out.printf("      Students with lowest score:\n");
    for (int sc : lowStudents)
      System.out.printf("         %d\n", sc);
    System.out.println("Number of students above the average: " + numAbv);

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

record Student(int id, int score) {}
