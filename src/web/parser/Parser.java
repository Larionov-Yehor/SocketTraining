package web.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import web.*;



public interface Parser {

     public HttpRequestContainer parse(InputStream inputStream) throws IOException;
     public Map<String, String> parseParameters(String path) throws IOException ;

}
