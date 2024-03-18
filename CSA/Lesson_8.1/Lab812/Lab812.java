/**
 * Primary java class: Lab812
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define a 3x5 two-dimensional integer
 * array using initializer lists to provide beginning values. Define code to
 * output all original elements, and then change any four of the elements to a
 * different value, making the new values all negative, and then output all the
 * elements again. Output a blank line between the two output sets. Use the code
 * provided to help get you started.
 *
 */
public class Lab812 {
  public static void main(String... args) {
    int[][] nums = {{1, 2, 3, 4, 5}, {5, 7, 8, 9, 10}, {6, 7, 8, 9, 10}};
    for (int[] row : nums)
      for (int i : row)
        System.out.println(i);
    System.out.println();
    nums[0][1] = -10;
    nums[2][1] = -30;
    nums[1][2] = -2;
    nums[2][2] = -4;
    for (int[] row : nums)
      for (int i : row)
        System.out.println(i);
  }
}
