/**
 * Primary java class: ArrayInts
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/26/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class ArrayInts {
  public static void main(String... args) {
    // integer array declared and initialized
    int[] list = {4, 9, -3, 5, 2, 4, 0};
    // output first element
    System.out.println(list[0]);
    // output last element
    System.out.println(list[6]);
    // output the value 2
    System.out.println(list[4]);
    // output the element in position 3
    System.out.println(list[3]);
    // output length
    System.out.println(list.length);
    // Then change the initial values to be those of your own choice, and output different (or more) values than shown.
    list[0] = 14864;
    list[1] = 2806;
    list[2] = 6610;
    list[3] = 14718;
    list[4] = 25321;
    list[5] = 1316;
    list[6] = 15387;
    System.out.println(list[0]);
    System.out.println(list[1]);
    System.out.println(list[2]);
    // Finally, output the last element of the array using the length field.
    System.out.println(list[list.length - 1]);

  }
}
