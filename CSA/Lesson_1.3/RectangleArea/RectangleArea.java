/**
 * public class RectangleArea
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/21/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: print the area of a rectangle with length = 14 and width =
 * 6. Declare three int type variables named length, width and area. Initialize
 * length to 14 and width to 6. Use length and width to calculate the area and
 * then assign that value to the variable named area. Print the value stored in
 * area and label the output as "Area = ".
 * 
 */
public class RectangleArea {
  public static void main(String... args) {
    int length = 14;
    int width = 6;
    int area = length * width;
    System.out.println("Area = " + area);
  }
}
