package Ficha22;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class ServerThread  extends Thread{

    private Socket clientSocket;
    private String itemsFilePath;
    private String raffleFilePath;
    private Lock itemsLock;
    private Lock raffleLock;

    private BufferedReader fileItemsBReader; //Buffer que lê ficheiros dos items
    private BufferedReader filesRaffleBReader; // Buffer que lê ficheiro do sorteio
    private BufferedWriter filesRaffleBWriter; // Buffer que escreve no ficheiro do sorteio

    private int itemNumberRaffle;

    public ServerThread(Socket clientSocket, String itemsFilePath, String raffleFilePath, Lock itemsLock, Lock raffleLock) {
        this.clientSocket = clientSocket;
        this.itemsFilePath = itemsFilePath;
        this.raffleFilePath = raffleFilePath;
        this.itemsLock = itemsLock;
        this.raffleLock = raffleLock;
    }


    @Override
    public void run(){

        try (

                PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true); // autoflush-> server para enviar sem nos precupamos em limpar
                BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        )
        {

            doRaffle();

            String option = "";

            do {
                option = in.readLine();

                switch (option){

                    case "1":
                        System.out.println("Thread " + this.getName() + ": A enviar a lista de items");
                        sendItemsList(out);
                        break;

                    case "2":

                        if (this.isInterrupted()){
                            System.out.println("Thread " + this.getName() + ": A enviar os resultados do sorteio");
                            out.println(1); // Se o cliente receber 1, quer dizer vai receber os resultados logo a seguir
                            sendResults(out);

                        } else {
                            System.out.println("Thread " + this.getName() + ": Resultados não enviados, pois o sorteio ainda não acabou");
                            out.println(0); // Se o cliente receber 0, quer dizer que ainda não acabou, logo não vai receber os resultados
                        }

                        break;

                    case "3":
                        System.out.println("Thread " + this.getName() + ": O cliente saiu");
                        break;
                }


            } while (!option.equals("3")); //Enquanto for a opção for diferente de 3 o programa continua, quando o cliente digitar o 3, o cliente vai sair do ciclo



        } catch (IOException e){
            System.out.println("Thread " + this.getName() + ": Erro de criação dos buffers do socket");
            System.exit(1);
        }
    }

    private void doRaffle(){

        List<String> raffleList = new ArrayList<>(); //Criaçao de um Array(neste caso uma ArrayList)

        String line = "";
        int counter = 0; //Contador inicializado a 0

        this.raffleLock.lock(); // A primeira thread bloqueia o acesso ao codigo, das threads que chegam a seguir

        try {

            this.fileItemsBReader = new BufferedReader(new FileReader(this.raffleFilePath));

            while (line != null){

                line = this.filesRaffleBReader.readLine();
                raffleList.add(line);

                if (line.equals("0")){
                    counter ++;
                }
            }

            this.filesRaffleBReader.close(); // Serve para fechar o Buffer de leitura do ficheiro de sorteio

        } catch (FileNotFoundException e) {
            System.out.println("Thread " + this.getName() + ": Ficheiros de sorteio não encontrado");
            this.raffleLock.unlock();
            System.exit(2);

        } catch (IOException e){
            System.out.println("Thread " + this.getName() + ": Erro de leitura do ficheiro do sorteio");
            this.raffleLock.unlock();
            System.exit(3);

        }

        int number = (int) (Math.random() *  counter + 1); // Gera um numero entre 0 e o numero que estiver dentro do contador

        int zeroCounter = 0;
        for (int i = 0; 1 < raffleList.size(); i++){
            if (raffleList.get(i).equals("0")){
                zeroCounter++;
            }

            if (zeroCounter == number){
                raffleList.set(i,this.getName());

                itemNumberRaffle = i;

                break;
            }
        }

        try {
            this.filesRaffleBWriter = new BufferedWriter(new FileWriter(this.raffleFilePath));

            for (int i = 0; i < raffleList.size() ; i++) {
                this.filesRaffleBWriter.write(raffleList.get(i) + "\n");
            }

            this.filesRaffleBWriter.close();


        } catch (IOException e) {
            System.out.println("Thread " + this.getName() + ": Erro de escrita,  abertura ou fecho do ficheiro de sorteio");
            this.raffleLock.unlock();
            System.exit(4);
        }

        this.raffleLock.unlock(); // O Acesso é desbloqueado, depois da thread acabar de fazer o bloco de código

    }

    private void sendItemsList(PrintWriter out){

        this.itemsLock.lock(); //Bloqueia acesso

        String line = "";

        try {
            this.fileItemsBReader = new BufferedReader(new FileReader(this.itemsFilePath));

            while (line != null){

                line = this.fileItemsBReader.readLine();

                if (line !=null){
                    out.println(line);
                }
            }

            out.println("####");

        } catch (FileNotFoundException e) {
            System.out.println("Thread " + this.getName() + ": Erro de leitura do ficheiro de itens");
            this.itemsLock.unlock();
            System.exit(5);

        } catch (IOException e) {
            System.out.println("Thread " + this.getName() + ": Erro de leitura do ficheiro de itens");
            this.itemsLock.unlock();
            System.exit(6);
        }

        this.itemsLock.unlock(); //Desbloqueia acesso

    }

    private void sendResults(PrintWriter out){

        String itemNameRaffle = null;

        this.itemsLock.lock(); //Acesso Bloqueado

        try {
            this.fileItemsBReader = new BufferedReader(new FileReader(this.itemsFilePath));

            itemNameRaffle = "";

            for (int i = 0 ; i <= this.itemNumberRaffle ; i++) {
                itemNameRaffle = this.fileItemsBReader.readLine();
            }

            this.fileItemsBReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("Thread " + this.getName() + ": Ficheiro de itens não encontrado");
            System.exit(7);

        } catch (IOException e) {
            System.out.println("Thread " + this.getName() + ": Erro de leitura ou de fecho do ficheiro de itens");
            System.exit(8);
        }
        this.itemsLock.unlock(); //Acesso Desbloqueado

        out.println("\t\t\t### Resultados do sorteio ###");
        out.println("");
        out.println("\t Foi-lhe sorteado o item: " + itemNameRaffle);
        out.println("");

        this.itemsLock.lock();
        this.raffleLock.lock();

        try {
            this.fileItemsBReader = new BufferedReader(new FileReader(this.itemsFilePath));
            this.filesRaffleBReader = new BufferedReader(new FileReader(this.raffleFilePath));

            String itemName = "";
            String threadName = "";

            while (itemName != null) {
                itemName = this.fileItemsBReader.readLine();
                threadName = this.filesRaffleBReader.readLine();

                if (itemName != null) {
                    out.println(itemName + " - " + threadName);
                }
            }
            out.println("####");

            this.fileItemsBReader.close();
            this.filesRaffleBReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("Thread " + this.getName() + ": Ficheiro de itens ou de sorteio não encontrado");
            this.itemsLock.unlock();
            this.raffleLock.unlock();
            System.exit(9);

        } catch (IOException e) {
            System.out.println("Thread " + this.getName() + ": Erro de leitura ou fecho do ficheiro de itens ou do ficheiro de sorteio");
            this.itemsLock.unlock();
            this.raffleLock.unlock();
            System.exit(10);
        }
        this.itemsLock.unlock();
        this.raffleLock.unlock();
    }
}
