package enzinium;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressTest {

    @Test
    public void AddressKeyPair() {
        Address rick = new Address();
        assertTrue(rick.getPK() != null);
        assertTrue(rick.getSK() != null);
    }

    @Test
    public void AddressToString() {

    }
}
