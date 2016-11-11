package web;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class PathReader {

    public static String getPath(BufferedReader bufferedReader) throws IOException {

        String result = null;

            result = bufferedReader.readLine().split(" ")[1];

        return result;
    }

    public static boolean isFirstPagePath(String path){
        if(path.equals("/")){
            return true;
        }
    return false;
    }

    public static boolean isGreaterPagePath(String path){
        if (path.equals("/greater")){
            return true;
        }
    return false;
    }

    public static boolean isCalendarPagePath(String path){
        if(path.equals("/calendar")){
            return true;
        }
        return false;
    }

    public static boolean isNamePagePath(String path){
        if(path.contains("name")){
            return true;
        }
        return false;
    }







}
