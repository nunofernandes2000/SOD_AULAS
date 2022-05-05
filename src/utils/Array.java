package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Array {

    public static int[] newRandomArray(Scanner sc) {

        int min = 0, max = 0, n = 0;


        boolean correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor minimo para o array: ");
                min = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor máximo para o array: ");
                max = sc.nextInt();

                if (max <= min) {
                    System.out.println("O valor máximo tem de ser maior que o valor mínimo");

                } else {
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o número de elementos a introduzir no array: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("O número de elementos a introduzir no array tem de ser mairo que 0");

                } else {
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        int[] randomArray = new int[n];


        for (int i = 0; i < n; i++) {
            randomArray[i] = (int) ((Math.random() * (max - min + 1)) + min);


        }

        return randomArray;

    }

    public static double[] newDoubleRandomArray(Scanner sc) {

        double min = 0, max = 0;
        int n = 0;


        boolean correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor minimo para o array: ");
                min = sc.nextDouble();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número double.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor máximo para o array: ");
                max = sc.nextDouble();

                if (max <= min) {
                    System.out.println("O valor máximo tem de ser maior que o valor mínimo");

                } else {
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número double.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        correctInput = false;

        do {
            try {
                System.out.println("Por favor, introduza o número de elementos a introduzir no array: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("O número de elementos a introduzir no array tem de ser mairo que 0");

                } else {
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while (correctInput == false);

        double[] randomArray = new double[n];


        for (int i = 0; i < n; i++) {
            randomArray[i] = ((Math.random() * (max - min + 1)) + min);

        }

        return randomArray;

    }
        public static int[] deleteFromArray(int[] oldArray, int valueToRemove) {


            int count = 0;

            for (int element : oldArray) {
                if (element == valueToRemove) {
                    count++;
                }
            }

            int[] newArray = new int[oldArray.length - count];


            int j = 0;
            for (int i = 0; i < oldArray.length; i++) {

                if (oldArray[i] != valueToRemove) {
                    newArray[j++] = oldArray[i];
                }
            }

            return newArray;
        }

        public static int[] invertArray(int[] oldArray) {

            int[] invertedArray = new int[oldArray.length];


      /*  int j = 0;
        for (int i = oldArray.length; i >= 0 ; i--) {
            invertedArray[j++] = oldArray[i];
        }*/


            for (int i = 0; i < oldArray.length; i++) {
                invertedArray[oldArray.length - i - 1] = oldArray[i];
            }

            return invertedArray;
        }


        public static void invertArrayVoid(int[] oldArray) {


            int temp;
            for (int i = 0; i < oldArray.length / 2; i++) {


                temp = oldArray[oldArray.length - i - 1];
                oldArray[oldArray.length - i - 1] = oldArray[i];

                oldArray[i] = temp;

            }

        }

        public static int[][] newRandom2DArray(Scanner sc) {

            int min = 0;
            int max = 0;
            int nRows = 0;
            int nColumns = 0;

            boolean correctInput = false;
            while (!correctInput) {
                try {
                    System.out.print("Por favor, introduza o valor mínimo a introduzir no array bidimensional:");
                    min = sc.nextInt();
                    sc.nextLine();
                    correctInput = true;

                } catch (InputMismatchException e) {
                    System.out.println("Por favor introduza um número inteiro.");
                    sc.nextLine(); // para gastar o enter sen�o fica em ciclo infinito
                }
            }

            correctInput = false;
            while (!correctInput) {
                try {
                    System.out.print("Por favor, introduza o valor máximo a introduzir no array bidimensional:");
                    max = sc.nextInt();
                    sc.nextLine();

                    if (max < min) {
                        System.out.println("O n�mero máximo tem de ser superior ao número mínimo.");

                    } else {
                        correctInput = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Por favor introduza um número inteiro.");
                    sc.nextLine(); // para gastar o enter sen�o fica em ciclo infinito
                }
            }

            correctInput = false;
            while (!correctInput) {
                try {
                    System.out.print("Por favor, introduza o número de linhas para criar no array bidimensional:");
                    nRows = sc.nextInt();
                    sc.nextLine();

                    if (nRows < 2) {
                        System.out.println("O array tem de ter pelo menos 2 linhas.");

                    } else {
                        correctInput = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Por favor introduza um número inteiro.");
                    sc.nextLine(); // para gastar o enter sen�o fica em ciclo infinito
                }
            }

            correctInput = false;
            while (!correctInput) {
                try {
                    System.out.print("Por favor, introduza o número de colunas para criar no array bidimensional:");
                    nColumns = sc.nextInt();
                    sc.nextLine();

                    if (nColumns < 2) {
                        System.out.println("O array tem de ter pelo menos 2 colunas.");

                    } else {
                        correctInput = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Por favor introduza um número inteiro.");
                    sc.nextLine(); // para gastar o enter sen�o fica em ciclo infinito
                }
            }

            int[][] random2DArray = new int[nRows][nColumns];

            for (int l = 0; l < nRows; l++) {

                for (int c = 0; c < nColumns; c++) {
                    random2DArray[l][c] = (int) ((Math.random() * (max + 1 - min)) + min);
                }
            }

            return random2DArray;
        }

        public static void print2DArray(int[][] array2D) {

            int nRows = array2D.length;
            int nColumns = array2D[0].length;

            for (int l = 0; l < nRows; l++) {
                System.out.println();

                for (int c = 0; c < nColumns; c++) {
                    System.out.print("\t" + array2D[l][c]);
                }
            }
            System.out.println();
        }


    }
