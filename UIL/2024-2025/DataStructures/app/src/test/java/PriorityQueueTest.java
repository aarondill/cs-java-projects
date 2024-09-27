import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {
  @Test
  public void test() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i : new int[] {2, 1, 3, 9, 5})
      pq.add(i);
    assertEquals(pq.remove(), 1);
  }

  @Test
  public void toStringTest() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i : new int[] {2, 1, 3, 9, 5})
      pq.add(i);
    assertEquals(pq.toString(), "[1, 2, 3, 5, 9]");
  }
}
