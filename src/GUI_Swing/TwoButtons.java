package GUI_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 2 кнопки делают разные действия
 * чтобы следить за 2мя разными кнопками реализуем 2 класса, которые будут от интерфейса ActionListener
 *
 * Внутренние классы позволяют реализовать один и тот же интерфейс в классе.
 *
 * Для реализации 3х кнопок надо будет 3 класса с интерфейсом ActionListener
 */

public class TwoButtons {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Изменить надпись");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Изменить цвет");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("Текст");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Нажал на кнопку");
        }
    }

    class ColorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

}
