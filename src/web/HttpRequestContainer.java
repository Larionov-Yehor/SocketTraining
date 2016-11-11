package web;

import java.util.Map;

/**
 * Created by employee on 11/11/16.
 */
public class HttpRequestContainer {

    private String path;
    private Map<String,String> parameters ;


    public HttpRequestContainer(String path, Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
