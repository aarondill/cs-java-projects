import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LinkedListTest {
  @Test
  void test() {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++)
      list.add(i);
    assertEquals(10, list.size());
    assertTrue(list.contains(5));
    for (int i = 0; i < 10; i++)
      assertEquals(i, list.get(i));
    assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
    for (int i = 9; i >= 0; i--)
      assertTrue(list.remove(i));
    assertEquals(0, list.size());
    assertEquals("[]", list.toString());
  }
}
