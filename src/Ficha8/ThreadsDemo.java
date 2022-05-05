package Ficha8;

import java.util.Scanner;

public class ThreadsDemo {
    public static void main(String[] args) {

        System.out.println("O processo main foi iniciado");

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduza o nome a atribuir à primeira thread");
        String t1Name = sc.nextLine();

        System.out.println("Por favor, introduza o nome a atribuir à segunda thread");
        String t2Name = sc.nextLine();

        Threads t1 = new Threads(t1Name);
        Threads t2 = new Threads(t2Name);

        t1.start();
        t2.start();


        System.out.println("Por favor, pressione a tecla enter para terminar o processo");
        sc.nextLine();


        sc.close();

        System.out.println("O processo foi terminado");
    }
}
