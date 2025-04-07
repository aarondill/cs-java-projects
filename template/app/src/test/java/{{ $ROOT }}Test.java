import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class {{ $ROOT }}Test {
  @Test
  void version() throws IOException {
    Properties properties = new Properties();
    try(Reader gradelProperties = new InputStreamReader(getClass().getResourceAsStream("/version.properties"))){
      properties.load(gradelProperties);
    }
    assertTrue(properties.getProperty("version").equals({{ $ROOT }}.VERSION));
  }
  @Test
  void test() {
    System.out.println("NOTE: There is no test for this app yet!");
    assertTrue(true);
  }
}
