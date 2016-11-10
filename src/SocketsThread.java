import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by employee on 11/10/16.
 */
public class SocketsThread extends Thread {
    private Socket serverSocket=null;

    public SocketsThread(Socket serverSocket){
        this.serverSocket=serverSocket;
        this.start();
    }

    @Override
    public void run(){
        try {
            InputStream is = serverSocket.getInputStream();
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line;


            int postDataI = -1;
            while ((line = in.readLine()) != null && (line.length() != 0)) {
                if (line.contains("Content-Length:")) {
                    postDataI = Integer.parseInt(line.substring(
                            line.indexOf("Content-Length:") + 16,
                            line.length()));
                }
            }
            String postData = "";

            if (postDataI > 0) {
                char[] charArray = new char[postDataI];
                in.read(charArray, 0, postDataI);
                postData = new String(charArray);
                postData = postData.substring(5);
            }

           // out.println(getHTMLPage());

            out.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}