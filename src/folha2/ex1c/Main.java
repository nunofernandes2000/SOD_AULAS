package folha2.ex1c;

import utils.Array;

import java.util.Scanner;

import static utils.Array.print2DArray;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] new2DArray = Array.newRandom2DArray(sc);





        int[][] transposedArray = new int[new2DArray[0].length][new2DArray.length];

        for (int i = 0; i < transposedArray.length; i++) {
            for (int j = 0; j < transposedArray[0].length; j++) {

                transposedArray[i][j] = new2DArray[j][i];

            }
        }


        print2DArray(new2DArray);
        print2DArray(transposedArray);



        sc.close();
    }
}
