package JavaAdv.JCFframework.LinkedList;

import java.util.Arrays;

/**
 * Создание своего LinkedList'a односвязного и непараметризованного
 */
public class MyLinkedList {
    private Node head;
    private  int size;
    public void add(int value){
        if (head == null){ // если первое добавление в список
            this.head = new Node(value);
        } else {
            Node temp = head; // Временный узел

            while (temp.getNext() != null){ // Если следующий элемент не null, то записываем его, если null - мы в конце
                temp = temp.getNext();
            }

            temp.setNext(new Node((value))); // последний узел set на value
        }
        size++;
    }

    public int get(int index){
        int currentIndex = 0;
        Node temp = head;
        while (temp != null){
            if (currentIndex == index){
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index){ // Удалить ссылку на элемент и заменить ссылку на следующий элемент
        if (index == 0){
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null){
            if (currentIndex == index - 1){ // [1] -> [2] -> [3] ; index = 2, т.е нам подходит [2], (т.к [3] и предш. ему [2])
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public String toString(){ // для просмотра нашего списка
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while (temp != null){
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }
        // [1] берем записываем двигаемся, он не null и дальше
        return Arrays.toString(result);
    }

    private static class Node{
        private int value;
        private Node next;
        // создаем геттеры и сеттеры по этим параметрам

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
