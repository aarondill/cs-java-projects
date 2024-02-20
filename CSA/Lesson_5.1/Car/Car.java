/**
 * Primary java class: Car
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/30/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Using as a reference the Bell class case study viewed in the
 * video as a part of this lesson, define a class based on an object of your own
 * interest and choosing. It cannot be a Bell. It just needs to have two facts
 * to be represented as instance fields.
 * 
 */
public class Car {
  //two instance fields
  String color;
  int wheels;

  //default constructor
  // Note: This could be replaced with assigning default values to the variables.
  public Car() {
    color = "Black";
    wheels = 4;
  }

  //two-parameter constructor
  // Terrible variable names, but I'm not allowed to use `this.wheels`
  /**
   * @param c Color
   * @param w Number of wheels
   */
  public Car(String c, int w) {
    color = c;
    wheels = w;
  }

  //toString method
  public String toString() {
    return "Car [color=" + color + ", wheels=" + wheels + "]";
  }

  public static void main(String[] args) {
    //instantiate a default object and output it
    Car me1 = new Car();
    System.out.println(me1);
    //instantiate a two-parameter object and output it
    Car me2 = new Car("Blue", 18);
    System.out.println(me2);
  }
}
