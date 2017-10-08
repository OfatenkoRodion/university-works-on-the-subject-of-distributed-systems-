package Server;

import Cats.CommandSelection;

import java.rmi.RemoteException;

public class Command  implements iCommand{
    @Override
    public String sentCommand(String command) throws RemoteException {
        return CommandSelection.select(command);
    }
}
