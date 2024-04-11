/**
 * Primary java class: Car
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    04/11/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: implement a Car and Truck for class demonstration
 */
public class Car {
  String color = "Black";
  int wheels = 4;

  public Car() {}

  @Override
  public String toString() {
    return "Car [color=" + color + ", wheels=" + wheels + "]";
  }
}

class Truck extends Car {}

class Main {
  public static void main(String... args) {
    Car car = new Car();
    System.out.println(car);
    Truck truck = new Truck();
    System.out.println(truck);
  }
}
