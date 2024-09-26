import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structs.BinTree;

class BinTreeTest {
  BinTree<Integer> tree = new BinTree<>();

  @BeforeEach
  void init() {
    tree.clear();
    int[] nums = {7, 2, 4, 6, 5, 1, 3, 9, 10, 8, 0};
    for (int i : nums)
      tree.insert(i);
  }

  @Test
  void testInsertDuplicate() {
    tree.insert(7);
    assertEquals(tree.toString(), "(7){(2){(1){(0)},(4){(3),(6){(5)}}},(9){(8){(7)},(10)}}");
    assertTrue(tree.contains(7));
    tree.remove(7);
    assertTrue(tree.contains(7));
    tree.remove(7);
    assertFalse(tree.contains(7));
  }

  @Test
  void testContains() {
    for (int i = 0; i < 10; i++)
      assertTrue(tree.contains(i), "Should contain " + i);
    assertFalse(tree.contains(-1));
    assertFalse(tree.contains(11));
  }

  @Test
  void testRemove() {
    for (int i = 0; i < 10; i++) {
      tree.remove(i);
      for (int j = 0; j < i; j++)
        assertFalse(tree.contains(j));
      for (int j = i + 1; j < 10; j++)
        assertTrue(tree.contains(j));
    }
  }

  @Test
  void testToString() {
    // This should be stable
    String exp = "(7){(2){(1){(0)},(4){(3),(6){(5)}}},(9){(8),(10)}}";
    assertEquals(exp, tree.toString());
  }
}
