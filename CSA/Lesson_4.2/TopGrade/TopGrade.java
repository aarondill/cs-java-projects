import java.util.Scanner;

/**
 * Primary java class: TopGrade
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/06/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that allows the user to enter a number of students. For each
 * student, allow the user to enter their name and a grade then print the name
 * and grade of the student with the highest grade. All of the grades will be
 * whole numbers between 0 and 100 inclusive and the names will only be first
 * names
 *
 */
public class TopGrade {
  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("How many students? ");
      int numStudents = scan.nextInt();

      String max_name = "";
      int max_grade = -1;
      for (int i = 0; i < numStudents; i++) {
        System.out.print("Name? ");
        String name = scan.next();
        System.out.print("Grade? ");
        int grade = scan.nextInt();

        if (grade > max_grade) {
          max_name = name;
          max_grade = grade;
        }
      }
      System.out.printf("%s %d\n", max_name, max_grade);
    }
  }
}
