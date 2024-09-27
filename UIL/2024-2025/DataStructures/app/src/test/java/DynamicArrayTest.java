import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * DynamicArrayTest
 */
class DynamicArrayTest {

  @Test
  public void toStringTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    da.add("World");
    assertEquals(da.toString(), "[Hello, World]");
  }

  @Test
  public void removeTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    assertEquals("[Hello]", da.toString());
    da.remove(0);
    assertEquals("[]", da.toString());
  }

  @Test
  public void getTest() {
    DynamicArray<String> da = new DynamicArray<>();
    da.add("Hello");
    assertEquals("Hello", da.get(0));
  }

}
