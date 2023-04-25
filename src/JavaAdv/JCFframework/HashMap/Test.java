package JavaAdv.JCFframework.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap - отображение
 * В Python называется словарь
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // Тип ключа и значение, ключ int, str значение

        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        System.out.println(map);

        map.put(3, "Другое значение для ключа 3");

        System.out.println(map); // старое значение переписывается новым если ключ одинаковый

        System.out.println(map.get(1)); // получение значения по ключу
        System.out.println(map.get(10)); // вернет null если такого ключа нет

        // проходимся по hashMap
        // каждая пара ключ-значение это entry, пара рассматривается в совокупности
        System.out.println("Выводим HashMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Пары ключ-значение не имеют какого-либо порядка (т.е не гарантируют порядка)
        /**
         * То есть HashMap используем если нам не важен порядок вывода
         * а если важен порядок - нужно использовать другие классы, реализующие интерфейс Map
         */
    }
}
