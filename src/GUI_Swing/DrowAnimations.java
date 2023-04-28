package GUI_Swing;

import javax.swing.*;
import java.awt.*;

public class DrowAnimations {
    int x, y = 70;

    public static void main(String[] args) {
        DrowAnimations gui = new DrowAnimations();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i = 0; i < 200; i++){
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            /**
             * Для анимации небходимо менять координаты объекта (х и у у нас увеличиваются и так,
             * и необходимо также стирать старое положение - закрашивать белым цветом
             */
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            g.setColor(Color.GREEN);
            g.fillOval(x,y,40,40);
        }
    }
}
