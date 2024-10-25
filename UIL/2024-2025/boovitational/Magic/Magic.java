import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Magic {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "magic.dat";

  private static String parse(String content) {
    String res = "";
    for (String c : content.trim().split(" ")) {
      res += (char) Integer.parseInt(c, 16);
    }
    return res;
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String content = scan.nextLine();
    String unsafeExtension = null;

    if (content.startsWith("ED AB EE DB")) {
      unsafeExtension = "rpm";
      content = content.substring("ED AB EE DB".length());
    } else if (content.startsWith("4D 5A")) {
      unsafeExtension = "exe";
      content = content.substring("4D 5A".length());
    } else if (content.startsWith("25 50 44 46 2D")) {
      unsafeExtension = "pdf";
      content = content.substring("25 50 44 46 2D".length());
    } else if (content.startsWith("23 40 7E 5E")) {
      unsafeExtension = "vbs";
      content = content.substring("23 40 7E 5E".length());
    } else if (content.startsWith("CA FE BA BE")) {
      unsafeExtension = "class";
      content = content.substring("CA FE BA BE".length());
    } else if (content.startsWith("7F 45 4C 46")) {
      unsafeExtension = "elf";
      content = content.substring("7F 45 4C 46".length());
    } else if (content.startsWith("42 43")) {
      unsafeExtension = "bc";
      content = content.substring("42 43".length());
    } else if (content.startsWith("D0 CF 11 E0 A1 B1 1A E1")) {
      unsafeExtension = "msi";
      content = content.substring("D0 CF 11 E0 A1 B1 1A E1".length());
    }

    if (unsafeExtension == null) {
      System.out.println(parse(content));
    } else {
      System.out.print("BAD_");
      System.out.print(parse(content));
      System.out.println("." + unsafeExtension);

    }

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
