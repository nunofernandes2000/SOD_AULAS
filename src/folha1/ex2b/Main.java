package folha1.ex2b;

import java.util.Arrays;
import java.util.Scanner;

import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int avg = 0;

        int[] newArray = newRandomArray(sc);


        sc.close();

        for (int value : newArray) {
            avg += value;
        }

        avg /= newArray.length;


        System.out.println(Arrays.toString(newArray));

        System.out.println("A média dos elementos do array é " +avg);

    }
}
