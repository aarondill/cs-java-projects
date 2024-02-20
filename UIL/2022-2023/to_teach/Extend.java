public class Extend {
  private static class Base {
    public void getString() {
      System.out.println("This outputs from Base");
    }

    Base() {
      System.out.println("Base constructor");
    }

    String s = "contents";

    Base(String s) {
      System.out.println("Base constructor: " + s);
    }
  }

  private static class Extension extends Base {
  }

  private static class Overridden extends Base {
    String s = "new contents";

    Overridden() {
      System.out.println("Overridden constructor");
      System.out.println(super.s);
    }

    @Override
    public void getString() {
      System.out.println("This outputs from Overridden");
    }
  }

  public static void main(String[] args) {
    // new Extension().getString();
    // System.out.println();
    new Overridden().getString();
  }
}
