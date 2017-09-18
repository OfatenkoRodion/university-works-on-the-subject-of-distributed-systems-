import java.io.*;
import java.net.*;

public class TCP_Client {

    private BufferedReader is = null;
    private PrintWriter printWriter = null;
    private Socket socket=null;

    public String sentCommandToServer(String command) throws IOException {
        printWriter.println(command);
        printWriter.flush();
        return is.readLine();
    }
    public void finishWork() throws IOException {
        is.close();
        printWriter.close();
        socket.close();
    }
    public void setIs(BufferedReader is) {
        this.is = is;
    }
    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
