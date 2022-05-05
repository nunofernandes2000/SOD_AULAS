package folha1.ex2a;

import java.util.Arrays;
import java.util.Scanner;

import static utils.Array.newRandomArray;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        int[] newArray = newRandomArray(sc);


        sc.close();

        for (int value : newArray) {
            sum += value;
        }


        System.out.println(Arrays.toString(newArray));

        System.out.println("A soma dos elementos do array é " +sum);

    }
}
