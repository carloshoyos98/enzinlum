package enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

    //atributos
    private String name = "";
    private String symbol = "";
    private double totalSupply = 0.0d;
    private double tokenPrice = 0.0d;
    private Address owner = null;
    private Map<PublicKey, Double> balances = new HashMap<PublicKey, Double>();
    //constructor

    public TokenContract(Address owner) {
        this.owner = owner;
    }

    //getters y setters

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getTokenPrice() {
        return tokenPrice;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public PublicKey getOwnerPK() {
        return this.owner.getPK();
    }

    public Map<PublicKey, Double> getBalances() {
        return this.balances;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTokenPrice(double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    // Métodos de la clase

    @Override
    public String toString() {
        StringBuilder contractRep = new StringBuilder();
        contractRep.append("Name = " + this.getName() +'\n');
        contractRep.append("Symbol = " + this.getSymbol() + '\n');
        contractRep.append("Total supply = " + this.getTotalSupply() + '\n');
        contractRep.append("Owner PK = " + this.getOwnerPK());
        return contractRep.toString();
    }

    public void addOwner(PublicKey ownerPK, double units) {
        this.getBalances().putIfAbsent(ownerPK, units);
    }

    public int numOwners() {
        return this.getBalances().size();
    }

    public Double balanceOf(PublicKey ownerPK) {
        return this.getBalances().getOrDefault(ownerPK, 0d);
    }


    public void transfer(PublicKey destiny_PK, double units) {
        try {
            require(balanceOf(getOwnerPK()), >= units);
            this.getBalances().compute(ownerPK, (pk, tokens))

        } catch (Exception e) {
            //no hace nada
        }
    }
}