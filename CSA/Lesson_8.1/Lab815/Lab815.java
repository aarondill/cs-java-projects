/**
 * Primary java class: Lab815
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    03/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to define an initially empty 2D array of
 * String values, with 4 elements in each of 3 rows, outputting the elements of
 * the empty array, all null values, and then changing half the values to be
 * foods you like, and the other half foods you don't like, and finally
 * outputting them again.
 *
 * Output a blank line between the two output sets. Use the code provided to
 * help get you started.
 *
 */
public class Lab815 {
  public static void main(String... args) {
    //code to define an initially empty String 2D array
    String[][] foods = new String[4][3];
    //code to output all original values
    System.out.println(foods[0][0]);
    System.out.println(foods[0][1]);
    System.out.println(foods[0][2]);
    System.out.println(foods[1][0]);
    System.out.println(foods[1][1]);
    System.out.println(foods[1][2]);
    System.out.println(foods[2][0]);
    System.out.println(foods[2][1]);
    System.out.println(foods[2][2]);
    System.out.println(foods[3][0]);
    System.out.println(foods[3][1]);
    System.out.println(foods[3][2]);

    //code to change half the values to foods you like
    //and the other half to foods you don't like
    //foods I like
    foods[0][0] = "lasagna";
    foods[0][1] = "pizza";
    foods[0][2] = "hamburger";
    foods[1][0] = "spaghetti";
    foods[1][1] = "pasta";
    foods[1][2] = "chicken";

    //foods I don't like
    foods[2][0] = "brussel sprouts";
    foods[2][1] = "pork";
    foods[2][2] = "mustard";
    foods[3][0] = "coleslaw";
    foods[3][1] = "cooked spinach";
    foods[3][2] = "black licorice";

    //code to output a blank line separating output sets
    System.out.println();
    //code to output all array elements
    System.out.println(foods[0][0]);
    System.out.println(foods[0][1]);
    System.out.println(foods[0][2]);
    System.out.println(foods[1][0]);
    System.out.println(foods[1][1]);
    System.out.println(foods[1][2]);
    System.out.println(foods[2][0]);
    System.out.println(foods[2][1]);
    System.out.println(foods[2][2]);
    System.out.println(foods[3][0]);
    System.out.println(foods[3][1]);
    System.out.println(foods[3][2]);
  }
}
