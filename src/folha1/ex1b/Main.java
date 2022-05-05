//Implementar um método que receba três números inteiros (min, max, n) como entrada e devolva um
//array de inteiros aleatórios entre min e max, inclusive, com n elementos

package folha1.ex1b;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int min = 0;
        int max = 0;
        int n = 0;


        Scanner sc = new Scanner(System.in);

        boolean correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor minimo para o array: ");
                min = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor máximo para o array: ");
                max = sc.nextInt();

                if (max <= min){
                    System.out.println("O valor máximo tem de ser maior que o valor mínimo");

                }else{
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o número de elementos a introduzir no array: ");
                n = sc.nextInt();

                if (n <= 0){
                    System.out.println("O número de elementos a introduzir no array tem de ser mairo que 0");

                }else {
                    correctInput = true;
                }


            } catch (InputMismatchException e) {

                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        int[] newArray = newRandomArray(min,max,n);

        System.out.print("[");
        for (int i = 0; i< n; i++){
            System.out.print(newArray[i]);
            if (i < n -1 ){
                System.out.println(",");
            }
        }

        System.out.println("]");

        System.out.print("[");
        for (int value : newArray){
            System.out.print(value + ",");
        }
        System.out.println("]");

        System.out.println(Arrays.toString(newArray));

        sc.close();

    }

    public static int[] newRandomArray(int min, int max, int n){

        int[] randomArray  = new int[n];

       // Random r = new Random();
        //r.nextInt();


        for (int i = 0; i< n; i++){



            //[0.0,1.0[ é o intervalo do Math.random()
            randomArray[i] = (int)((Math.random() * (max - min + 1)) + min);
            //randomArray[i] = r.nextInt(max + 1 - min) + min;

        }
        return randomArray;

    }

}
