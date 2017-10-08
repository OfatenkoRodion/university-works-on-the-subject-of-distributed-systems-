package com.RodionOfatenko;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        if (System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            MyRemoteInterface stub = (MyRemoteInterface) registry.lookup("MyRemoteObject");

            System.out.println(stub.getIncrease(1));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
