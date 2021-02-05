package pen;

import org.junit.Test;
import static org.junit.Assert.*;

public class CapIT {

    @Test
    public void testCapNull() {
        Cap capNull = new Cap(null);
        assertEquals(capNull.BRAND, Cap.DEFAULT_BRAND);
    }

    @Test
    public void testCap() {
        String brand = "Reynolds";
        Cap capNull = new Cap(brand);
        assertEquals(capNull.BRAND, brand);
    }

}
