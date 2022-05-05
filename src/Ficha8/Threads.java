package Ficha8;

public class Threads extends Thread{

    public Threads(String name){
        this.setName(name);
    }

    @Override
    public void run(){
        System.out.println("A thread " + this.getName() + " começou a ser executada");

        for (int i = 0; i < 10 ; i++) {

            System.out.println("A thread " + this.getName() + " vai adormecer durante 2s");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("A thread " + this.getName() + " foi interrompida");
            }
        }

        System.out.println("A thread " + this.getName() + " terminou");
    }
}
