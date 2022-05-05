package folha2.ex1b;

import utils.Array;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.InputValidation.validateIntGE0;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] new2DArray = Array.newRandom2DArray(sc);

        int firstRow = 0;
        int lastRow = 0;
        int firstcolumn = 0;
        int lastColumn = 0;


        while (true) {
            firstRow = validateIntGE0(sc, "Por favor, introduza a linha inicial a copiar(0...)");
            lastRow = validateIntGE0(sc, "Por favor, introduza a linha final a copiar(0...)");
            firstcolumn = validateIntGE0(sc, "Por favor, introduza a coluna inicial a copiar(0...)");
            lastColumn = validateIntGE0(sc, "Por favor, introduza a coluna final a copiar(0...)");

            if (lastRow >= firstRow && lastColumn >= firstcolumn && firstRow < new2DArray.length && lastRow < new2DArray.length
            && firstcolumn < new2DArray[0].length && lastColumn < new2DArray[0].length){
                break;

            }else {
                System.out.println("As coordenadas introduzidas são inválidads");
            }
        }

        System.out.println(Arrays.deepToString(new2DArray));

        int[][] new2DSubArray = new int[lastRow - firstRow + 1][lastColumn - firstcolumn + 1];

        for (int i =  firstRow; i <= lastRow ; i++) {
            for (int j = firstcolumn; j <= lastColumn ; j++) {
                new2DSubArray[i - firstRow][j - firstcolumn] = new2DArray[i][j];
            }
        }

        System.out.println(Arrays.deepToString(new2DArray));

        sc.close();

    }
}
