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

  //A void no-parameter method M (or whatever name you prefer), like the ring method from the Bell class
  //A overloaded M method, with at least one parameter, like ring(int N) from the Bell class
  public void drive() {
    System.out.printf("A %s car with %d wheels drives by.\n", color, wheels);
  }

  public void drive(int speed) {
    System.out.printf("A %s car with %d wheels drives by at a speed of %d mph.\n", color, wheels, speed);
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
    return "Truck, tailgateLength=" + tailgateLength + ", " + super.toString().substring("Car, ".length());
  }

  //An overridden version of the M method inherited from yourSuperClass
  public void drive() {
    System.out.printf("A %s truck with %d wheels and a tailgate %d feet long drives by.\n", color, wheels,
        tailgateLength);
  }

  public void drive(int speed) {
    System.out.printf("A %s truck with %d wheels and a tailgate %d feet long drives by at a speed of %d mph.\n", color,
        wheels, tailgateLength, speed);
  }

  //An original void method Q (or whatever name you prefer) of your own design, unique to yourSubClass, like the play method from the Bell class
  public void party() {
    System.out.printf("have a party on the %d foot tailgate.\n", tailgateLength);
  }

}

class Main {
  public static void main(String... args) {
    //declare a super class object using actual parameters
    Car car = new Car("Red", 16);
    //declare a sub class object using actual parameters
    Truck truck = new Truck("Red", 16, 20);
    //output both objects
    System.out.println(car);
    System.out.println(truck);
    //call the no-parameter M method using the superclass object
    car.drive();
    //call the overloaded parameterized M method using the superclass object
    car.drive(10_000);
    //call the no-parameter overridden M method using the subclass object
    truck.drive();
    //call the overloaded and inherited parameterized M method using the subclass object
    truck.drive(10_000);
    //call the no-parameter Q method using the subclass object
    truck.party();
  }
}
