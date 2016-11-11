package web.router;

import app.DashBoardImpl;
import web.HttpRequestContainer;
import web.handler.Handler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by employee on 11/11/16.
 */
public class RouterImpl implements Router{

    private Map<String, Function<HttpRequestContainer, Handler>> routes = new HashMap<>();

    @Override
    public void register(String path, Function<HttpRequestContainer, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String dispatch(HttpRequestContainer httpRequest) {

        Handler handler = null;

        if (routes.get("0").equals("0")){

            handler = new DashBoardImpl(httpRequest);
        }
       // if (routes.containsKey(httpRequest.getPath())){
        else{

            handler = routes.get(httpRequest.getPath()).apply(httpRequest);

        }

        return handler.handle(httpRequest);
    }
}


