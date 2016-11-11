package web.router;

import web.HttpRequestContainer;
import web.handler.Handler;

import java.util.function.Function;

/**
 * Created by employee on 11/11/16.
 */
public interface Router {

    public String dispatch(HttpRequestContainer httpRequestContainer);

    public void register(String path, Function<HttpRequestContainer, Handler> handlerFactory);

}
