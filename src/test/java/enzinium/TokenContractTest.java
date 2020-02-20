package enzinium;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenContractTest {
    public Address rick;
    public TokenContract ricknillos;
    public Address morty;
    @Test
    public void crearContrato() {
        rick = new Address();
        TokenContract contrato = new TokenContract(rick);
        contrato.setName("Ricknillos");
        contrato.setSymbol("RNill");
        contrato.setTotalSupply(100);
        contrato.setTokenPrice(5d);
        assertEquals("Ricknillos", contrato.getName());
        assertEquals("RNill", contrato.getSymbol());
        assertEquals(100, contrato.getTotalSupply(), 0);
        assertEquals(5d, contrato.getTokenPrice(), 0);
    }

    @Test
    public void toStringTest() {
        Address rick = new Address();
        TokenContract contrato = new TokenContract(rick);
        contrato.setName("Ricknillos");
        contrato.setSymbol("RNill");
        contrato.setTotalSupply(100);
        contrato.setTokenPrice(5d);
        assertEquals("Name = Ricknillos" +'\n' +
                                "Symbol = RNill" + '\n' +
                                "Total supply = 100" + '\n' +
                                "Owner PK = " + contrato.getOwnerPK(), contrato.toString());
    }

    @Test
    public void addOwnerTest() {
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract contrato = new TokenContract(rick);
        contrato.setName("Ricknillos");
        contrato.setSymbol("RNill");
        contrato.setTotalSupply(100);
        contrato.setTokenPrice(5d);

        contrato.addOwner(rick.getPK(), contrato.getTotalSupply());
        contrato.addOwner(rick.getPK(), 500d);
        assertTrue(contrato.getBalances().size() != 0);

    }

    @Test
    public void numOwnersTest() {
        Address rick = new Address();
        TokenContract contrato = new TokenContract(rick);
        contrato.setTotalSupply(100d);
        Address peter = new Address();
        Address sam = new Address();
        rick.generateKeyPair();
        peter.generateKeyPair();
        sam.generateKeyPair();
        contrato.addOwner(rick.getPK(),contrato.getTotalSupply());
        contrato.addOwner(peter.getPK(), 500d);
        contrato.addOwner(sam.getPK(), 250d);


        assertEquals(3, contrato.numOwners(), 0);
    }

    @Test
    public void balanceOfTest() {
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        assertEquals(1, ricknillos.getBalances().size());

        ricknillos.setTokenPrice(5d);

        Address morty = new Address();
        morty.generateKeyPair();
        assertEquals(100d, ricknillos.balanceOf(rick.getPK()), 0d);
        // chequeo getOrDefault(PK, 0d) para direcciones que no existen
        assertEquals(0d, ricknillos.balanceOf(morty.getPK()), 0d);

    }

    @Test
    public void transferTest() {
        rick = new Address();
        rick.generateKeyPair();
        ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        assertEquals(1, ricknillos.getBalances().size());

        ricknillos.setTokenPrice(5d);

        morty = new Address();
        morty.generateKeyPair();

        ricknillos.transfer(morty.getPK(), 5d);
        assertEquals(5d, ricknillos.balanceOf(morty.getPK()), 0d);
        assertEquals(95d, ricknillos.balanceOf(rick.getPK()), 0d);

        //test si el require falla

        ricknillos.transfer(morty.getPK(), 600d);
        assertEquals(5d, ricknillos.balanceOf(morty.getPK()), 0d);
    }
}
