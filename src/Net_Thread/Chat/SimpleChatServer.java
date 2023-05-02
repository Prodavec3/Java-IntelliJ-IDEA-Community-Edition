package Net_Thread.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {
    ArrayList clientOutputStreams;

    public class ClientHandler implements Runnable{
        BufferedReader reader;
        Socket socket;

        @Override
        public void run() {
            String message;

            while (true){
                try {
                    if (!((message = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Сообщение с клиента:\n" + message);
                tellEveryone(message);
            }
        }

        public ClientHandler(Socket clientSocket){
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleChatServer().go();
    }

    public void go(){
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true){
                Socket clientSocket = serverSocket.accept(); // Блокирует программу и ждет подключения клиента по порту
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t =new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void tellEveryone(String message){
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()){
            PrintWriter writer = (PrintWriter) it.next();
            writer.println(message);
            writer.flush();
        }
    }
}
