import java.util.Scanner;

/**
 * Primary java class: ClassHealthQuizRevisited
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Lab 3.7.1 – ClassHealthQuizRevisited -
 * Rewrite the program you did in an earlier lesson that assesses your Computer
 * Science class health. Create yes or no questions to identify whether or not a
 * student has good class habits. For each yes answer, add a point to the
 * student's score. This time, have the user input a String ("y") or a String
 * ("n") and use the String equals method. When the quiz is over, report to the
 * student if their class health is good or not. You can set the range. Caution:
 * All questions and output must be school appropriate.
 * 
 */
public class ClassHealthQuizRevisited {
  final static String[] questions = {
      "Do you complete each assigned reading for this class?",
      "Do you complete your written homework for this class?",
      "Do you come in for tutoring when needed for this class?",
      "Do you pay attention in this class?",
      "Do you complete each assigned program for this class?",
  };
  static int score = 0;

  // Stops the program.
  private static void input_mismatch(String message) {
    final char[] format = { 10, 67, 111, 100, 101, 32, 99, 111, 109, 112, 105, 108, 101, 115, 44, 32, 101, 120, 101, 99,
        117, 116, 101, 115, 44, 32, 97, 110, 100, 32, 112, 114, 111, 100, 117, 99, 101, 115, 32, 116, 104, 101, 32, 100,
        101, 115, 105, 114, 101, 100, 32, 111, 117, 116, 112, 117, 116, 44, 32, 98, 117, 116, 32, 116, 104, 101, 32,
        116, 101, 115, 116, 101, 114, 32, 104, 97, 115, 32, 110, 111, 116, 32, 102, 111, 108, 108, 111, 119, 101, 100,
        32, 116, 104, 101, 32, 112, 114, 111, 118, 105, 100, 101, 100, 32, 105, 110, 115, 116, 114, 117, 99, 116, 105,
        111, 111, 115, 10, 47, 47, 32, 37, 115, 10, 10, 47, 47, 32, 82, 101, 118, 105, 115, 101, 32, 97, 110, 100, 32,
        82, 101, 115, 117, 98, 109, 105, 116, 32, 105, 110, 112, 117, 116, 32, 116, 111, 32, 99, 111, 110, 116, 105,
        110, 117, 101, 32, 101, 120, 101, 99, 117, 116, 105, 111, 110, 32, 105, 102, 32, 115, 117, 98, 109, 105, 116,
        116, 101, 100, 32, 119, 105, 116, 104, 105, 110, 32, 50, 52, 32, 104, 111, 117, 114, 115, 32, 111, 102, 32, 102,
        101, 101, 100, 98, 97, 99, 107, 46, 10 }; // Try it if you want to see.
    System.err.printf(new String(format), message);
    System.exit(1);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Computer Science Class Health Quiz");
      System.out.println("======== ======= ===== ====== ====");
      System.out.print("Enter your name: ");
      String name = scan.nextLine();
      System.out.println("For each of the following questions, enter y or n.");
      for (String question : questions) {
        System.out.printf("%s ", question);
        String response = scan.next().toLowerCase().intern(); // I'll be nice. Y/y and N/n are allowed.
        if (!response.equals("y") && !response.equals("n")) {
          input_mismatch(String.format("Invalid response: '%s'. Valid responses only include n and y.", response));
        }
        score += response.equals("y") ? 1 : 0;
      }
      System.out.printf("%s, your score is %d.\n", name, score);
      if (score >= questions.length / 2) { // 50% or greater is passing here.
        System.out.println("Your Computer Science Class Health is good. You should do well in this class.");
      } else {
        System.out.println("Your Computer Science Class Health is poor. Do vour work and see your teacher!");
      }

    }

  }
}
