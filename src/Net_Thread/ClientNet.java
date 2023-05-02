package Net_Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Чтобы подключиться к другому ПК необходимо установить  соединение через сокет.
 * Сокет (класс java.net.Socket) это объект, представляющий сетевое соединение между двумя ПК.
 * Это отношения между двумя узлами, программиное обеспечение которых знает о сущетвовании друг друга.
 *
 * Чтобы создать соединение через сокет нужно знать 2 вещи - где он находится и на каком порту работает (IP + №порта)
 *
 * Socket chatSocket = new Socket("196.164.1.103", 5000); IP, № TCP port
 *
 * Соединение с помощью сокета подразумевает, что у двух ПК есть информация о друг друге, включая сетевое местоположение и порт ТСР.
 *
 * Порт TCP это просто 16-битное число, с помощью которого распознается конкретная программа на сервере.
 *
 * Без номера порта сервер не сможет узнать к какому приложению хочет подключиться клиент.
 *
 * Требование - порт должен быть между 1024 и 65535
 *
 * Аналогия: IP это ТЦ, порт - конкретный магазин.
 */
public class ClientNet {

    public void go(){
        try {
            Socket s = new Socket("127.0.0.1", 4242); // сокет создаем для локалхоста

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Данные: " + advice);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientNet clientNet = new ClientNet();
        clientNet.go();
    }
}
