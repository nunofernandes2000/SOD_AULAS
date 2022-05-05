package Ficha22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente extends Thread {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Para usar, execute java EchoClient \"IP do servidor\" \"número do porto\"");
            System.exit(1);
        }

        int portNumber = 0;


        try {
            portNumber = Integer.parseInt(args[1]); //Verificar se o primeiro valor introduzido no array é um número inteiro
        } catch (NumberFormatException e) {
            System.err.println("Porto inválido: " + args[1]);
            System.exit(2);
        }

        if (portNumber < 1024 || portNumber > 65535) {
            System.err.println("Porto inválido: " + args[1]);
            System.exit(3);
        }


        try (
                Socket clientSocket = new Socket((args[0]), portNumber);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //Returns an output stream for this socket // O autoFlush serve para limpar
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                Scanner sc = new Scanner(System.in);


        ) {

            int option;
            do {

                option = menu(sc);

                switch (option) {

                    //pedir lista
                    case 1:
                        System.out.println("A pedir a lista de itens ao servidor");
                        getItemsList(in,out);
                        break;

                        //pedir resultados
                    case 2:

                        break;

                        //sair
                    case 3:
                        System.out.println("O cliente saiu\n");
                        out.println(3);
                        break;
                }

            } while (option != 3);


        } catch (UnknownHostException e) {
            System.out.println("Host desconhecido: " +args[0]);
            System.exit(4);


        } catch (IOException e) {
            System.out.println("Erro de criação de socket ou dos buffers de comunicação");
            System.exit(5);

        }
    }

    private static int menu(Scanner sc) {

        String option = "";

        do {
            System.out.println("\t\t\t### Menu de opções ###");
            System.out.println("\t 1 - Ver lista de itens a sortear");
            System.out.println("\t 2 - Ver resultado do sorteio");
            System.out.println("\t 3 - Sair");
            System.out.print("\tOpção: ");

            option = sc.nextLine();


        } while (!option.equals("1") && !option.equals("2") && !option.equals("3"));


        return Integer.parseInt(option);
    }

    private static  void getItemsList(BufferedReader in, PrintWriter out) {

        out.println(1);

        String item;

        System.out.println("\n\n Lista de itens em sorteio:\n");


        try {
            do {

                item = in.readLine();

                if (!item.equals("####")) {
                    System.out.println(item);
                }

            } while (!item.equals("####"));

        } catch (IOException e) {
            System.out.println("Erro de recepção de dados do servidor");
            System.exit(6);
        }
        System.out.println("");
    }
}
