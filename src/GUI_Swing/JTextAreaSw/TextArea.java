package GUI_Swing.JTextAreaSw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea implements ActionListener {

    JTextArea textArea;

    public static void main(String[] args) {
        TextArea gui = new TextArea();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Кликни на кнопку");
        button.addActionListener(this);
        textArea = new JTextArea(10,20); // rows это высота, col - ширина
        textArea.setLineWrap(true); // Включили перенос текста

        JScrollPane scrollPane = new JScrollPane(textArea); // создаем
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER); // не использовать вертикальную полосу прокрутки
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // не исп. горизотальную пол. прокр.

        panel.add(scrollPane); // Присваиваем объекту JScrollPane текстовую область и затем доавбляем область прокрутки на панель
        // Мы не добавляем текстовую область непосредственно на панель

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append("Кнопка нажата \n");
    }
}
