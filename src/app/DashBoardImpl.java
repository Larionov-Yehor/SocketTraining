package app;

import web.HttpRequestContainer;
import web.handler.Handler;
import web.handler.HtmlPageGenerator;

/**
 * Created by employee on 11/11/16.
 */
public class DashBoardImpl extends HtmlPageGenerator implements Handler {


    public DashBoardImpl(HttpRequestContainer httpRequestContainer) {

    }

    @Override
    public String handle(HttpRequestContainer httpRequestContainer) {
        StringBuilder result = new StringBuilder();

        result.append(getStartOfHtmlFile());
        result.append(getHtmlPageContent());
        result.append(getCalendarLink());
        result.append(getGreaterLink());
        result.append(getEndOfHtmlFile());

        return result.toString();
    }
}
