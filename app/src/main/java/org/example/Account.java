package org.example;

public class Account {
    private String iban;
    private double limit;
    private double balance;

    public Account(String iban) {
        this.iban = iban;
        this.balance = 0;
        this.limit = 1000;
    }

    public void withdraw(double amount) throws AccountOverdrawnException, InvalidAmountException{
        // Validieren?
if (amount<=0 ){
    //ausnahmesituation: kann eig nicht sein! programmierfehler!
    throw new InvalidAmountException("amount must be greater than zero");
}
        if (this.balance + this.limit >= amount) {
            this.balance -= amount;
        } else {
            // vorhersehbare Ausnahmesituation!
            // Kann hier nicht behandelt werden!
            throw new AccountOverdrawnException("not enough money for Iban:" + iban);
        }
    }

    public void deposit(double amount) {
        // Validierung?
        this.balance += amount;
    }

    public String toString() {
        return " Account " + iban + "Kontostand" + balance;
    }
}
