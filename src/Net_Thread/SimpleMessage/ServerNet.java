package Net_Thread.SimpleMessage;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Подняли сервер (запустили) - далее клиент.
 *
 * Программа создает ServerSocket и ожидает клиентские запросы. При получении такого запроса (когда клиент выполнил
 * для этого приложения new Socket()) сервер создает объект Socket и устанавливает соединение с этим клиентом.
 *
 * Сервер создает экземпляр Print Writer (с помощью исходящего потока из сокета) и отправляет клиенту сообщение.
 */
public class ServerNet {
    String[] adviceList = {"Данные1","Данные2", "Данные3", "Данные4", "Данные5", "Данные6", "Данные7", "Данные8"};

    private void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(4242); // теперь отслеживаем порт 4242 на этом ПК
            System.out.println("Сервер прослушивает порт");
            /**
             * Сервер входит в постоянный цикл, ожидая подключений клиентских (и обслуживая их)
             *
             * Метод accept() блокирует приложение до тех пор, пока не поступит запрос, после чего возвращает сокет
             * (на анонимном порту) для взаимодействия с клиентом
             *
             * 33 и далее строками мы используем соединение объекта Socket с клиентом для создания экземпляра PrintWriter
             * после чего отправляем с его помощью println() строку с ответом. Затем сокет закрываем, т.к работа
             * с клиентом закончена
             */
            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        ServerNet serverNet = new ServerNet();
        serverNet.go();
    }
}
