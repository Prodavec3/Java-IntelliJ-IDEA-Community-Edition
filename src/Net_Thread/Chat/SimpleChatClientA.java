package Net_Thread.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Версия чата, которая умеет отправлять сообщения на сервер, но не способна принимать их от других участников
 */

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public void go(){
        JFrame frame = new JFrame("Ludicrously Simple Chat Client"); // JFrame окно с рамкой
        JPanel mainPanel = new JPanel(); // JPanel контейнер, который группирует набор компонентов вместе
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel); //gCP возвращает контейнер для исп. метода add

        setUpNetworking();

        frame.setSize(400,500);
        frame.setVisible(true);
    }

    private void setUpNetworking(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Networking established");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println(outgoing.getText());
            writer.flush();

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}