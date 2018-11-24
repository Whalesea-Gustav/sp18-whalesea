
import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    OffByN cc = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertTrue(cc.equalChars('a', 'f'));
        assertTrue(cc.equalChars('b', 'g'));
        assertFalse(cc.equalChars('a', 'h'));
    }



}
