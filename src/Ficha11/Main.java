package Ficha11;

public class Main {
    public static void main(String[] args) {

        try {

            ExtendsThread t1 = new ExtendsThread();
            t1.start();

            Thread.sleep(1000);

            ExtendsThread t2 = new ExtendsThread();
            t2.start();

            Thread.sleep(1000);

            ExtendsThread t3 = new ExtendsThread();
            t3.start();

            Thread.sleep(1000);

            ImplementsRunnable runnable1 = new ImplementsRunnable();
            Thread t4 = new Thread(runnable1);
            t4.start();

            Thread.sleep(1000);

            ImplementsRunnable runnable2 = new ImplementsRunnable();
            Thread t5 = new Thread(runnable2);
            t5.start();

            Thread.sleep(1000);

            ImplementsRunnable runnable3 = new ImplementsRunnable();
            Thread t6 = new Thread(runnable3);
            t6.start();

            //Neste codigo, o valor de runnable como é a mesma variável, acumula sempre o valor, neste caso
            /*ImplementsRunnable runnable = new ImplementsRunnable();
            Thread t4 = new Thread(runnable);
            t4.start();

            Thread.sleep(1000);

            Thread t5 = new Thread(runnable);
            t5.start();

            Thread.sleep(1000);

            Thread t6 = new Thread(runnable);
            t6.start();*/

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção");
        }


    }
}
