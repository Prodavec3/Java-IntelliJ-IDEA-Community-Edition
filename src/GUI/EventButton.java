package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventButton implements ActionListener { // Реализуем интерфейс, кнопка будет передавать события только его реализующим
    JButton button;
    public static void main(String[] args) {
        EventButton gui = new EventButton();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Нажми на кнопку");

        button.addActionListener(this); // Регистрируем кнопку для прослушки. Объект в аргументе должен реализовывать интрфейс AL

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Кнопка нажата");
    }
}
