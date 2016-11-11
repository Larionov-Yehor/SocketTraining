package web;

import web.parser.Parser;
import web.router.Router;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/10/16.
 */
public class Server {

    private Parser parser;
    private Router router;
    private int port = 5555;

    /*public Server (Parser parser, Router router) throws IOException {
        this.parser = parser;
        this.router = router;
    }*/


   public void startServer() throws IOException {

       ServerSocket server = new ServerSocket(port);

        while(true) {

            Socket socket = server.accept();

            HttpRequestContainer httpRequest = parser.parse(socket.getInputStream());

            if(httpRequest.getPath().isEmpty()){

            }

            else{

            }
            //String path = PathReader.getPath(bufferedReader);
            //System.out.println(path);


            HtmlPageContentCreator htmlPageContentCreator = new HtmlPageContentCreator();
            //String htmlContent = htmlPageContentCreator.create(path);


           // socket.getOutputStream().write(htmlContent.toString().getBytes("UTF-8"));
            socket.close();

        }

   }
}
