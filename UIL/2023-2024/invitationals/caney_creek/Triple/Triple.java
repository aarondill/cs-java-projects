import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Triple {
  public static void main(String... args) throws IOException {
    Files.lines(Path.of("./triple.dat")).map(Integer::parseInt).map(x -> x * 3).forEach(System.out::println);;
  }
}
