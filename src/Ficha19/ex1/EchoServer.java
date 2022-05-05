package Ficha19.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        if (args.length != 1){
            System.err.println("Para usar, execute java EchoServer \"número do porto\"");
            System.exit(1);
        }

        int portNumber = 0;


        try {
            portNumber = Integer.parseInt(args[0]); //Verificar se o primeiro valor introduzido no array é um número inteiro
        } catch (NumberFormatException e){
            System.err.println("Porto inválido: " + args[0]);
            System.exit(2);
        }

        if (portNumber < 1024 || portNumber > 65535){
            System.err.println("Porto inválido: " + args[0]);
            System.exit(3);
        }


        System.out.println("À espera de ligação");


        try (
                ServerSocket serverSocket = new ServerSocket(portNumber); //tudo o que tiver depois do ponto(.) close, mete-se dentro de uns () a seguir do catch

                Socket clientSocket = serverSocket.accept(); //The method blocks until a connection is made

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //Returns an output stream for this socket // O autoFlush serve para limpar

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        ) {

            String fromClient;

            do {
                fromClient = in.readLine(); // Lê tudo o que o Cliente enviar através do socket
                System.out.println("O cliente enviou " + fromClient);

                out.println(fromClient.length()); // Envia para o Cliente o nº de caracteres de uma String

            } while (!fromClient.equals("Adeus"));




        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O ao criar o socket");
            System.exit(4);

        } catch (IllegalArgumentException e){
            System.err.println("Número de porto inválido");
            System.exit(5);
        }


    }
}
