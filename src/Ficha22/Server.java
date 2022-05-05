//Validação do Porto(portNumber) --> [do 1º if até ao fim do 2º if]

package Ficha22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    private final static int SOCKET_TIMEOUT = 20000; // [20 segundos]
    private final static int N_THREADS = 10; // Númerro máximo de Threads que pode utilizar no programa
    private final static String PATH = System.getProperty("user.dir") + "\\src\\Ficha22\\raffle.txt"; //Variavel com o caminho até ao ficheiro pretendido
    private final static String RAFFLE_FILE = "raffle.txt";
    private final static String ITEMS_FILE = "items.txt";
    private final static Lock itemsLock = new ReentrantLock(); //Praticamente server para criar um  semaforo mais simples, que é (0) ou (1)
    private final static Lock raffleLock = new ReentrantLock(); //Praticamente server para criar um  semaforo mais simples, que é (0) ou (1)

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

        try
                (ServerSocket serverSocket = new ServerSocket(portNumber))
        {


            Socket clientSocket = new Socket(); //Criar um novo Socket


            serverSocket.setSoTimeout(SOCKET_TIMEOUT); //Ao fim do número inserido 20 segundos neste caso, que ele está parado, gera uma exeção e sai

            ExecutorService executor = Executors.newFixedThreadPool(N_THREADS); //Esta linha codigo, cria uma pool de threads ou seja só utiliza o número definido que neste caso é N_THREAD = 10

            createRaffleFile();

            while (true){


                System.out.println("Main: À espera de novas ligações");

                try {

                    clientSocket = serverSocket.accept(); //Aguarda novas ligações após receber qualquer ligação
                    System.out.println("Main: Nova ligação");

                } catch (SocketTimeoutException e){
                    System.out.println("Main: Acabou o tempo de sorteio");
                    executor.shutdownNow();
                    break;


                } catch (IOException e){

                    System.out.println("Main: Ocorreu um erro de I/0 ao tentar criar o socket no porto " + portNumber);
                    System.exit(4);

                }

                executor.execute(new ServerThread(clientSocket, PATH + ITEMS_FILE, PATH + RAFFLE_FILE, itemsLock, raffleLock));
            }

        } catch (IOException e){
            System.out.println("Main: Ocorreu um erro de I/0 ao tentar criar o socket no porto " + portNumber);
            System.exit(5);
        }


    }

    private static void createRaffleFile(){
        BufferedReader fileItemsReader = null;
        BufferedWriter fileRaffleWriter = null;

        try {
            fileRaffleWriter = new BufferedWriter(new FileWriter(PATH + RAFFLE_FILE));
        } catch (IOException e) {
            System.out.println("Main: Erro de criação do buffer de escrita para o ficheiro " + RAFFLE_FILE);
            System.exit(6);
        }

        try {
            fileItemsReader = new BufferedReader(new FileReader(PATH + ITEMS_FILE));
        } catch (FileNotFoundException e) {
            System.out.println("Main: Erro de criação do buffer de leitura para o ficheiro " + ITEMS_FILE);
            System.exit(7);
        } finally {

            try {
                fileRaffleWriter.close();

            } catch (IOException e){
                System.out.println("Mian: Erro de fecho dos buffers do ficheiro " + RAFFLE_FILE);
                System.exit(8);

            }
        }

        String line = "";

        while (line != null){

            try {
                line = fileItemsReader.readLine();

                fileRaffleWriter.write("0\n");

            } catch (IOException e) {
                System.out.println("Main: Erro de leitura do ficheiro " + ITEMS_FILE);
                System.exit(9);
            } finally {

                try {
                    fileItemsReader.close();
                    fileRaffleWriter.close();
                } catch (IOException e) {
                    System.out.println("Mian: Erro de fchei dos buffers dos ficheiros " + ITEMS_FILE + " e " + RAFFLE_FILE);
                    System.exit(10);
                }

            }
        }

    }
}
