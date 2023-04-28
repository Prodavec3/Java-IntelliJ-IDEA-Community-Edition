package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChangeColorAfterButtonClick implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        ChangeColorAfterButtonClick gui = new ChangeColorAfterButtonClick();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Поменять цвет");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g){
        Random random = new Random();
        g.fillRect(0,0,this.getWidth(), this.getHeight());
        int red = (int) (random.nextInt(256));
        int green = (int) (random.nextInt(256));
        int blue = (int) (random.nextInt(256));
        Color randomColor = new Color(red,green,blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
}
