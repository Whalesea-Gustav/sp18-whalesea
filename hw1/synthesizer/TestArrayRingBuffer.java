package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(2);
        arb.enqueue(10);
        arb.enqueue(20);
        assertEquals((Integer) 10, arb.deque());
        assertEquals((Integer) 20, arb.deque());
        assertEquals(0, arb.fillCount());
        arb.enqueue(10);
        arb.enqueue(20);
        for (Integer i : arb) {
            assertTrue(i == 10 || i == 20);
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(2);
        arb.enqueue(10);
        arb.enqueue(20);
        for (Integer i : arb) {
            System.out.println(i);
        }

    }
}
