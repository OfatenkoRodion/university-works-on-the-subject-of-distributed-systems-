package Client;


import Server.RemoteInterface;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 * <p>Title: Клиент для удаленного калькулятора</p>
 * <p>Description: Демонстрирует работу с CalcServer</p>
 * <p>Copyright: Copyright (c)  RAA 2005</p>
 * <p>Company: Home</p>
 * @author RAA
 * @version 1.0
 */

public class RemoteClient {
    String host = "localhost";
    String port = "900";
    public RemoteClient() {
        // Настраиваем JNDI
        Properties p = System.getProperties();
        // Указываем фабрику начального контекста
        p.put("java.naming.factory.initial",
                "com.sun.jndi.cosnaming.CNCtxFactory");
        // Указываем, URL-строку для службы имен
        p.put("java.naming.provider.url",
                "iiop://" + host + ":" + port);
        // Получаем ссылку на удаленный объект в службу имен, используя JNDI API
        try {
            Context initContext = new InitialContext();
            Object remoteClassRef = initContext.lookup("RemoteInterface");
            RemoteInterface remoteInterface = (RemoteInterface) PortableRemoteObject.narrow(remoteClassRef, RemoteInterface.class);
            System.out.println("ADD : " + remoteInterface.add ("Tom","persian",5));
            System.out.println("ADD : " + remoteInterface.add ("Pushok","red",3));
            System.out.println("ADD : " + remoteInterface.add ("Murka","usual",1));
            System.out.println("GET_ALL : " + remoteInterface.get_all());
        }
        catch (NamingException e) {
            System.out.println("CalcClient Error : " +
                    "Service Calc not found in NameService ");
        }
        catch (RemoteException e) {
            System.out.println("CalcClient Error : " +
                    "Service CalcClient not found in NameService ");
        }
    }
    public static void main(String[] args) {
        RemoteClient calcClient1 = new RemoteClient();
    }

}