package JavaAdv.JCFframework.IterableInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Метод hashCode() и equals() для проверки на равенство
 * compareTo() для сортировки объектов в коллекциях
 *
 * Во всех классах JCF весь функционал где-то реализован.
 * Чтобы сравнивать, сортировать - нужно переопределять методы.
 *
 * Java проходится по list как по коллекции - т.к имеется интерфейс Iterable
 * Интерфейс Iterable содержит только 1 метод iterator(), который возвращает объекты класса Iterator
 * для прохождения по всем элементам (поэтому можем проходить с помощью foreach)
 *
 * Чтобы можно было проходиться по своему собственному классу foreach необходимо реализовать интерфейс Iterable
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Before Java 5
        // Хранит в себе указатель, указывает на пространство до первого объекта, next() перемещается на первый элемент
        // Удалять можем элементы, изменять, одновременно с итерированием, а в случае foreach - нет
        // iterator.remove() - удалить элемент на котором сейчас итератор
        Iterator<Integer> iterator = list.iterator(); // возвращает итератор list'а
        int index  =0;
        while (iterator.hasNext()){
            System.out.println(iterator.next());

            if (index == 1){
                iterator.remove();
            }
            index++;
        }
        System.out.println("Удаление 2 элемента (индекс 1): " + list);

        // В java5 появился foreach и внутри себя под капотом хранит итератор
        // не дает изменять list
        for (int x:list
             ) {
            System.out.println(x);
        }
    }
}
