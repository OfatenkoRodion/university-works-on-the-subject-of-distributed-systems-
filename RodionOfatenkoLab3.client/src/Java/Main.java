package Java;

import java.net.URL;

import static Java.GetURLInfo.printinfo;

public class Main {
    public static void main(String[] args) {
        try {
            String url="https://zf.fm";
            printinfo(new URL(url));
        }
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java GetURLInfo <url>");
        }
    }

}
