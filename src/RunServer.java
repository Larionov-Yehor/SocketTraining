import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by employee on 11/10/16.
 */
public class RunServer {
    public static String startOfHtmlFile = "<!DOCTYPE html>\n" +
            "<head><style>td.weekend {\n" + "    color: red;\n" +  "}\n" +  "\n" +"td.currentDay {\n" +    "    color: cyan;\n" +
            "}\n" +  "td.anotherMonthColor {\n" +   " color: orange;\n" +  "}\n" +    "\n" +"td {\n" + "  padding: 5px;\n" +
            "}</style>" +  "</head>" + "<html><body>";

    public static String endOfHtmlFile = "</body>\n</html>\n";


    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5555);
            System.out.println("Server is on");
            while (true){
                Socket socket = server.accept();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(startOfHtmlFile);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String incomingLink = bufferedReader.readLine().split(" ")[1];

                if(incomingLink.equals("/")){
                    stringBuilder.append(getHtmlPageContent());
                }
                else {
                    stringBuilder.append(parseTheLink(incomingLink));
                }

                stringBuilder.append(endOfHtmlFile);
                socket.getOutputStream().write(stringBuilder.toString().getBytes("UTF-8"));
                bufferedReader.close();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  String getHtmlPageContent(){

        return
                "<form action=\"/\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" value=\"great\"></form> "
           //      "<input type=\"submit\" value=\"view calendar\" onclick=\"window.location='calendar/';\" /> "
                ;
    }

    public static String parseTheLink(String link){
        String result = null;
        if(link.contains("name")) {

            String[] partsOfLink = link.split("=");
            try {
                result = partsOfLink[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return "Hello Mr. Incognito";
            }
        }
            return result;


    }
}
