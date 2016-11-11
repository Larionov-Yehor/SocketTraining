package web.parser;

import web.HttpRequestContainer;
import web.handler.HtmlPageGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by employee on 11/11/16.
 */
public class ParserImpl extends HtmlPageGenerator implements Parser{

    public String getPath(String path){

        int lastSlashIndex = path.lastIndexOf("/");
        return path.substring(0, lastSlashIndex == 0 ? path.length() : lastSlashIndex);
    }

    @Override
    public HttpRequestContainer parse(InputStream inputStream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String path = reader.readLine();

        Map<String,String> map = new HashMap<>();
        map.put("a","b");



        return new HttpRequestContainer(getPath(path),map);
    }

    @Override
    public Map<String, String> parseParameters(String path) {

        Map<String, String> result = new HashMap<>();

        if(path.equals("/")){
            result.put("0","0");
            return result;
        }


        int parametersIndex = path.indexOf("?");

        String string = path.substring(parametersIndex+1);

        String[] parameters = string.split("&");

        for(String parameterCouple: parameters){

            int index = parameterCouple.indexOf("=");

            String parameter1 = parameterCouple.substring(0, index);
            String parameter2 = parameterCouple.substring(index+1);

            result.put(parameter1,parameter2);

        }

        return result;
    }
}
