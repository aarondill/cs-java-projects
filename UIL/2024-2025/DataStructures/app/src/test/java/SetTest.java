import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import Set.EfficientSet;
import Set.Set;
import Set.SetInterface;

class SetTest {
  @ParameterizedTest
  @ValueSource(classes = {Set.class, EfficientSet.class})
  void test(Class<? extends SetInterface<String>> c) {
    SetInterface<String> s;
    try {
      s = c.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    s.add("Hello");
    s.add("World");
    s.add("Hello");
    assertEquals(s.size(), 2);
    assertTrue(s.has("Hello"));
    assertTrue(s.has("World"));
    assertFalse(s.has("Foo"));
  }
}
