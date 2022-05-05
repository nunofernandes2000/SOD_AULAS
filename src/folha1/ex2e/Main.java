package folha1.ex2e;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Array.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] newArray = newRandomArray(sc);


        System.out.println(Arrays.toString(newArray));
        invertArrayVoid(newArray);

        sc.close();

        System.out.println(Arrays.toString(newArray));
    }
}
