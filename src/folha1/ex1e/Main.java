//Implementar um método que conte todas as palavras numa cadeia de texto

package folha1.ex1e;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduza o texto sobre o qual quer saber o número de palavras ");
        String str = sc.nextLine();

        System.out.println("O texto introduzido tem " + wordCount(str) + " palavras");

        sc.close();
    }

    public static int wordCount(String str){

        int count = 0;


        StringTokenizer tk = new StringTokenizer(str);

        return tk.countTokens();
    }
}
