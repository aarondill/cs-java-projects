/**
 * Primary java class: Lab816
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define an initially empty 2D array of
 * integer values, 5x5, outputting the elements of changing half the values o
 * positive even numbers and the other half negative odd numbers.
 *
 *
 * Output a blank line between the two output sets. Use the code provided to
 * help get you started.
 *
 * Note: Do Not Use Traversals to Output the Elements of the 2D Array
 */
public class Lab816 {
  public static void main(String... args) {
    //code to define an initially empty int 2D array
    int[][] array = new int[5][5];
    //code to output all original values
    System.out.println(array[0][0]);
    System.out.println(array[0][1]);
    System.out.println(array[0][2]);
    System.out.println(array[0][3]);
    System.out.println(array[0][4]);
    System.out.println(array[1][0]);
    System.out.println(array[1][1]);
    System.out.println(array[1][2]);
    System.out.println(array[1][3]);
    System.out.println(array[1][4]);
    System.out.println(array[2][0]);
    System.out.println(array[2][1]);
    System.out.println(array[2][2]);
    System.out.println(array[2][3]);
    System.out.println(array[2][4]);
    System.out.println(array[3][0]);
    System.out.println(array[3][1]);
    System.out.println(array[3][2]);
    System.out.println(array[3][3]);
    System.out.println(array[3][4]);
    System.out.println(array[4][0]);
    System.out.println(array[4][1]);
    System.out.println(array[4][2]);
    System.out.println(array[4][3]);
    System.out.println(array[4][4]);
    //code to change half the values to even positive numbers
    array[0][0] = 2;
    array[0][1] = 4;
    array[0][2] = 6;
    array[0][3] = 8;
    array[0][4] = 10;
    array[1][0] = 12;
    array[1][1] = 14;
    array[1][2] = 16;
    array[1][3] = 18;
    array[1][4] = 20;
    array[2][0] = 22;
    array[2][1] = 24;
    array[2][2] = 26;
    //and the other half to negative odd numbers
    array[2][3] = -1;
    array[2][4] = -3;
    array[3][0] = -5;
    array[3][1] = -7;
    array[3][2] = -9;
    array[3][3] = -11;
    array[3][4] = -13;
    array[4][0] = -15;
    array[4][1] = -17;
    array[4][2] = -19;
    array[4][3] = -21;
    array[4][4] = -23;
    //code to output a blank line separating output sets
    System.out.println();
    //code to output all array elements
    System.out.println(array[0][0]);
    System.out.println(array[0][1]);
    System.out.println(array[0][2]);
    System.out.println(array[0][3]);
    System.out.println(array[0][4]);
    System.out.println(array[1][0]);
    System.out.println(array[1][1]);
    System.out.println(array[1][2]);
    System.out.println(array[1][3]);
    System.out.println(array[1][4]);
    System.out.println(array[2][0]);
    System.out.println(array[2][1]);
    System.out.println(array[2][2]);
    System.out.println(array[2][3]);
    System.out.println(array[2][4]);
    System.out.println(array[3][0]);
    System.out.println(array[3][1]);
    System.out.println(array[3][2]);
    System.out.println(array[3][3]);
    System.out.println(array[3][4]);
    System.out.println(array[4][0]);
    System.out.println(array[4][1]);
    System.out.println(array[4][2]);
    System.out.println(array[4][3]);
    System.out.println(array[4][4]);
  }
}
