//Implementar um método que receba três parâmetros inteiros e devolva o menor dos três.

package folha1.ex1c;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int c = 0;


        Scanner sc = new Scanner(System.in);

        boolean correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o primeiro número inteiro: ");
                a = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o segundo número inteiro: ");
                b = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o terceiro número inteiro: ");
                c = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        System.out.println("O mínimo é " +minimumValue(a,b,c));

        sc.close();

    }

    public static int minimumValue(int a, int b, int c){



        /*int minimum = 0;

        if (a < b && a < c){
            return a;
        }
        if (b < a && b < c){
            return b;
        }
            return c;*/


        int minimum = a;

        if (b < a){
            minimum = b;
        }
        if (c < minimum){
            minimum = c;
        }
        return minimum;







       /* int[] newArray = new int[3];
        newArray[0] = a;
        newArray[1] = b;
        newArray[2] = c;*/


        /*int[] newArray = {a,b,c};


        minimum = newArray[0];
        for (int i = 0; i < 3; i++){
            if (newArray[i] < minimum){
                minimum = newArray[i];
            }

        }
        return minimum;*/



       // return  Math.min(Math.min(a,b), c);


    }

}
