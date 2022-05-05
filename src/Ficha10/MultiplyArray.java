package Ficha10;

import utils.Array;
import utils.InputValidation;
import java.util.Arrays;
import java.util.Scanner;

public class MultiplyArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] randomArrayOriginal = Array.newDoubleRandomArray(sc);
        double[] randomArrayCopy = Arrays.copyOf(randomArrayOriginal, randomArrayOriginal.length);

        int pot = InputValidation.validateIntGT0(sc, "Por favor, introduza a potência a aplicar a cada elemento do array");

        int nThreads = InputValidation.validateIntGT0(sc, "Por favor, introduza o número de threads a utilizar");

        sc.close();

        Multiplier thread = new Multiplier(randomArrayOriginal, pot, 0, randomArrayOriginal.length);

        long starTime = System.nanoTime();

        thread.start();

        try {
            thread.join();

        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção na thread");
        }

        long elapsedTime = (System.nanoTime()) - starTime;


        double sum = 0;
        for (int i = 0; i < randomArrayOriginal.length; i++) {
            sum += randomArrayOriginal[i];
        }

        System.out.println("\nResultado final: " + sum);
        System.out.println("Tempo de execução com 1 thread: " + elapsedTime / 1E9 + "s");


        Multiplier[] threads = new Multiplier[nThreads];

        int SubElem = randomArrayCopy.length / nThreads;


       /*
        nThreads = 10;
        randomArrayCopy.length = 40;
        SubElem = 40/10 -->4;

        i = 0; SubElem*(i)->SubElem*(i+1)
        i = 1; SubElem*(i)->SubElem*(i+1)
        i = 2; SubElem*(i)->SubElem*(i+1)

        */


        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Multiplier(randomArrayCopy, pot, SubElem * i, SubElem * (i + 1));
        }

        starTime = System.nanoTime();
        for (int i = 0; i < nThreads; i++) {
            threads[i].start();
        }


        try {
            for (int i = 0; i < nThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Erro de interrupção de uma thread");
        }

        elapsedTime = System.nanoTime() - starTime;

        sum = 0;
        for (int i = 0; i < randomArrayCopy.length; i++) {
            sum += randomArrayCopy[i];
        }


        System.out.println("\nResultado final: " +sum);
        System.out.println("Tempo de execução com " + nThreads + "threads: " + elapsedTime / 1E9 + "s");


    }

}

