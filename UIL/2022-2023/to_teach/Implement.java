public class Implement {
  private static interface Base {
    public void getString();
  }

  private static class Implementation implements Base {
    public void getString() {
      System.out.println("Implementation implemented getString()");
    };
  }

  private static class NewImplementation implements Base {
    public void getString() {
      System.out.println("NewImplementation implemented getString()");
    };

    public String getString(String a) {
      return "NewImplementation called getString(String a) with String: " + a;
    };
  }

  public static void main(String[] args) {
    new Implementation().getString();
    System.out.println();
    Base newImplementation = new NewImplementation();
    newImplementation.getString();
    // System.out.println(newImplementation.getString("hello"));
  }
}
