/**
 * Primary java class: Truck
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Truck {
  private String truckID; // represents an identification number for each vehicle object.
  private double odometer; // represents the mileage on the odometer at any point in time.
  private double mpg; // stores the miles per gallon that this particular vehicle gets.
  private double fuel; // shows the amount of fuel in the tank at any given time.
  private final double CAPACITY = 20.0; // represents the capacity of the fuel tank and set the value to 20.0.
  private static double totalFuel = 0; // This variable will be used to keep track of the amount of fuel pumped (not used) into all of the trucks.

  public Truck(String truckID) {
    this.truckID = truckID;
  }

  public String getTruckID() {
    return truckID;
  }

  public double getOdometer() {
    return odometer;
  }

  public double getMpg() {
    return mpg;
  }

  public double getFuel() {
    return fuel;
  }

  public double getCAPACITY() {
    return CAPACITY;
  }

  public static double getTotalFuel() {
    return totalFuel;
  }

  public void setMpg(double mpg) {
    this.mpg = mpg;
  }

  public void drive(double miles) {
    if (!enoughFuel(miles)) {
      System.err.println("Truck " + truckID + " does not have enough fuel to drive " + miles + " miles.");
      System.err.println();
      return;
    }
    fuel -= miles / mpg;
    odometer += miles;
  }

  public boolean enoughFuel(double miles) {
    double milesCanGo = fuel * mpg;
    return milesCanGo >= miles;
  }

  public void fill() {
    totalFuel += CAPACITY - fuel;
    fuel = CAPACITY;
  }

  public void fill(double gallons) {
    if (fuel + gallons > CAPACITY) {
      System.err.println("Truck " + truckID + ": Gallons exceeds tank capacity.");
      System.err.println();
      return;
    }
    fuel += gallons;
    totalFuel += gallons;
  }

  public Truck(String truckID, double odometer, double mpg, double fuel) {
    this.truckID = truckID;
    this.odometer = odometer;
    this.mpg = mpg;
    this.fuel = fuel;
  }

  @Override
  public String toString() {
    // two empty lines for some reason?
    return String.join("\n", "Truck: " + truckID, "Odometer: " + odometer, "Miles Per Gallon: " + mpg, "Fuel: " + fuel,
        "");
  }
}
