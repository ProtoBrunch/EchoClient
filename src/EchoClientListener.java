import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by berberatr on 23.03.2017.
 */
public class EchoClientListener extends Thread{
    Socket client;
    BufferedReader in;

    EchoClientListener(Socket client){
        try{
            this.client = client;
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Buffered Reader Online");
        while (true) {
            try {
                System.out.println(in.readLine());
            } catch (SocketException se){
                System.out.println("Lost Connection to Server");
                this.interrupt();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
