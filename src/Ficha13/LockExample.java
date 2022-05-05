package Ficha13;

public class LockExample {
    public static void main(String[] args) {

        PrinterQueue pq1 = new PrinterQueue(1);
        PrinterQueue pq2 = new PrinterQueue(2);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {

            if (i%2 == 0 ){
                PrintJob pj = new PrintJob(pq1);
                threads[i] = new Thread(pj,"t" + i);

            }else {
                PrintJob pj = new PrintJob(pq2);
                threads[i] = new Thread(pj,"t" + i);
            }

        }

        for (int i = 0; i < threads.length; i++){
            threads[i].start();
        }

    }
}
