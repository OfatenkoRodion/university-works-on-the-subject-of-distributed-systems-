import java.io.*;
import java.net.*;

public class ServerUDP {
    DatagramSocket udp_socket = null;
    DatagramPacket receive_packet = null;
    DatagramPacket send_packet = null;
    InetAddress iaddr = null;
    int port ;
    String msg = null;
    int buff_length = 512;
    byte [] buff = new byte [buff_length];

    /** Создает экземпляр эхо-сервера UDP.
     * @param port  порт сервера.
     */
    public ServerUDP (int port) {
        this.port = port;
        try {
            //Получаем IP-адрес локального компьтера
            iaddr = InetAddress.getLocalHost ();
        }
        catch (UnknownHostException e) {
            e.printStackTrace ();
        }
        try {
            //Создаем дейтаграммный сокет на заданном порту
            udp_socket = new DatagramSocket (port);
            //Отправляем сообщения о запуске сервера на консоль
            System.out.println ("The server is started ...");
            System.out.println ("Server IP : " + iaddr +
                    " Server listen port : " + port);
            //Создаем контейнер для приема пакетов клиентов
            receive_packet = new DatagramPacket (buff, buff_length);
            boolean done = false;
            while (!done) {
                //Ожидаем прихода пакета
                udp_socket.receive (receive_packet);
                //Извлекаем из пакета сообщение
                msg = new String (receive_packet.getData(), 0,
                        receive_packet.getLength());
                //Принятые данные выводим на консоль
                System.out.println("Receive from: " +
                        receive_packet.getAddress() +
                        " message : " + msg);
                //Проверка на завершение работы
                if (msg.trim().equals ("quit")) {
                    done = true;
                }
                //Подготавливаем пакет для отправки клиенту
                send_packet=new DatagramPacket(receive_packet.getData(),
                        receive_packet.getLength(),
                        receive_packet.getAddress(),
                        receive_packet.getPort());
                //Отправляем пакет клиенту
                udp_socket.send (send_packet);
                //Протокольное сообщение выводим на консоль
                System.out.println("Send to : " +
                        receive_packet.getAddress() +
                        " message : " + msg);
            }
            // Закрываем сокет сервера
            udp_socket.close ();
            //Выводим на консоль сообщение об окончании работы сервера
            System.out.println ("The server is stopped ...");
        }
        catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public static void main (String [] args) {
        int server_port = 5555;  // Номер порта сервера по умолчанию
        if (args.length !=0) {
            //Извлекаем номер порта сервера из списка параметров
            server_port = Integer.parseInt (args [0]);
        }
        //Создаем экземпляр дейтаграммного эхо-сервера
        ServerUDP serverUDP = new ServerUDP (server_port);
    }
}
