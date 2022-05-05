package Ficha21.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoThread extends Thread {

    private Socket clientSocket;

    public EchoThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try (

                PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true); // autoflush-> server para enviar sem nos precupamos em limpar
                BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        )

        {

            String fromClient;

            do {
                System.out.println("Thread " +this.getName() + ": À espera de uma mensagem");
                fromClient = in.readLine(); // Lê tudo o que o Cliente enviar através do socket

                System.out.println("Thread" + this.getName() + ": Recebeu a mensagem " + fromClient);

                out.println(fromClient.length()); // Envia para o Cliente o nº de caracteres de uma String

            } while (!fromClient.equals("Adeus"));

            System.out.println("Thread " +this.getName() + ": Terminou");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
