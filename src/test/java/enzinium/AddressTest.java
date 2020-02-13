package enzinium;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void generateKeyPair() {
        Address rick = new Address();
        rick.generateKeyPair();
        assertNotNull(rick.getPK());
        assertNotNull(rick.getSK());
    }

    @Test
    public void AddressToString() {

    }
}
