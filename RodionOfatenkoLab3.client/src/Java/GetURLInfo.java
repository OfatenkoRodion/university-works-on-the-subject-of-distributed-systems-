package Java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class GetURLInfo {
    public static String getURL_info(URL url) throws IOException {
        URLConnection c = url.openConnection();
        c.connect();
        String msg="";
        msg+="  Content Type: " + c.getContentType()+"\r\n";
        msg+="  Content Encoding: " + c.getContentEncoding()+"\r\n";
        msg+="  Content Length: " + c.getContentLength()+"\r\n";
        msg+="  Date: " + new Date(c.getDate())+"\r\n";
        msg+="  Last Modified: " + new Date(c.getLastModified())+"\r\n";
        msg+="  Expiration: " + new Date(c.getExpiration())+"\r\n";
        if (c instanceof HttpURLConnection) {
            HttpURLConnection h = (HttpURLConnection) c;
            msg+="  Request Method: " + h.getRequestMethod()+"\r\n";
            msg+="  Response Message: " + h.getResponseMessage()+"\r\n";
            msg+="  Response Code: " + h.getResponseCode()+"\r\n";
        }
        return msg;
    }
}
