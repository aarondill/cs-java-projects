/**
 * Primary java class: DotRacer
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: DotRacer guided lab
 *
 */

public class DotRacer {
  private static int racerCount;

  public static int getRacerCount() {
    return racerCount;
  }

  private int position;
  private int stepSize;
  private String name;

  public DotRacer() {
    position = 0;
    stepSize = 1;
    racerCount++;
    name = "Racer #" + racerCount;
  }

  public DotRacer(int initPosition, int initSize) {
    position = initPosition;
    stepSize = initSize;
    racerCount++;
    name = "Racer #" + racerCount;
  }

  public int getPosition() {
    return position;
  }

  public int getStepSize() {
    return stepSize;
  }

  public void move() {
    int numSteps = (int) (Math.random() * 11) - 5;
    position += numSteps * stepSize;
  }

  public void setStepSize(int size) {
    stepSize = size;
  }

  public String toString() {
    return name + " is at position: " + position;
  }
}
