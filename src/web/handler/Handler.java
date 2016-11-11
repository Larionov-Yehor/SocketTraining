package web.handler;

import web.HttpRequestContainer;

/**
 * Created by employee on 11/11/16.
 */
public interface Handler {

    public String handle(HttpRequestContainer httpRequestContainer);

}
