package com.RodionOfatenko;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        if (System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        MyRemoteInterface myRemoteInterface = new MyRemoteObject();

        try {
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(myRemoteInterface,0);
            Registry registry = LocateRegistry.createRegistry(1099);


                registry.bind("MyRemoteObject",stub);
                System.out.println("MyRemoteObject bound");


        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

interface MyRemoteInterface extends Remote{
    Integer getIncrease(Integer number) throws RemoteException;
}

class MyRemoteObject implements MyRemoteInterface
{
    @Override
    public Integer getIncrease(Integer number) throws RemoteException {
        return number+1;
    }
}