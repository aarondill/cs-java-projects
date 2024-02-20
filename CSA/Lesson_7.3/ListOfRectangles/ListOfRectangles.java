import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Primary java class: ListOfRectangles
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/15/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Create a class named Rectangle with two type double instance
 * fields, length and width. The Rectangle class should have one constructor
 * that will accept and set the length and width of a rectangle. Include
 * appropriately named accessor methods for both these fields.
 * 
 * Define one additional method called area which will return the area of the
 * rectangle. This method MUST use the two accessor methods in its calculation.
 * 
 * Write a class named ListOfRectangles that will read the length and width of
 * various rectangles from a data file named rectangle.dat Download
 * rectangle.dat, instantiate Rectangle objects and place them into an
 * ArrayList. The length and width of each rectangle will be listed as two
 * decimal numbers where each pair is on a separate line.
 * 
 * AFTER reading the data, traverse the list to find the average area of the
 * rectangles in the list. You must use a while loop to traverse the list,
 * outputting each area value with each iteration and accumulating each area
 * value in a summation variable.
 * 
 * Calculate, round and output to 2 decimal places the average of all area
 * values. If rectangle.dat contains the following values:
 *
 * 
 */
public class ListOfRectangles {
  public static void main(String... args) {
    List<Rectangle> rects = new ArrayList<>();
    try (Scanner scan = new Scanner(ListOfRectangles.class.getResourceAsStream("./rectangle.dat"))) {
      scan.useDelimiter("\n").tokens().map(l -> l.split(" "))
          .map(sa -> Arrays.stream(sa).mapToDouble(Double::parseDouble).toArray())
          .map(sides -> new Rectangle((sides[0]), (sides[1]))).forEach(rects::add);
    }
    // double totalArea = rects.stream().map(Rectangle::area).mapToDouble(Double::doubleValue).sum();
    double totalArea = 0;
    int i = -1;
    while (++i < rects.size())
      totalArea += rects.get(i).area();
    double averageArea = (int) (totalArea / rects.size() * 100) / 100.0;
    System.out.println("Average area: " + averageArea);

  }
}
