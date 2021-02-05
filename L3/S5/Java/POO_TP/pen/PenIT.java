package pen;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PenIT {

    private Cartridge cart1;
    private Cartridge cart2;
    private Pen pen1;
    private Pen pen2;

    @Before
    public void setUp() {
        cart1 = new Cartridge(Color.red);
        cart2 = new Cartridge(Color.green);
        pen1 = new Pen();
        pen2 = new Pen("Waterman");
    }

    @Test
    public void testFreeCart() {
        pen1.freeCart();
        assertNull(pen1.getCartridge());
    }

    @Test
    public void testFreeCart2() {
        pen1.changeCartridge(cart1);
        pen1.freeCart();
        assertNull(pen1.getCartridge());
        assertNull(cart1.getPen());
    }

    @Test
    public void testChangeCartridge1() {
        pen1.changeCartridge(cart1);
        assertSame(pen1.getCartridge(), cart1);
        assertSame(cart1.getPen(), pen1);
    }

    @Test
    public void testChangeCartridge2() {
        pen1.changeCartridge(cart1);
        pen2.changeCartridge(cart2);

        pen1.changeCartridge(cart2);

        assertNull(pen2.getCartridge());
        assertNull(cart1.getPen());

    }

    @Test
    public void testChangeCartridge3() {
        pen1.changeCartridge(cart1);
        pen2.changeCartridge(cart2);

        pen1.changeCartridge(cart2);

        assertSame(pen1.getCartridge(), cart2);
        assertSame(cart2.getPen(), pen1);

    }

    @Test
    public void testWrite() {
        pen1.changeCartridge(cart1);
        int level = cart1.getLevel();

        while (level > 0) {
            assertSame(cart1.getLevel(), level);
            pen1.write("hello");
            level--;
        }

    }

    @Test
    public void testGetCartridge() {
        pen1.changeCartridge(cart1);
        assertSame(pen1.getCartridge(), cart1);

    }

    @Test
    public void testGetCartridge2() {
        pen1.changeCartridge(cart1);
        pen2.changeCartridge(cart1);

        assertSame(pen2.getCartridge(), cart1);
    }

    @Test
    public void testGetCartridge3() {
        pen1.changeCartridge(cart1);
        pen2.changeCartridge(cart1);

        assertNull(pen1.getCartridge());

    }

    @Test
    public void testWrite1() {
        assertFalse(pen1.write("some text"));
    }

    @Test
    public void testWrite2() {
        pen1.changeCartridge(cart1);
        assertTrue(pen1.write("some text"));
    }

    @Test
    public void testWrite3() {
        pen1.changeCartridge(cart1);
        while (!cart1.isEmpty()) {
            pen1.write("some text");
        }
        assertFalse(pen1.write("some text"));
    }

}
