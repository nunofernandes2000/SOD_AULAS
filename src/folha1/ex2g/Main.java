package folha1.ex2g;

import java.util.Arrays;
import java.util.Scanner;

import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] newArray = newRandomArray(sc);


        sc.close();

        System.out.println(Arrays.toString(newArray));


        Arrays.sort(newArray);

        int min = newArray[0];
        for (int i = 1 ; i < newArray.length ; i++) {

            if (newArray[i] > min){
                min = newArray[i];


                System.out.println("O segundo valor maior do array é " +min);


                return;
            }
        }

    }
}
