import org.junit.After;
import org.junit.Before;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import web.parser.ParserImpl;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

/**
 * Created by employee on 11/11/16.
 */

public class ParserTests {

 /*  @Before

   @After
    ParserImpl parser = new ParserImpl();*/

   @Test
   public void assertParserCorrectOutput(){

       ParserImpl parser = new ParserImpl();
       String dashBoardPath = "";
       Map<String, String> dashBoardOneElementMap = parser.parseParameters(dashBoardPath);
       String dashBoardValue = dashBoardOneElementMap.get("0");

        try {

            InputStream inputStream = new ByteArrayInputStream(dashBoardPath.getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String path = reader.readLine();
            System.out.print(path);


          //  parser.parse(inputStream);

        }catch (IOException e){
            e.printStackTrace();
        }
       assertThat(dashBoardValue, equalTo("0"));

   }








}
