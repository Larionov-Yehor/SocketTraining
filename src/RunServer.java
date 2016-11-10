import Calendar.HtmlCalendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;


/**
 * Created by employee on 11/10/16.
 */
public class RunServer {
    public static String startOfHtmlFile = "<!DOCTYPE html>\n" +
            "<head><style>td.weekend {\n" + "    color: red;\n" +  "}\n" +  "\n" +"td.currentDay {\n" +    "    color: cyan;\n" +
            "}\n" +  "td.anotherMonthColor {\n" +   " color: orange;\n" +  "}\n" +    "\n" +"td {\n" + "  padding: 5px;\n" +
            "}</style>" +  "</head>" + "<html><body>";

    public static String endOfHtmlFile = "</body>\n</html>\n";

    public static String greaterLink = "<a href=\"greater\">greater</a>   ";

    public static String calendarLink = "<a href=\"calendar\">calendar</a>";


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

                System.out.println(incomingLink);

                if(incomingLink.equals("/")) {

                    stringBuilder.append(getHtmlPageContent());
                    stringBuilder.append(greaterLink);
                    stringBuilder.append(calendarLink);
                    }

                if(incomingLink.equals("/greater")){

                    incomingLink = bufferedReader.readLine().split(" ")[1];
                    stringBuilder.append(getHtmlGreaterPageContent());

                }

                if(incomingLink.contains("name")){
                    stringBuilder.append(getHtmlGreaterPageContent());
                    stringBuilder.append(parseTheLink(incomingLink));
                }

                if(incomingLink.equals("/calendar")){

                 incomingLink = bufferedReader.readLine().split(" ")[1];

                    stringBuilder.append(getHtmlCalendarPageContent());

                    HtmlCalendar htmlCalendar = new HtmlCalendar();
                   stringBuilder.append(htmlCalendar.returnCalendarTable());
                }


                stringBuilder.append(endOfHtmlFile);
                socket.getOutputStream().write(stringBuilder.toString().getBytes("UTF-8"));
                bufferedReader.close();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  String getHtmlGreaterPageContent(){

        return
                "<form action=\"/greater\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" value=\"great\"></form> "

                ;
    }


    public static  String getHtmlPageContent(){

        return
                "<form action=\"/\">" ;
    }

    public static  String getHtmlCalendarPageContent(){

        return
                "<form action=\"/calendar\">" ;
    }

    public static String parseTheLink(String link){

        String result = null;
        if(link.contains("name")) {

            String[] partsOfLink = link.split("=");
            try {
                String name = null;
                name = partsOfLink[1];
                result = URLDecoder.decode(name, "UTF-8");

            } catch (ArrayIndexOutOfBoundsException e) {
                return "Hello Mr. Incognito";
            }
            catch (UnsupportedEncodingException e){}
        }
            return "Hello Mr."+result;


    }
}
