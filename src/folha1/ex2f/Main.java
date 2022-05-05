package folha1.ex2f;

import java.util.Arrays;
import java.util.Scanner;

import static utils.Array.invertArrayVoid;
import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] newArray = newRandomArray(sc);


        sc.close();

        System.out.println(Arrays.toString(newArray));

       int max = 0;

       /* for (int i = 0; i < newArray.length ; i++) {
            if (newArray[i] > max){
                max = newArray[i];
            }
        }*/

        /* int max2 = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (max2 < newArray[i] && newArray[i] < max){
                max2 = newArray[i];
            }
        }
        System.out.println("O segundo valor maior do array é " +max2); */


        Arrays.sort(newArray);

        int max2aux = newArray[newArray.length - 1];
        for (int i = newArray.length - 2; i >= 0 ; i--) {
            if (newArray[i] < max2aux){
                max2aux = newArray[i];
                break;
            }
        }

        System.out.println("O segundo valor maior do array é " +max2aux);

    }
}
