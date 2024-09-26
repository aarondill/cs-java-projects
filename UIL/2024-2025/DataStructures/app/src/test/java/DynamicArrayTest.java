import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import structs.DynamicArray;

/**
 * DynamicArrayTest
 */
public class DynamicArrayTest {

  @Test
  public static void toStringTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    da.add("World");
    assertEquals(da.toString(), "[Hello, World]");
  }

  @Test
  public static void removeTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    assertEquals("[Hello]", da.toString());
    da.remove(0);
    assertEquals("[]", da.toString());
  }

  @Test
  public static void getTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    assertEquals("Hello", da.get(0));
  }

}
