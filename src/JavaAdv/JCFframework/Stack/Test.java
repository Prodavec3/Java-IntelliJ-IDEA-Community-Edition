package JavaAdv.JCFframework.Stack;

import java.util.Stack;

/**
 * Класс Vector устаревший ~ ArrayList и уже не используется, но Stack наследуется от Vector
 *
 * Структура данных где необходимо получать последний (LIFO)
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); // Last in First Out, Последний зашел первый вышел
        stack.push(5); // Добавляет элемент в стек
        stack.push(3);
        stack.push(1);

        /* System.out.println(stack.pop()); // Достает последний добавленный элемент, 1
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 5 */

        System.out.println(stack.peek()); // Показывает, но не извлекает элемент в стеке последний

        while (!stack.empty()){ // Пустой или нет
            System.out.println(stack.pop());
        }
    }
}
