/**
 * Primary java class: TwoDArrays
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class TwoDArrays {
  public static void main(String... args) {
    String[][] classRoom = {{"Bob", "Carol", "Ted", "Alice", "Jose"}, {"Mary", "Seema", "Marcus", "Liam", "Veronica"},
        {"Sue", "Billy", "Hannah", "Aaron", "Lauren"}};
    classRoom[2][3] = "LILY";
    classRoom[0][0] = "AMY";
    classRoom[1][2] = "DAVID";

    System.out.println(classRoom[0][0]);
    System.out.println(classRoom[1][0]);
    System.out.println(classRoom[2][0]);

    System.out.println(classRoom[0][1]);
    System.out.println(classRoom[1][1]);
    System.out.println(classRoom[2][1]);

    System.out.println(classRoom[0][2]);
    System.out.println(classRoom[1][2]);
    System.out.println(classRoom[2][2]);

    System.out.println(classRoom[0][3]);
    System.out.println(classRoom[1][3]);
    System.out.println(classRoom[2][3]);

    System.out.println(classRoom[0][4]);
    System.out.println(classRoom[1][4]);
    System.out.println(classRoom[2][4]);
  }
}
