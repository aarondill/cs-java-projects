import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grading {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "grading.dat";

  private static void each(Scanner scan) {
    int dataCount = Integer.parseInt(scan.nextLine(), 10);
    Map<String, List<Double>> grades = new HashMap<>();
    for (int i = 0; i < dataCount; i++, caseNum++) {
      String key = scan.next();
      int totalQ = key.length();
      int studentCount = scan.nextInt();
      scan.nextLine();
      for (int j = 0; j < studentCount; j++) {
        String student = scan.next();
        String answers = scan.next();
        int correct = (int) IntStream.range(0, totalQ).filter(k -> answers.charAt(k) == key.charAt(k)).count();
        double grade = (correct / (double) totalQ) * 100;
        grades.computeIfAbsent(student, k -> new ArrayList<>()).add(grade);
      }
    }

    List<String> rankedStudents = grades.entrySet().stream().sorted((a, b) -> {
      double aAvg = a.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
      double bAvg = b.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
      return Double.compare(aAvg, bAvg);
    }).map(Map.Entry::getKey).toList().reversed();
    for (int i = 0; i < rankedStudents.size(); i++) {
      String gradeString = grades.get(rankedStudents.get(i)).stream().sorted(Comparator.reverseOrder())
          .map(n -> String.format("%.2f", n)).collect(Collectors.joining(" "));
      System.out.printf("#%d: %s, %s\n", i + 1, rankedStudents.get(i), gradeString);
    }

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
