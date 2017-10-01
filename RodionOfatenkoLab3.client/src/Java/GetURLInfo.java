package Java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class GetURLInfo {
    public static void printinfo(URL url) throws IOException {
        // Получаем объект URLConnection from URL
        URLConnection c = url.openConnection();
        // Создаем подключение к URL
        c.connect();
        // Выводим на консоль информацию о содержимом URL
        System.out.println("  Content Type: " +
                c.getContentType());
        System.out.println("  Content Encoding: " +
                c.getContentEncoding());
        System.out.println("  Content Length: " +
                c.getContentLength());
        System.out.println("  Date: " + new Date(c.getDate()));
        System.out.println("  Last Modified: " +
                new Date(c.getLastModified()));
        System.out.println("  Expiration: " +
                new Date(c.getExpiration()));
        // Если это HTTP-подключение,
        // отображаем некоторую дополнительную информацию
        if (c instanceof HttpURLConnection) {
            HttpURLConnection h = (HttpURLConnection) c;
            System.out.println("  Request Method: " +
                    h.getRequestMethod());
            System.out.println("  Response Message: " +
                    h.getResponseMessage());
            System.out.println("  Response Code: " +
                    h.getResponseCode());
        }
    }
}
