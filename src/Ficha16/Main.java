package Ficha16;

import utils.InputValidation;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        Semaphore livres;
        Semaphore Ocups = new Semaphore(0);
        Lock Mutex = new ReentrantLock();


        Scanner sc = new Scanner(System.in);


        Buffer.bufferSize = InputValidation.validateIntGT0(sc,"Por favor, introduza o tamanho do buffer a criar: ");

        Buffer.buffer = new int[Buffer.bufferSize];

        Buffer.isOccupied = new boolean[Buffer.bufferSize];


        livres = new Semaphore(Buffer.bufferSize);



        boolean CorrectInput = false;
        while (CorrectInput == false) {
            try {
                System.out.println("Por favor, introduza o valor mínimo a inserir no buffer");
                Buffer.min = sc.nextInt();
                sc.nextLine();
                CorrectInput = true;


            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine();

            }
        }


        CorrectInput = false;
        while (CorrectInput == false) {
            try {
                System.out.println("Por favor, introduza o valor máximo a inserir no buffer");
                Buffer.max = sc.nextInt();
                sc.nextLine();
                CorrectInput = true;

                if (Buffer.max <= Buffer.min){
                    System.out.println("O valor máximo tem de ser superior ao mínimo (" + Buffer.min + ")");


                }else {
                    CorrectInput = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine();

            }
        }

        int nProducerThreads = InputValidation.validateIntGT0(sc,"Por favor, indroduza o número de threads produtoras a criar: ");

        int nConsumerThreads = InputValidation.validateIntGT0(sc,"Por favor, indroduza o número de threads consumidoras a criar: ");

        ExecutorService executor = Executors.newFixedThreadPool(nProducerThreads + nConsumerThreads);

        for (int i = 0; i < nProducerThreads; i++) {
            Producer producer = new Producer(livres, Ocups, Mutex);
            executor.execute(producer);
        }

        for (int i = 0; i < nConsumerThreads; i++) {
            Consumer consumer = new Consumer(livres, Ocups, Mutex);
            executor.execute(consumer);
        }


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção");
        }

        executor.shutdownNow();

    }
}

