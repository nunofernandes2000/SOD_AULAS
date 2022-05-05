package folha2.ex2a;

import java.util.Scanner;
import static utils.InputValidation.validateIntGT0;

public class Main {
    public static void main(String[] args) {

        String  cor;
        Circulo circulo1;
        int raio;
        Circulo circulo2;
        Scanner sc = new Scanner(System.in);



        raio = validateIntGT0(sc,"Por favor, introduza o valor do raio do circulo a criar");

        circulo1 = new Circulo(raio);


        do {
            System.out.println("Por favor, introduza a cor a atribuir ao circulo (azul, verde, vermelho ou preto)");
            cor = sc.nextLine().toLowerCase();


        } while (!cor.equals("azul") && !cor.equals("verde") && !cor.equals("vermelho") && !cor.equals("preto"));


        circulo1.setCor(cor);


        raio = validateIntGT0(sc,"Por favor, introduza o valor do raio do circulo a criar");



        do {
            System.out.println("Por favor, introduza a cor a atribuir ao circulo (azul, verde, vermelho ou preto)");
            cor = sc.nextLine().toLowerCase();


        } while (!cor.equals("azul") && !cor.equals("verde") && !cor.equals("vermelho") && !cor.equals("preto"));


        circulo2 = new Circulo(raio,cor);

        new DrawCircles(circulo1,circulo2);


    }
}
