package Ficha14;

import java.util.concurrent.Semaphore;

public class SemaphoresExample {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);

        Thread[] threads = new Thread[10];

        ThreadSemaphores ts = new ThreadSemaphores(sem);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(ts,"t" + i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {

                threads[i].join();
            }

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção no join");
        }

        System.out.println("Counter: " + Shared.counter);
    }
}
