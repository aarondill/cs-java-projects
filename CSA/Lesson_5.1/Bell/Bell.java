class Bell {
  public static void main(String... args) {
    Bell tinker = new Bell();
    System.out.println(tinker);
    Bell cow = new Bell("clank", 1);
    System.out.println(cow);
  }

  // Instance variables
  String sound;
  int duration;

  //two-parameter constructor
  public Bell(String sound, int duration) {
    this.sound = sound;
    this.duration = duration;
  }

  //default constructor
  Bell() {
    sound = "ding";
    duration = 5;
  }

  //toString method
  public String toString() {
    return "This is a Bell." + "\nIt sounds like this: " + sound + "\nand lasts for " + duration + " seconds.";
  }

}
