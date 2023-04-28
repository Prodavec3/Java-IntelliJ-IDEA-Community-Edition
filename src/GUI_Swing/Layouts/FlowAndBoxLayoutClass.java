package GUI_Swing.Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

public class FlowAndBoxLayoutClass {
    public static void main(String[] args) {
        FlowAndBoxLayoutClass gui = new FlowAndBoxLayoutClass();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        // Поменяем Flow на BoxLayout, чтобы 2 кнопки были друг под другом, а не в ряд, указываем по Y
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Кнопка на панели");
        JButton button2 = new JButton("Вторая");

        panel.add(button);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}