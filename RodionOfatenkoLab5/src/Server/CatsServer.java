package Server;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.RMISecurityManager;
import java.util.Hashtable;

/**
 * <p>Title: Удаленнный калькулятор</p>
 * <p>Description: Определение сервера для удаленного объекта-калькулятора </p>
 * <p>Copyright: Copyright (c)  RAA 2005</p>
 * <p>Company: Home</p>
 * @author RAA
 * @version 1.0
 */
public class CatsServer {                               //!!!!! Не работает код примера? Читай "READ ME lab5.txt"
    String host = "localhost"; //хост службы имен
    String port = "900";       //порт службы имен
    public CatsServer() {
        // Установка менеджера безопасности
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            // Создаем серверный объект, в котором реализованы
            // методы удаленного интерфейса калькулятора
            RemoteInterface rf = new RemoteClass();
            // Регистрируем этот объект в службе имен
            // Используем JNDI API для регистрации объекта
            // в сервисе имен СORBA CosNaming
            // Настраиваем JNDI
            Hashtable ht = new Hashtable();
            // Указываем фабрику начального контекста
            ht.put("java.naming.factory.initial",
                    "com.sun.jndi.cosnaming.CNCtxFactory");
            // Указываем, URL-строку для службы имен
            ht.put("java.naming.provider.url",
                    "iiop://" + host + ":" + port);
            // Устанавливаем начальный контекст
            Context initContext = new InitialContext (ht);
            // Заносим ссылку на удаленный объект в службу имен, используя API JNDI
            initContext.rebind ("RemoteInterface", rf);
            // Выдаем сообщение на консоль об успешной регистрации и запуске сервера
            System.out.println ("The object: RemoteClass is registered in service of names");
            System.out.println ("RemoteClass is ready ...");
        }
        catch (Exception e) {
            System.out.println ("RemoteClass error : " + e.getMessage ());
            e.printStackTrace ();
        }
    }
    public static void main(String[] args) {
        CatsServer calc = new CatsServer();
    }
}