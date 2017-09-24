import java.io.*;
import java.net.*;


public class ClientUDP {
    BufferedReader br = null;
    DatagramSocket udp_socket = null;
    DatagramPacket receive_packet = null;
    DatagramPacket send_packet = null;
    InetAddress iaddr = null;
    int port ;
    String msg = null;
    int buff_length = 512;
    //Буфер для приема/передачи пакетов
    byte [] buff = new byte [buff_length];
    /** Создает экземпляр клиента эхо-сервера UDP.
     * @param address    IP-адрес сервера
     * @param port       порт сервера.
     */
    public ClientUDP (String address, int port) {
        this.port = port;
        try {
            //Получаем IP-адрес машины, на которой запущен сервер
            iaddr = InetAddress.getByName (address);
        }
        catch (UnknownHostException e) {
            e.printStackTrace ();
        }
        try {
            //Создаем символьный поток для ввода с клавиатуры
            br = new BufferedReader(
                    new InputStreamReader(System.in));
            //Создаем датаграммный сокет на заданном порту
            udp_socket = new DatagramSocket ();
            //Создаем контейнер для приема пакетов от сервера
            receive_packet = new DatagramPacket (buff, buff_length);
            //Отправляем сообщения о запуске сервера на консоль
            System.out.println ("The client is started ...");
            System.out.println ("Client IP : " +
                    udp_socket.getLocalAddress() +
                    " Client listen port : " +
                    udp_socket.getLocalPort());
            boolean done = false;
            while (!done) {
                System.out.println("Enter message for sending" +
                        " on a server or quit:");
                //Ввод сообщения с клавиатуры
                msg = br.readLine ();
                //Отображение введенного сообщения на консоль
                System.out.println ("Input message : " + msg);
                //Проверка на завершение работы
                if (msg.trim().equals ("quit")) {
                    done = true;
                }
                //Преобразование сообщения в байтовый массив
                buff = msg.getBytes ();
                //Создаем контейнер для отправляемого пакета
                send_packet = new DatagramPacket (buff,
                        msg.length(),
                        iaddr, port);
                //Отправляем пакет на сервер
                udp_socket.send (send_packet);
                //Выводим сообщение на консоль
                System.out.println ("Send message : " + msg);
                //Ожидаем ответ от сервера
                udp_socket.receive (receive_packet);
                //Извлекаем принятое сообщение из пакета
                msg = new String (receive_packet.getData (), 0,
                        receive_packet.getLength ());
                //Выводим принятое сообщение на консоль
                System.out.println ("Receive from server : " + msg);
            }
            //Выводим на консоль сообщение об окончании работы клиента
            System.out.println ("The client is stopped ...");
        }
        catch (IOException e) {
            e.printStackTrace ();
        }
        finally {
            //Закрываем входной поток
            try {
                br.close ();
            } catch (IOException e) {
                System.out.println ("Error: can*t close ...");
            }
            //Закрываем сокет
            udp_socket.close ();
        }
    }

    /**
     * Запускает клиента дейтаграммного эхо-сервера
     * @param args список параметров командной строки
     */
    public static void main (String [] args) {
        //IP-адрес сервера по умолчанию
        String address = "localhost";
        //Порт сервера по умолчанию
        int server_port = 5555;
        if (args.length == 2) {
            //Извлекаем адрес и номер порта сервера из списка параметров
            address = args [0];  // адрес
            server_port = Integer.parseInt (args [1]);
        }
        // Создаем экземпляр клиента для дейтаграммного эхо-сервера
        ClientUDP clientUDP = new ClientUDP (address, server_port);
    }
}
