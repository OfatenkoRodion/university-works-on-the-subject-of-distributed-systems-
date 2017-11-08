package Server;

import Cats.Cat;
import Cats.Cats;

import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;

public class RemoteClass extends PortableRemoteObject implements RemoteInterface
{

    /**
     * Initializes the object by calling <code>exportObject(this)</code>.
     *
     * @throws RemoteException if export fails.
     */
    protected RemoteClass() throws RemoteException
    {
    }

    @Override
    public String add(String name,String breed, int age) throws RemoteException
    {
        Cats.getInstance().add(new Cat(name,breed,age));
        return "Successfully added";
    }
    @Override
    public String get_all() throws RemoteException
    {
        return Cats.getInstance().toString();
    }
    @Override
    public String dell_all() throws RemoteException
    {
        Cats.getInstance().clear();
        return "Successfully cleared";
    }
    @Override
    public String dell_by_id(int id) throws RemoteException
    {
        if (id>Cats.getInstance().size()-1)
        {
            return "Exeption: size of collection less then ID";
        }
        Cats.getInstance().remove(id);
        return "Deleted";
    }
}
