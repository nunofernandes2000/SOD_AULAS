//Implementar um método que conte todas as vogais numa cadeia de texto.


package folha1.ex1d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduza o texto sobre o qual quer saber o número de vogais ");
        String str = sc.nextLine();

        System.out.println("O texto introduzido tem " + vowelCount(str) + " vogais");

        sc.close();
    }

    public static int vowelCount(String str){

        String str2 = str.toLowerCase();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            char letter = str.charAt(i);

            if (letter == 'a' || letter == 'e'|| letter == 'i' || letter == 'o' || letter == 'u') {
                count++;
            }

        }
        return count;
    }
}
