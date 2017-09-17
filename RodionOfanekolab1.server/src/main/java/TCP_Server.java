import java.io.*;
import java.net.*;
/**
 * Демонстрация потоковых сокетов
 * Простой эхо-сервер TCP/IP
 * Синтаксис командной строки для запуска программы-сервера:
 * java tcp.TCP_Server [<номер_порта>]
 */
public class TCP_Server {
    private int port = 0;
    private ServerSocket ss = null;
    private Socket cs = null;
    public TCP_Server(int port) {
        this.port = port;
    }
    private void startServer () {
        try {
            //Серверный сокет для прослушивания входящих соединений
            ss = new ServerSocket (port);
            System.out.println("TCP_Server started ...");
        }
        catch (IOException e) {
            System.out.println("Error created ServerSocket" + e);
        }
        try {
            while (true) {
                System.out.println("TCP_Server is ready...");
                //Ожидаем установления соединения
                cs = ss.accept();
                System.out.println("New connection to remotehost " +
                        cs.getInetAddress() + " port : " +
                        cs.getPort());
                //Для данного cоединения запускаем новый обработчик
                new TCP_Server_Handler (cs);
            }
        }
        catch (IOException e) {
            System.out.println("Error accept ServerSocket" + e);
        }
        finally {
            try {
                ss.close();
            }
            catch (IOException e) {
                System.out.println("Error close ServerSocket" + e);
            }
        }
    }
    public static void main(String[] args) {
        int port = 9999;
        if (args.length !=0) {
            port = Integer.parseInt(args[0]);
        }
        new TCP_Server(port).startServer();
    }
}
