import java.io.*;
import java.net.*;

/**
 * Демонстрация потоковых сокетов
 * Обработчик протокола эхо-сервера TCP/IP
 */
public class TCP_Server_Handler implements Runnable {
    String msg = null;
    private boolean done = false;
    private Socket cs = null;
    private BufferedReader is = null;
    private PrintWriter os = null;
    public TCP_Server_Handler(Socket cs) {
        this.cs = cs;
        try {
            //Получаем ссылки на потоки ввода/вывода
            is = new BufferedReader(
                    new InputStreamReader(cs.getInputStream()));
            os = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(cs.getOutputStream())));
        }
        catch (IOException e) {
            System.out.println("Error create I/O Streams" + e);
        }
        new Thread (this).start();
        System.out.println("Start new TCP_Handler_Server");
    }
    public void run () {
        //Выполняем обработку соединения в отдельном потоке
        try {
            while (!done) {
                msg = is.readLine();
                System.out.println("Receive from client : " + msg);
                os.println(CommandSelection.select(msg));
                os.flush();

                if (msg.equals("end")) {
                    done = true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error I/O" + e);
        }
        finally {
            //Закрываем потоки ввода/вывода и сокет клиента
            try {
                is.close();
                os.close();
                cs.close();
                System.out.println("Client " + cs + "disconnected");
            }
            catch (IOException e) {
                System.out.println("Error I/O close client Sockets");
            }
        }
    }
}
