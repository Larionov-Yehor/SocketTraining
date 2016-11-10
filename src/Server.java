import java.net.ServerSocket;

/**
 * Created by employee on 11/10/16.
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5555);
            do {
                new SocketsThread(serverSocket.accept());
            }while (true);


        }catch (Exception e){e.printStackTrace();}
    }
}
