import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by employee on 11/10/16.
 */
public class Parser {

    public static String parseName(String path) {

        String result = null;

        if (path.contains("name")) {

            String[] partsOfLink = path.split("=");
            try {
                String name = null;
                name = partsOfLink[1];
                result = URLDecoder.decode(name, "UTF-8");

            } catch (ArrayIndexOutOfBoundsException e) {
                return "Hello Mr. Incognito";

            } catch (UnsupportedEncodingException e) {
            }
        }
        return "Hello Mr." + result;

    }

}
