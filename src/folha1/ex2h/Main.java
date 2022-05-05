package folha1.ex2h;

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

        int pastValue = newArray[0];
        int count = 1;
        for (int i = 1 ; i < newArray.length ; i++) {

            if (newArray[i] == pastValue){
                count ++;

            }
            else if (count > 1){
                System.out.println(pastValue + " --> " +count + " vezes ");
                count = 1;
            }
            pastValue = newArray[i];
        }

        if (count > 1){
            System.out.println(pastValue + " --> " +count + " vezes ");
        }

    }
}
