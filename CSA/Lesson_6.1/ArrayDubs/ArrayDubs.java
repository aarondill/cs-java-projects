/**
 * Primary java class: ArrayDubs
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/26/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to instantiate an array of doubles called
 * grades to hold nine values.
 * 
 * Write three statements to output the values in the first, middle, and last
 * positions.
 * 
 * Reassign the values in those same positions to grades you have recently
 * earned in this class.
 * 
 * Create an output statement containing an expression to output the average of
 * those three grades you just entered using the indexing process.
 */
public class ArrayDubs {
  public static void main(String... args) {
    final double[] grades = {3.307045511396356, 81.65346637510136, 4.8940162160074685, 10.112890807208807,
        8.833730405887197, 76.88709253751371, 23.290656965097376, 73.51492957563678, 74.97127318057639};
    final int middle = grades.length / 2, last = grades.length - 1;
    System.out.println(grades[0]); // first
    System.out.println(grades[middle]); // "middle"
    System.out.println(grades[last]); // last
    grades[0] = 23.8536323087289;
    grades[middle] = 47.25629607075674;
    grades[last] = 21.66169223442276;
    System.out.println((grades[0] + grades[middle] + grades[last]) / 3.0);
  }
}
