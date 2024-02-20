/**
 * public class NameAndSchool
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/17/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: print your first and last name separated by a space on one
 * line followed by the name of your high school on the next line. You must use
 * two statements to print your first and last name.
 */
public class NameAndSchool {
  final static String FIRST_NAME = "Aaron";
  final static String LAST_NAME = "Dill";
  final static String HIGH_SCHOOL = "Grand Oaks High School";

  public static void main(String... args) {
    System.out.print(FIRST_NAME + ' ');
    System.out.println(LAST_NAME);
    System.out.println(HIGH_SCHOOL);
  }
}
