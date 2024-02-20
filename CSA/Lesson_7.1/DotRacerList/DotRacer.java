public class DotRacer {
  private int position;
  private final int STEPSIZE = 1;
  private String name;

  public DotRacer(String name) {
    position = 0;
    this.name = name;
  }

  public DotRacer() {
    position = 0;
  }

  public int getPosition() {
    return position;
  }

  public int getStepSize() {
    return STEPSIZE;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void move() {
    int numSteps = (int) (Math.random() * 11);
    position += numSteps * STEPSIZE;
  }

  public String toString() {
    return name + " is at position: " + position;
  }
}
