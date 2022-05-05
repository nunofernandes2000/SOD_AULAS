package Ficha20;

import java.io.IOException;
import java.net.ServerSocket;

public class PortsInUse {
    public static void main(String[] args) {


        for (int portNumber = 0; portNumber < 65536; portNumber++){



            try(
                    ServerSocket serverSocket = new ServerSocket(portNumber);


            )

            {

                System.out.println(portNumber + ": Livre");

            } catch (IOException e){
                System.out.println(portNumber + ": Usado");

            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }

        }
    }
}
