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

  public Car(String color, int wheels) {
    this.color = color;
    this.wheels = wheels;
  }

  @Override
  public String toString() {
    return "Car, color=" + color + ", wheels=" + wheels;
  }
}

class Truck extends Car {
  /** Length of the tailgate in feet */
  int tailgateLength = 10;

  public Truck() {}

  public Truck(String color, int wheels, int tailgateLength) {
    super(color, wheels);
    this.tailgateLength = tailgateLength;
  }

  @Override
  public String toString() {
    return super.toString() + ", tailgateLength=" + tailgateLength;
  }

}

class Main {
  public static void main(String... args) {
    Car car = new Car();
    Car car2 = new Car("Red", 16);
    Truck truck = new Truck();
    Truck truck2 = new Truck("Red", 16, 20);
    System.out.println(car);
    System.out.println(car2);
    System.out.println(truck);
    System.out.println(truck2);
  }
}
