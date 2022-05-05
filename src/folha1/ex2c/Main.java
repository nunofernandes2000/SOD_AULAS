package folha1.ex2c;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int avg = 0;
        int min = 0;

        int[] newArray = newRandomArray(sc);

        boolean correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o valor minimo a listar no array: ");
                min = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine();
            }

        } while(correctInput == false);


        sc.close();


        System.out.println(Arrays.toString(newArray));

        System.out.print("[");
        boolean print = false;
        for (int i = 0; i < newArray.length; i++) {

            if (newArray[i] >= min){

                if (print){
                    System.out.print(",");
                }

                System.out.print(newArray[i]);
                print = true;
            }

        }
        System.out.println("]");



    }
}
