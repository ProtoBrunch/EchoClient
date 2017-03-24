import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by berberatr on 22.03.2017.
 */
public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 50000;
        Socket client = null;
        Scanner scanner = new Scanner(System.in);
        String username;

        try{
            client = new Socket(host,port);
        }
        catch(IOException e){
            e.printStackTrace();
        }


        System.out.println("Bitte gib deinen Benutzernamen ein:");
        username = scanner.nextLine();
        new EchoClientWriter(client, username).start();
        new EchoClientListener(client).start();

    }
}
