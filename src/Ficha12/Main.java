package Ficha12;

import utils.Array;
import utils.InputValidation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] randomArrayOriginal = Array.newDoubleRandomArray(sc);
        double[] randomArrayCopy = Arrays.copyOf(randomArrayOriginal, randomArrayOriginal.length);

        int pot = InputValidation.validateIntGT0(sc, "Por favor, introduza a potência a aplicar a cada elemento do array: ");

        int nThreads = InputValidation.validateIntGT0(sc, "Por favor, introduza o número de threads a utilizar: ");

        int nSubArray = InputValidation.validateIntGT0(sc, "Por favor, introduza o número de partes em que o array deve ser dividido para cálculo pararelo: ");

        sc.close();

        ExecutorThread thread = new ExecutorThread(randomArrayOriginal, pot, 0, randomArrayOriginal.length);

        long startTime = System.nanoTime();

        thread.start();

        try {
            thread.join();

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção na thread");
        }

        long elapsedTime = (System.nanoTime()) - startTime;


        double sum = 0;
        for (int i = 0; i < randomArrayOriginal.length; i++) {
            sum += randomArrayOriginal[i];
        }

        System.out.println("\nResultado final: " + sum);
        System.out.println("Tempo de execução com 1 thread: " + elapsedTime / 1E9 + "s");


        ExecutorService executor = Executors.newFixedThreadPool(nThreads);


        int SubElem = randomArrayCopy.length / nSubArray;


        startTime = System.nanoTime();


        for (int i = 0; i < nSubArray; i++) {
            ExecutorThread worker = new ExecutorThread(randomArrayCopy, pot, SubElem * i, SubElem * (i + 1));
            executor.execute(worker);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção");
        }

        elapsedTime = System.nanoTime() - startTime;

        sum = 0;
        for (int i = 0; i < randomArrayCopy.length; i++) {
            sum += randomArrayCopy[i];
        }


        System.out.println("\nResultado final: " +sum);
        System.out.println("Tempo de execução com " + nThreads + "threads e o array dividido em " + nSubArray + " partes : " + elapsedTime / 1E9 + "s");


    }
}
