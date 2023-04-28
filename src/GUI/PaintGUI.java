package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PaintGUI extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    /**
     * JPanel - виджет, который можно добавить во фрейм. Личный пользовательский виджет.
     *
     * Graphics g, g - "машина для рисования"
     */

    public void paintComponent(Graphics g){

        // Заливка
        g.setColor(Color.CYAN);
        g.fillRect(20,50,100,100); // Координаты и местоположение


        // Картинка
        Image image = new ImageIcon("java.png").getImage();
        g.drawImage(image, 3,4,this); // Отступ 3 пиксела от левого края, 4 от верхнего


        //Рисуем на черном фоне круг произвольного цвета
        Random random = new Random();
        g.fillRect(0,0,this.getWidth(), this.getHeight()); // Полностью закрасить
        int red = (int) (random.nextInt(256));
        int green = (int) (random.nextInt(256));
        int blue = (int) (random.nextInt(256));

        Color randomColor = new Color(red,green,blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100); // Овал рисуем, т.к размеры одинаковые ху - круг


        // Градиент
        Graphics2D g2d = (Graphics2D) g; // указываем его чтобы иметь возможность вызывать методы из 2D, чего нет в Graphics
        GradientPaint gradientPaint = new GradientPaint(70,70,Color.BLUE, 150,150,Color.orange);
        // Начальная точка (70,70), Начальный цвет, конечная точка (150,150), конечный цвет
        g2d.setPaint(gradientPaint); // Назначаем градиент вместо сплошного цвета
        g2d.fillOval(70,70,100,100); // красим градиентом

    }
}