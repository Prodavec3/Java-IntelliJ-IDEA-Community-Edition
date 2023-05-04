package JavaAdv.Lambda.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbuy");
        list.add("a");
        list.add("ab");
        /**
         * Если в интерфейсе необходимо реализовать 1 единственный метод -
         * можем использовать лямбду
         */
        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            else return 0;
        };

        list.sort(comparator);
        System.out.println(list);
    }
}
