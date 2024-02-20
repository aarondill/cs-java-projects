/**
 * DotRacer
 * 
 * Author1: Aaron Dill Date: 1/22/20204 Course: CSA Period: 3rd
 *
 * Summary of file: A DotRacer.
 * 
 *
 */
public class DotRacer {
  private int position;
  private final int STEP_SIZE = 1;
  private String name;

  public DotRacer(int position) {
    this.position = position;
  }

  public DotRacer(String name) {
    this.position = 0;
    this.name = name;
  }

  public DotRacer() {
    position = 0;
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    int numSteps = (int) (Math.random() * 11);
    position += numSteps * STEP_SIZE;
  }

  public String getName() {
    return name;
  }

  public void setName(String n) {
    name = n;
  }

  public int getSTEP_SIZE() {
    return STEP_SIZE;
  }

  public String toString() {
    return name + " is at position: " + position;
  }
}
