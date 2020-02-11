package enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    private PublicKey PK = null;
    private PrivateKey SK = null;

    public Address() {}

    public PublicKey getPK() {
        return this.PK;
    }

    public PrivateKey getSK() {
        return this.SK;
    }

    static KeyPair generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        pair.getPrivate();

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

    }

}
