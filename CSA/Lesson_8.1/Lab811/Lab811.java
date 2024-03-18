/**
 * Primary java class: Lab811
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define a 2x3 two-dimensional String array
 * using initializer lists to provide beginning values. display car makes
 *
 *
 */
public class Lab811 {
  public static void main(String... args) {
    String[][] carMakes = {{"Kia", "Ford", "Chevy"}, {"Ram", "Christler", "Mercedes"}};
    for (String[] row : carMakes)
      System.out.println(String.join("\n", row));
    carMakes[1][1] = "BMW";
    carMakes[0][1] = "CADILLAC";
    carMakes[0][0] = "AUDI";
    System.out.println();
    for (String[] row : carMakes)
      System.out.println(String.join("\n", row));
  }
}
