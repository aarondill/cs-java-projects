public class {{ $ROOT }} {
  final static public String VERSION = version();

  /** Get the program version on startup. */
  private static String version() {
    Properties p = new Properties();
    try (Reader r =
        new InputStreamReader(MethodHandles.lookup().lookupClass().getResourceAsStream("/version.properties"))) {
      p.load(r);
    } catch (IOException e) {
      System.err.println("Error reading version.properties");
      e.printStackTrace();
    }
    return p.getProperty("version");
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
