package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iCommand extends Remote {
    String sentCommand(String command) throws RemoteException;
}
