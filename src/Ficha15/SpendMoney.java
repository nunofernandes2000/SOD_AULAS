package Ficha15;

public class SpendMoney extends Thread {

    public BankAccount bankAccount;

    public SpendMoney(String name, BankAccount bankAccount) {
        this.setName(name);
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {

        while (true) {

            int transaction = (int) (Math.random() * 100 + 1);

            synchronized (bankAccount) {

                int oldBalance = this.bankAccount.getBalance();

                if (oldBalance >= 0) {

                    this.bankAccount.withdrawMoney(transaction);

                    System.out.println("O saldo mudou de " + oldBalance + "€ para " + this.bankAccount.getBalance() + "€ por levantamento de " + transaction + "€ pela thread " + this.getName());

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("Erro de interrupção");

                    }
                } else {
                    return;
                }
            }
        }

    }

}
