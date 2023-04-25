package JavaAdv.JCFframework.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Коллекция это связанный набор классов и интерфейсов
 * JCF - java collections framework - реализация часто используемых коллекций
 * то место где храним объекты = коллекция
 */

public class Test {
    public static void main(String[] args) {
        // Поместим через for внутрь массива, и мы не можем положить туда больше 4 элементов

        //ArrayList - динамический массив.
        ArrayList<Integer> arrayList = new ArrayList<>();  // не можем указывать примитивы, т.к дженерики
        for (int i = 0; i < 100; i++){
            arrayList.add(i);
        }
        System.out.println(arrayList); // выдаст весь список, т.к определен toString
        System.out.println(arrayList.get(99)); // Получить элемент массива по индексу
        System.out.println(arrayList.size()); // Получить размер

        /**
         * Как проходиться по элементам ArrayList'а
         */
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        for (Integer x : arrayList) {
            System.out.println(x);
        }

        // и 3 способ - лямбда

        arrayList.remove(5); /** удаление элемента определенного индекса, метод неэффективен, если удаление посередине или ближе к началу
         все объекты ArrayList используют в качестве реализации массив, т.е создается массив, если больше элементов - создается еще один
         в 2 раза больше и тд. Т.е удаляем элемент массива
         [1,2,3,4,5] remove 5 - делается быстро, уменьшается массива размер
         если remove 3 => [1,2, ,4,5] => удаляет, уменьшает размер массива и потом смещает все остальные элементы
         Поэтому это неэффективно. И тогда не надо использовать ArrayList => LinkedList

         Конвенция при использовании классов из JCF:
         Когда мы используем класс из коллекций - когда мы создаем объект - мы стараемся этот объект сослать на переменную типа интерфейса
         ArrayList<> list (Класс ArrayList ссылается на интерфейс List) то есть:
         */
        List<Integer> list = new ArrayList<>();
        /**
         * Когда мы ссылаем объект класса на интерфейс, то мы можем далее:
         * Допустим, следом нам нужно будет удалить много элементов из этого листа,
         * но надо не забыть перенести все элементы в этот LinkedList из ArrayList
         * т.е мы можем по ходу программы изменить реализацию на ходу
         */
        list = new LinkedList<>();
    }
}
