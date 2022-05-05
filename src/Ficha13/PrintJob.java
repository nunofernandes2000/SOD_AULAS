package Ficha13;

import java.time.LocalTime;

public class PrintJob  implements Runnable{

    private PrinterQueue printerQueue;

    public PrintJob(PrinterQueue printerQueue){
        this.printerQueue = printerQueue;
    }


    @Override
    public void run() {

        System.out.println(LocalTime.now() + " -> A thread " + Thread.currentThread().getName() + " vai imprimir na printerQueue " + this.printerQueue.id);

        this.printerQueue.printDoc(); //chamar método printDoc

    }
}
