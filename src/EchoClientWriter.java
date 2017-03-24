import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by berberatr on 23.03.2017.
 */
public class EchoClientWriter extends Thread{
    Socket client;
    PrintWriter out;
    Scanner scanner;
    String username;

    EchoClientWriter(Socket client, String username){
        try{
            this.client = client;
            this.username = username;
            out = new PrintWriter(client.getOutputStream(),true);
            scanner = new Scanner(System.in);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println("Writer Online");
        String input;

        while(true){
            input = scanner.nextLine();
            input = (username+": "+input);
            out.println(input);
        }
    }
}

