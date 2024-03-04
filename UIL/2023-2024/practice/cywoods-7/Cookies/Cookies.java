import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ingredient {
  String unit;
  String name;
  double quantity;

  public Ingredient(String name, double quantity, String unit) {
    this.unit = unit;
    this.name = name;
    this.quantity = quantity;
  }

  public Ingredient(String name, double quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  // Note: will attempt to pluralize the unit, but only by adding an 's'
  public String calculate(int order) {
    double unitQuanity = this.quantity * order;
    String unit = this.unit, name = this.name;
    if (unit == null) {
      if (unitQuanity > 1) name += "s"; // pluralize name, since no unit
      if (unitQuanity % 1 == 0) return String.format("%.0f %s", unitQuanity, name);
      else return String.format("%.2f %s", unitQuanity, name);
    } else {
      if (unitQuanity > 1) unit += "s"; // pluralize unit
      if (unitQuanity % 1 == 0) return String.format("%.0f %s of %s", unitQuanity, unit, name);
      else return String.format("%.2f %s of %s", unitQuanity, unit, name);
    }
  }
}

public class Cookies {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "cookies.dat";
  private static List<Ingredient> Receipe = new ArrayList<>();
  static {
    Receipe.add(new Ingredient("flour", 2, "cup"));
    Receipe.add(new Ingredient("butter", .75, "cup")); // NOTE: The packet says .25, but uses .75
    Receipe.add(new Ingredient("baking soda", 1.5, "teaspoon"));
    Receipe.add(new Ingredient("sugar", 3, "cup"));
    Receipe.add(new Ingredient("royal icing", .5, "cup"));
    Receipe.add(new Ingredient("egg", 1));
  }
  private static final String[] BANNED = {"SHRANK", "FRAEDER"};

  private static boolean unsortedEquals(String a, String b) {
    return b.chars().sorted().boxed().toList().equals(a.chars().sorted().boxed().toList());
  }

  private static void each(String line) {
    // Parse the input:
    Matcher m = Pattern.compile("(\\d+) orders of cookies for (.+)").matcher(line);
    if (!m.matches()) throw new IllegalArgumentException("Invalid line: " + line);
    int orders = Integer.parseInt(m.group(1));
    String name = m.group(2);
    // Handle output:
    String fname = name.split(" ")[0].toUpperCase();
    String lname = name.split(" ")[1].toUpperCase();
    if (unsortedEquals(fname, BANNED[0]) && unsortedEquals(lname, BANNED[1])) {
      System.out.println("DO NOT SELL!!!");
    } else {
      System.out.println("Shopping list for " + name + "'s order:");
      for (Ingredient i : Receipe)
        System.out.println(i.calculate(orders));
    }
    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan.nextLine());
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
