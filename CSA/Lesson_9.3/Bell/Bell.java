public class Bell {
  private String sound;
  private int duration;
  private boolean hasClapper;

  public Bell() {
    System.out.println("Bell default constructor calls parent toString method.");
    System.out.println("\t" + super.toString());
    //assign default values to private instance fields
    sound = "ring";
    duration = 3;
    hasClapper = true;
    System.out.println("Bell default constructor calls its own toString method.");
    System.out.println("\t" + this);
  }

  public Bell(String s, int d, boolean c) {
    this.sound = s;
    this.duration = d;
    this.hasClapper = c;
  }

  public void ring() {
    System.out.println("^" + duration  + " " + sound.repeat(duration ));
  }

  public void ring(int n) {
    System.out.println("#" + (n * duration) + " " + sound.repeat(n * duration));
  }

  public String toString() {
    String c = hasClapper ? "a" : "no";
    return "Bell, sounds \"" + sound + "\" for " + duration + " seconds, has " + c + " clapper.";
  }
}

class PitchedBell extends Bell {
  String pitch;

  public PitchedBell() {
    super();
    pitch = "C";
  }

  public PitchedBell(String s, int d, boolean c, String p) {
    super(s, d, c);
    this.pitch = p;
  }

  @Override
  public void ring() {
    System.out.print("Pitch of " + pitch + ": ");
    super.ring();
  }

  public void play() {
    System.out.println("Play the note " + pitch);
  }

  public String toString() {
    return "PitchedBell, " + pitch + ", " + super.toString();
  }
}

class Main {
  public static void main(String... args) {
    Bell belle = new Bell("ding", 4, false);
    PitchedBell tom = new PitchedBell("bong", 2, true, "F#");
    System.out.println(belle);
    belle.ring();
    belle.ring(4);
    System.out.println(tom);
    tom.ring();
    tom.ring(3);
    tom.play();
  }
}
