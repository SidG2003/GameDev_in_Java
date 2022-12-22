package screens;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

//junit Test class for class HelperFunc which has handy helper functions
public class TestClass {
    @Test
    public void testSum() {
        HelperFunc hp1 = new HelperFunc(2, 3);
        int ans = hp1.sum();
        assertEquals(5, ans);
    }

    @Test
    public void testDiff() {
        HelperFunc hp2 = new HelperFunc(2, 3);
        int ans = hp2.difference();
        assertEquals(-1, ans);
    }

    @Test
    public void testMult() {
        HelperFunc hp3 = new HelperFunc(2, 3);
        int ans = hp3.multiply();
        assertEquals(6, ans);
    }
    @Test
    public void testDiv() {
        HelperFunc hp3 = new HelperFunc(2, 2);
        int ans = hp3.divide();
        assertEquals(1, ans);
    }
}
