import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) throws IOException {
        String str = "?name=Alex";
        String[] partsOfLink = str.split("=");
        System.out.print(partsOfLink[1]);
    }
        }

