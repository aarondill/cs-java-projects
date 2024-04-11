public class Bell {
  private String sound;
  private int duration;
  private boolean hasClapper;

  public Bell() {
    sound = "ring";
    duration = 3;
    hasClapper = true;
  }

  public String toString() {
    String c = hasClapper ? "a" : "no";
    return "Bell, sounds \"" + sound + "\" for " + duration + " seconds, has " + c + " clapper.";
  }
}

class PitchedBell extends Bell {}

class Main {
  public static void main(String... args) {
    Bell belle = new Bell();
    System.out.println(belle);
    PitchedBell tom = new PitchedBell();
    System.out.println(tom);
  }
}
