import Calendar.HtmlCalendar;

/**
 * Created by employee on 11/10/16.
 */
public class HtmlPageContentCreator {

    private final String startOfHtmlFile = "<!DOCTYPE html>\n" +
            "<head><style>td.weekend {\n" + "    color: red;\n" + "}\n" + "\n" + "td.currentDay {\n" + "    color: cyan;\n" +
            "}\n" + "td.anotherMonthColor {\n" + " color: orange;\n" + "}\n" + "\n" + "td {\n" + "  padding: 5px;\n" +
            "}</style>" + "</head>" + "<html><body>";

    private final String endOfHtmlFile = "</body>\n</html>\n";
    private final String greaterLink = "<a href=\"greater\">greater</a><br>";
    private final String calendarLink = "<a href=\"calendar\">calendar</a>";





    public String create(String path){

       StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startOfHtmlFile);

        if (PathReader.isFirstPagePath(path)) {
            System.out.println(path);
            stringBuilder.append(getHtmlPageContent());
            stringBuilder.append(greaterLink);
            stringBuilder.append(calendarLink);
        }

        if (PathReader.isGreaterPagePath(path)) {
            stringBuilder.append(getHtmlGreaterPageContent());
        }

        if (PathReader.isNamePagePath(path)) {
            stringBuilder.append(getHtmlGreaterPageContent());
            stringBuilder.append(Parser.parseName((path)));
        }

        if (PathReader.isCalendarPagePath(path)) {
            HtmlCalendar htmlCalendar = new HtmlCalendar();
            stringBuilder.append(getHtmlCalendarPageContent());
            stringBuilder.append(htmlCalendar.returnCalendarTable());
        }
        stringBuilder.append(endOfHtmlFile);

        return stringBuilder.toString();
    }




    public static String getHtmlPageContent() {
        return   "<form action=\"/\">";
    }

    public static String getHtmlCalendarPageContent() {
        return   "<form action=\"/calendar\">";
    }

    public static String getHtmlGreaterPageContent() {
        return "<form action=\"/greater\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" value=\"great\"></form> ";
    }


    public String getStartOfHtmlFile() {
        return startOfHtmlFile;
    }

    public String getEndOfHtmlFile() {
        return endOfHtmlFile;
    }

    public String getGreaterLink() {
        return greaterLink;
    }

    public String getCalendarLink() {
        return calendarLink;
    }
}
