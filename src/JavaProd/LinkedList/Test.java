package JavaProd.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        /** Методы у Array и Linked одинаковые, работают эти методы тоже одинаково
        linkedList.add(1);
        linkedList.get(0);
        linkedList.size();
        linkedList.remove(0);
        */
        measureTime(linkedList, "LinkedList");
        measureTime(arrayList, "ArrayList");
    }

    private static  void measureTime(List<Integer> list, String nameList){

         /** Добавление в конец
         for (int i = 0; i < 1000000; i++){
             list.add(i);
         }*/

        long start = System.currentTimeMillis(); // Тек. время в миллисекундах

        /**
         * Получение элементов
        for(int i = 0; i < 100000; i++){
            list.get(i);
        }*/

        // Добавим в начало листа, а не в конец
        for(int i = 0; i < 100000; i++){
            list.add(0, i);
        }

        long end = System.currentTimeMillis();

        System.out.println(nameList + ": " + (end - start));

        /**
         * То есть если надо просто добавлять элементы в List методом .add() - быстрее и целесообразнее это делать в ArrayList
         * но запись эта была .add, а именно в конец List
         * Однако если запись делать в начало, а не в конец - LinkedList на порядок быстрее
         *
         * Получение элементов из List методом .get() также ArrayList (в 1.000 раз быстрее)
         */
    }
}

/**
 * ArrayList - внутренний массив
 * .add(6) [1][2][3][4][5] -> [1][2][3][4][5][6]
 * .add(0,6) [1][2][3][4][5] -> [6] и каждый элемент сдвигаем вправо [][][][][]
 *
 * В случае LinkedList - цепочка узлов (цепочка объектов, т.е массив внутри не хранится).
 * У каждого объекта есть значение и есть ссылка на следующий объект
 * [1] -> [2] -> [3] -> [4] сам элемент + ссылка на следующий
 * то есть не можем сразу получить 3й элемент, а необходимо пройтись по цепочке с головного узла
 *
 * Вставка в начало делается очень быстро, т.к у нас есть головной элемент, с которого начинается вся цепочка
 * head -> [1] -> [2] ...
 * head -> [5] -> [1] -> [2] ...
 *
 * Итог: много считываний и записей = ArrayList
 *       удаление элементов или добавление в начало = LinkedList
 */
