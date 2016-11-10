import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/10/16.
 */
public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(5555);
        System.out.println("ServerSocket is running on port: " + server.getLocalPort());

        while (true) {

            Socket socket = server.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String path = PathReader.getPath(bufferedReader);
            System.out.println(path);


            HtmlPageContentCreator htmlPageContentCreator = new HtmlPageContentCreator();

            String htmlContent = htmlPageContentCreator.create(path);

           //
           socket.getOutputStream().write(htmlContent.toString().getBytes("UTF-8"));
            socket.close();
        }

    }

}
