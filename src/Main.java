import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/9/16.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        int requestNumber = 0;
        String str = null;
        ServerSocket server = new ServerSocket(5555);
        System.out.println("Listening for connection on port 5555 ....");
        while (true) {
            try (Socket socket = server.accept()){

                requestNumber++;


//get the socket's ouput
                PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
//get the socket's input
                BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));


                str =in.lines().findFirst().orElse("1");

                
              //s -> System.out.println(s));
              //  System.out.print(answer.get(1));



                String httpResponse = ""+"Hello world! Times: " + requestNumber;

                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));

                socket.close();

            }
        }


    }
        }

