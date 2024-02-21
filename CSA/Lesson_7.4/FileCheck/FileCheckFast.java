import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCheckFast {
  public static void main(String... args) {
    Path file1 = Path.of("time1.txt");
    Path file2 = Path.of("time2.txt");
    boolean filesMatch;
    try {
      filesMatch = Files.mismatch(file1, file2) == -1L;
    } catch (IOException e) {
      System.err.println("Something went terribly wrong! Message: " + e.getMessage());
      System.exit(1);
      return;
    }
    if (filesMatch) System.out.println("The files are an exact match.");
    else System.out.println("The files do not match.");
  }
}
