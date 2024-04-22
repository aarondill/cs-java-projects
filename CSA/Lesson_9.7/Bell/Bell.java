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
    System.out.println("^" + duration + " " + sound.repeat(duration));
  }

  public void ring(int n) {
    System.out.println("#" + (n * duration) + " " + sound.repeat(n * duration));
  }

  public String toString() {
    String c = hasClapper ? "a" : "no";
    return "Bell, sounds \"" + sound + "\" for " + duration + " seconds, has " + c + " clapper.";
  }

  public boolean equals(Object other) {
    if (other == null) return false;
    if (this.getClass() != other.getClass()) return false;
    if (this.sound != ((Bell) other).sound) return false;
    if (this.duration != ((Bell) other).duration) return false;
    if (this.hasClapper != ((Bell) other).hasClapper) return false;
    return true;
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

  // PitchedBell equals method override
  public boolean equals(Object other) {
    if (!super.equals(other)) return false;
    if (this.pitch != ((PitchedBell) other).pitch) return false;
    return true;
  }
}

class Main {
  public static void main(String... args) {
    Bell belle = new Bell("ding", 3, false);
    Bell jill = new Bell("ding", 3, true);
    Object tom = new Bell("ding", 2, true);
    System.out.println(belle.equals(jill));
    System.out.println(belle.equals(tom));
  }
}
