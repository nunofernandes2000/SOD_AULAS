package Ficha13;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterQueue {

    private Lock queueLock = new ReentrantLock();

    public int id;

    public PrinterQueue(int id) {
        this.id = id;
    }

    public void printDoc(){

        int duration = (int) (Math.random() * 10001);  // (10000 + 1 ou 10001)

        queueLock.lock();

        System.out.println(LocalTime.now() + " -> A PrintQueue " + this.id + " vai imprimir durante " + duration /1000 + "s para a thread " +Thread.currentThread().getName());

        try {
            Thread.sleep(duration);

            System.out.println(LocalTime.now() + " -> A PrintQueue " + this.id + " terminou de imprimir " + duration /1000 + "s para a thread " +Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção");

        }finally {
                queueLock.unlock();
        }

    }
}
