package GUI;

import javax.swing.*;

public class ButtonInGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // создание фрейма
        JButton button = new JButton("Click button"); // Создаем виджет (в данном случае кнопка)

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Чтобы программа завершалась при закрытии окна, иначе она будет всегда работать

        frame.getContentPane().add(button); // Добавление виджета во фрейм (добавляем как магнитик на холодильник)

        frame.setSize(300,300); // Выводим фрейм на экран
        frame.setVisible(true); // Делаем фрейм видимым

        // Далее необходимо создать метод, вызываемый нажатием кнопки.
        // Мы хотим знать когда пользователь ее нажимает, т.е отследить событие нажатия
    }
}
