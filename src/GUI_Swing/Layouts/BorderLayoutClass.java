package GUI_Swing.Layouts;

import javax.swing.*;
import java.awt.*;

/**
 * 3 диспетчера компоновки:
 * BorderLayout - делит фоновый компонент на 5 обалстей. В каждую область можно добавить только 1 компонент.
 * Компоненты не имеют предпочтений по размерам. Данный диспетчер выбран по-умолчанию.
 *
 * FlowLayout - каждый компонент имеет желаемый размер, все размещаются слева направо в порядке добавления,
 * с возможностью переноса на новую стороку. По-умолчанию диспетчер компоновки для панели
 *
 * BoxLayout - все компоненты получают собственный размер и располагаются в порядке добавления. Однако позволяет расположить компоненты
 * вертикально (можно и горизонтально). Вместо автоматического переноса компонентов можно добавить разрыв строки и заставить компонент
 * перенестись на новую стороку
 */
public class BorderLayoutClass {
    public static void main(String[] args) {
        BorderLayoutClass gui = new BorderLayoutClass();
        gui.go();
    }
    public void go(){
        JFrame frame = new JFrame();

        JButton east = new JButton("East, информация");
        JButton west = new JButton("West");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton center = new JButton("Center");

        Font bigFont = new Font("serif", Font.BOLD, 28);
        south.setFont(bigFont);

        frame.getContentPane().add(java.awt.BorderLayout.EAST, east);
        frame.getContentPane().add(java.awt.BorderLayout.WEST, west);
        frame.getContentPane().add(java.awt.BorderLayout.NORTH, north);
        frame.getContentPane().add(java.awt.BorderLayout.SOUTH, south);
        frame.getContentPane().add(java.awt.BorderLayout.CENTER, center);
        /**
         * Компоненты в области CENTER занимают оставашееся место, основываясь на размерах фрейма
         */

        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
