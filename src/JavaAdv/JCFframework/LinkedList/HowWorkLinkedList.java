package JavaAdv.JCFframework.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class HowWorkLinkedList {
    public static void main(String[] args) {
        /**
         * LinkedList реализует структуру данных связного списка
         * Существует односвязный и двусвязный список
         * LinkedList реализует двусвязный список
         * Есть ссылка конца списка в двусвязном.
         *
         * .add добавляет новый узел и вставляется в цепочке
         *
         * Node<E> first / last - начало и конец
         *
         * Наша реализация LinkedList односвязного MyLinkedList
         */
        List<Integer> list = new LinkedList<>();
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(22);
        myLinkedList.add(22222);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(0));
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
    }
}
