// Pedir ao utilizador um valor inteiro. Eliminar do array todos os valores que coincidam com o indicado pelo
//utilizador.

package folha1.ex2d;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Array.deleteFromArray;
import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {


        int value = 0;

        Scanner sc = new Scanner(System.in);

        int[] newArray = newRandomArray(sc);

        boolean correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor a eliminar do array: ");
                value = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine();
            }

        } while(correctInput == false);

        int[] prunedArray = deleteFromArray(newArray,value);

        sc.close();

        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(prunedArray));
    }
}
