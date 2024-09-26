import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import structs.Stack;

/**
 * StackTest
 */
public class StackTest {

  @Test
  static void test() {
    Stack<Integer> st = new Stack<>();
    st.push(1);
    st.push(2);
    assertEquals(st.size(), 2);
    assertEquals(st.pop(), 2);
    assertEquals(st.pop(), 1);
    assertEquals(st.size(), 0);
  }

  @Test
  static void toStringTest() {
    Stack<Integer> st = new Stack<>();
    st.push(1);
    st.push(2);
    assertEquals(st.toString(), "[1, 2]");
  }
}
