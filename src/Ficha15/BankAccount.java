package Ficha15;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdrawMoney(int value){
        this.balance -= value;
    }

    public int getBalance(){
        return this.balance;
    }
}
