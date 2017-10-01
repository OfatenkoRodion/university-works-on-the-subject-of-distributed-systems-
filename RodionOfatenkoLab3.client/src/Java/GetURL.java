package Java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class GetURL {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        try {
            // Проверка аргументов
         /*   if ((args.length != 1)&& (args.length != 2))
                throw new IllegalArgumentException(
                        "Wrong number of args");*/

            // Создаем объект URL
            String urlAdress="https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";
            String file="F:/4 курс ХАИ/4 curs lab/ПРС ЭВМ/Работы/info.txt";
            URL url = new URL(urlAdress);
            in = url.openStream();
            // Открываем его поток
           // if (args.length == 2)
                // Создаем поток вывода
                out = new FileOutputStream(file);
            //else out = System.out;

            // Копируем байты из URL в поток вывода
            byte[] buffer = new byte[4096];
            int bytes_read;
            while((bytes_read = in.read(buffer)) != -1)
                out.write(buffer, 0, bytes_read);
        }
        // Обрабатываем ошибки
        catch (Exception e) {
            System.err.println(e);
            System.err.println(
                    "Usage: java GetURL <URL> [<filename>]");
        }

        // Всегда закрываем потоки ввода-вывода
        finally {
            try { in.close();
                out.close();
            } catch (Exception e) {}
        }
    }
}
