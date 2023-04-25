package JavaProd.LinkedHashAndTreeMap;

import java.util.*;

/**
 * Если нам нужен порядок -> LinkerHashMap - сохраняет порядок добавления пар
 * TreeMap - сортирует пары по ключу
 */
public class Test {
    public static void main(String[] args) {
        /*Map<String, String> translations = new HashMap<>();

        translations.put("Кошка", "Cat");
        translations.put("Собака","Dog");
        translations.put("Слон", "Elephant");

        for (Map.Entry entry : translations.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/

        Map<Integer, String> hashMap = new HashMap<>(); // порядок не гарантируется
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // гарантируется порядок добавления пар (как добавлены так и получим)
        Map<Integer, String> treeMap = new TreeMap<>(); // гарантирует сортировку пар по ключу
        // (должно быть задано правило сортировки), сортируются по ествественному порядку

        testMap(hashMap, "HashMap");
        testMap(linkedHashMap, "LinkedHashMap");
        testMap(treeMap, "TreeMap");
    }

    public static void testMap(Map<Integer, String> map, String name){
        map.put((int)(Math.random() * 600), "Bob");
        map.put((int)(Math.random() * 600), "Alfred");
        map.put((int)(Math.random() * 600), "Igor");
        map.put((int)(Math.random() * 600), "Mike");
        map.put((int)(Math.random() * 600), "Kenny");
        map.put((int)(Math.random() * 600), "Tom");

        System.out.println(name + " :");
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
