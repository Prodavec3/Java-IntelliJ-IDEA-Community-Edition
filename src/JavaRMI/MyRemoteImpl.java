package JavaRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Наследование UnicastRemoteObject самый простой способ создать удаленный объект
 * Также нужно реализовать свой интерфейс (в нашем случае MyRemote)
 *
 * Необходимо реализовать все методы интерфейса, причем необязательно объявлять RemoteException на этом методе
 *
 * В объясвлении конструктора родительского класса UnicastRemoteObject содержится исключение,
 * поэтому нужно создавать свой конструктор, ведь его наличие говорит о вызове опасного кода (конструктора
 * его родительского класса.
 *
 * В main создаем удаленный объект, а затем помещаем его в реестр, используя статический метод
 * Naming.rebind(). Указанное имя будет использоваться клиентами для поиска оъекта в реестре RMI
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello(){
        return "Сервер говорит: 'Привет'";
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Удаленный привет", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
