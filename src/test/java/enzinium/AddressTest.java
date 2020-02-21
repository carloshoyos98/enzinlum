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
        Address reck = new Address();
        //falta poner el generateKeyPair()
        assertEquals("PK = " + reck.getPK() + '\n' +
                "Balance = " + reck.getBalance(), reck.toString());

    }

    @Test
    public void transferEZI() {
        Address rick = new Address();
        rick.generateKeyPair();
        rick.transferEZI(20.0);
        assertEquals(20.0, rick.getBalance(), 0.0d);
    }
}
