/**
 * Primary java class: Lab813
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define a 4x2 two-dimensional double array
 * using initializer lists to provide beginning values.
 *
 * Define an variable for the array. Define code to output all original
 * elements, and then change any five of the elements to a different value,
 * making the new values all negative, and then output all the elements again.
 *
 * Output a blank line between the two output sets. Use the code provided to
 * help get you started.
 *
 * Note: Do Not Use Traversals to Output the Elements of the 2D Array
 */
public class Lab813 {
  public static void main(String... args) {
    //code to define a double 2D array size 4x2 with //initializer lists
    double[][] array = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}, {7.0, 8.0}};
    //code to output all original values
    System.out.println(array[0][0]);
    System.out.println(array[0][1]);
    System.out.println(array[1][0]);
    System.out.println(array[1][1]);
    System.out.println(array[2][0]);
    System.out.println(array[2][1]);
    System.out.println(array[3][0]);
    System.out.println(array[3][1]);

    //code to change five elements to be negative values
    array[1][0] = -array[1][0];
    array[1][1] = -array[1][1];
    array[2][0] = -array[2][0];
    array[2][1] = -array[2][1];
    array[3][0] = -array[3][0];
    //code to output a blank line separating output sets
    System.out.println();
    //code to output all array elements
    System.out.println(array[0][0]);
    System.out.println(array[0][1]);
    System.out.println(array[1][0]);
    System.out.println(array[1][1]);
    System.out.println(array[2][0]);
    System.out.println(array[2][1]);
    System.out.println(array[3][0]);
    System.out.println(array[3][1]);
  }
}
