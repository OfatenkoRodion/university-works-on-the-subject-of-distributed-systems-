package Java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;

public class GetURL {
    public static String getHTML(String urlAdress) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {

            String file="F:/4 курс ХАИ/4 curs lab/ПРС ЭВМ/Работы/info.txt";
            URL url = new URL(urlAdress);
            in = url.openStream();

            out = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int bytes_read;
            while((bytes_read = in.read(buffer)) != -1)
                out.write(buffer, 0, bytes_read);

            return  new String( buffer, Charset.forName("UTF-8") );
        }

        finally {
            try { in.close();
                out.close();
            } catch (Exception e) {
                return e.toString();

            }
        }
    }
}
