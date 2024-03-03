import java.util.Scanner;

public class Ivan {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Ivan.class.getResourceAsStream("./ivan.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      char[] answers = dataScanner.nextLine().toCharArray();
      for (int i = 0; i < dataCount; i++) {
        String data = dataScanner.nextLine();
        long attempted = data.chars().filter(c -> c != '_').count();
        char[] studentAnswers = data.toCharArray();
        int correct = 0;
        for (int j = 0; j < studentAnswers.length; j++)
          if (answers[j] == studentAnswers[j]) correct++;
        long score = (correct * 6) - ((attempted - correct) * 2);
        double accuracy = ((double) correct) / attempted;
        System.out.printf("Exam #%d: %d %.1f\n", i + 1, score, accuracy*100);
      }
    }

  }
}
