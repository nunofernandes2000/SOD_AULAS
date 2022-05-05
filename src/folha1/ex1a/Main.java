//Implementar um método que valide se o ano é bissexto. Este método recebe um inteiro (o ano) e devolve
// um booleano (verdadeiro ou falso)

package folha1.ex1a;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int year = 0;

        Scanner sc = new Scanner(System.in);

        boolean correctInput  = false;

        do {
            try {
                System.out.println("Por favor, introduza o ano a verificar se  é bissexto: ");
                year = sc.nextInt();

                correctInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduza um número inteiro.");
                sc.nextLine(); //server para apanhar o Enter ou seja acabar com o ciclo infinito
            }

        } while(correctInput == false);

        sc.close();

        if (isLeapYear(year))
            System.out.println("O ano " + year + " é bissexto.");
        else
            System.out.println("O ano " + year + " não é bissexto.");

    }

    public static  boolean isLeapYear(int year){

        if ((year%4==0 && year%100 !=0) || year%400 ==0){
            return true;
        }
        return false;
    }

}
