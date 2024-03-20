/**
 * Primary java class: Lab814
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define an initially empty 2D array of
 * double values, with 3 rows and 3 elements in each row, outputting the
 * elements of the empty array, all 0.0 values, and then changing five of them
 * to positive values and the other four to negative values, and finally
 * outputting them again.
 *
 * Output a blank line between the two output sets. Use the code provided to
 * help get you started.
 *
 * Note: Do Not Use Traversals to Output the Elements of the 2D Array
 *
 */
public class Lab814 {
  public static void main(String... args) {
    //code to define an initially empty double 2D array size 3x3 double [][] list = new double[3][3];
    double[][] list = new double[3][3];
    //code to output all original values
    System.out.println(list[0][0]);
    System.out.println(list[0][1]);
    System.out.println(list[0][2]);
    System.out.println(list[1][0]);
    System.out.println(list[1][1]);
    System.out.println(list[1][2]);
    System.out.println(list[2][0]);
    System.out.println(list[2][1]);
    System.out.println(list[2][2]);
    //code to change five of the values to positive and the other four to negtive
    list[0][0] = 1.0;
    list[0][1] = 2.0;
    list[0][2] = 3.0;
    list[1][0] = 4.0;
    list[1][1] = 5.0;
    list[1][2] = -6.0;
    list[2][0] = -7.0;
    list[2][1] = -8.0;
    list[2][2] = -9.0;
    //code to output a blank line separating output sets
    System.out.println();
    //code to output all changed values
    System.out.println(list[0][0]);
    System.out.println(list[0][1]);
    System.out.println(list[0][2]);
    System.out.println(list[1][0]);
    System.out.println(list[1][1]);
    System.out.println(list[1][2]);
    System.out.println(list[2][0]);
    System.out.println(list[2][1]);
    System.out.println(list[2][2]);
  }
}
