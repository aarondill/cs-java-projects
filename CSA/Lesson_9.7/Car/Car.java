import java.util.ArrayList;

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
  double weight = 1000.0;

  public Car() {}

  public Car(String color, int wheels, double weight) {
    this.color = color;
    this.wheels = wheels;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Car, color=" + color + ", wheels=" + wheels + ", weight=" + weight;
  }

  //A void no-parameter method M (or whatever name you prefer), like the ring method from the Bell class
  //A overloaded M method, with at least one parameter, like ring(int N) from the Bell class
  public void drive() {
    System.out.printf("A %s car with %d wheels drives by.\n", color, wheels);
  }

  public void drive(int speed) {
    System.out.printf("A %s car with %d wheels drives by at a speed of %d mph.\n", color, wheels, speed);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Car other = (Car) obj;
    if (color == null) {
      if (other.color != null) return false;
    } else if (!color.equals(other.color)) return false;
    if (wheels != other.wheels) return false;
    if (weight != other.weight) return false;
    return true;
  }

}

class Truck extends Car {
  /** Length of the tailgate in feet */
  int tailgateLength = 10;

  public Truck() {}

  public Truck(String color, int wheels, double weight, int tailgateLength) {
    super(color, wheels, weight);
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Truck other = (Truck) obj;
    if (tailgateLength != other.tailgateLength) return false;
    return true;
  }

}

class Main {

  public static void main(String... args) {
    Car A = new Car("blue", 4, 5000);
    Car B = new Car("blue", 4, 5000);
    Car C = new Car("purple", 6, 1000);
    Truck D = new Truck("red", 4, 3000, 10);
    Truck E = new Truck("red", 4, 3000, 10);
    Truck F = new Truck("blue", 6, 1000, 0);

    System.out.println(A.equals(B));
    System.out.println(A.equals(C));
    System.out.println(D.equals(F));
    System.out.println(E.equals(D));
    System.out.println(A.equals(D));
    System.out.println(F.equals(B));
  }
}
