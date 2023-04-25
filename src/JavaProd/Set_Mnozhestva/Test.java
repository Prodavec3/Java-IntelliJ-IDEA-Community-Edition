package JavaProd.Set_Mnozhestva;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * set = множества, коллекция, которая хранит в себе только уникальные элементы ( нас не интересует количество )
 * list и set похожи
 *
 * HashSet наиболее часто используемый, т.к он наиболее быстрый и чаще всего нам не нужен порядок
 * Используем множества если надо найти какой-либо элемент
 */
public class Test {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(); // не сохраняет порядка
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохраняет порядок ввода в Set
        Set<String> treeSet = new TreeSet<>(); // сортируются объекты по порядку (исп-ся лексикографический порядок)

        addSet(hashSet);
        addSet(linkedHashSet);
        addSet(treeSet);

        showSet(hashSet, "HashSet: ");
        showSet(linkedHashSet, "LinkedHashSet");
        showSet(treeSet, "TreeSet");

        /**
         * Методы Set
         * 1) contains - проверка есть ли элемент в Set'e и данный метод работает очень быстро для множеств
         * 2) isEmpty - проверка пустой или нет
         * и др
         */
        System.out.println("Есть ли в множестве Tom: " + hashSet.contains("Tom"));
        System.out.println("Есть ли в множестве Tim: " + hashSet.contains("Tim"));

        System.out.println("Пустой HashSet? "+ hashSet.isEmpty());

        //Set'ы можно выводить через sout
        System.out.println();
        System.out.println("Вывод HashSet через sout:");
        System.out.println(hashSet);
    }

    public static void addSet(Set<String> set){
        set.add("Mike");
        set.add("Tom");
        set.add("Piter");
        set.add("Sergey");
        set.add("Denis");
        set.add("Bob");
        set.add("Tom");
        set.add("Tom");
        // положим, например, Tom 3 раза, повторы просто игнорируются
    }

    public static void showSet(Set<String> set, String setName){
        System.out.println(setName + ": ");
        for(String name : set){
            System.out.println(name);
        }
        System.out.println();
    }
}
