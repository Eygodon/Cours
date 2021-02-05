package pen;

import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartridgeIT {

    private Cartridge cart1;
    private Cartridge cart2;
    private Pen pen1;
    private Pen pen2;

    @Before
    public void setUp() {
        cart1 = new Cartridge(Color.red);
        cart2 = new Cartridge(Color.green);
        pen1 = new Pen();
        pen2 = new Pen("AnotherBrand");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFreePen() {
        cart1.freePen();
        assertNull(cart1.getPen());
    }

    @Test
    public void testFreePen2() {
        cart1.setPen(pen1);
        cart1.freePen();
        assertNull(cart1.getPen());
        assertNull(pen1.getCartridge());
    }

    @Test
    public void testSetPen1() {
        cart1.setPen(pen1);
        assertSame(cart1.getPen(), pen1);
        assertSame(pen1.getCartridge(), cart1);
    }

    @Test
    public void testSetPen2() {
        cart1.setPen(pen1);
        cart2.setPen(pen2);

        cart1.setPen(pen2);

        assertNull(cart2.getPen());
        assertNull(pen1.getCartridge());
        assertSame(cart1.getPen(), pen2);
        assertSame(pen2.getCartridge(), cart1);
    }

    @Test
    public void testUse() {
        int level = Cartridge.DEFAULT_LEVEL;
        while (cart1.getLevel() > 0) {
            assertEquals(cart1.getLevel(), level);
            cart1.use();
            level--;
        }

    }

    @Test
    public void testUse2() {
        while (cart1.getLevel() > 0) {
            cart1.use();
        }
        assertEquals(cart1.getLevel(), 0);
        assertTrue(cart1.isEmpty());

    }

    @Test
    public void testUseEmpty() {
        while (!cart1.isEmpty()) {
            cart1.use();
        }
        cart1.use();
        assertEquals(cart1.getLevel(), 0);
        assertTrue(cart1.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        while (cart1.getLevel() > 0) {
            assertFalse(cart1.isEmpty());
            cart1.use();
        }
        assertTrue(cart1.isEmpty());
        assertEquals(cart1.getLevel(), 0);
        cart1.use();
        assertEquals(cart1.getLevel(), 0);
    }

    @Test
    public void testGetPen() {
        assertNull(cart1.getPen());
        cart1.setPen(pen1);
        assertSame(cart1.getPen(), pen1);
    }

}
