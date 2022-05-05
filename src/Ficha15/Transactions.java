package Ficha15;

public class Transactions {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(1000);

        Thread t1 = new SpendMoney("t1",bankAccount);
        Thread t2 = new SpendMoney("t2",bankAccount);

        t1.start();
        t2.start();

    }
}
