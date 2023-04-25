package JavaAdv.JCFframework.ComparatorInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Сортировка объектов в коллекциях
 * HashSet - не гарантируется порядок, поэтому не будем использовать его для сортировки
 */
public class Test {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("ab");
        animals.add("Bird");
        animals.add("Frog");
        animals.add("a");

        Collections.sort(animals); // Сортирует лист согласно ествественному порядку (natural order)
        System.out.println("Естественная сортировка: "+animals);

        /**
         * Если нас не устраивает естественный порядок сортировки - используем интерфейс Comparator
         * Для использования нашей сортировки мы в методе указываем компаратор
         * .sort(list, comparator)
         * Естственный порядок теперь не работает, т.к работает компаратор
         */
        Collections.sort(animals, new StringLengthComparator());
        System.out.println("Отсортировано по длине: "+animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(500);
        numbers.add(100);
        numbers.add(5000);
        numbers.add(1);
        Collections.sort(numbers);
        System.out.println("Естественная сортировка: " + numbers);
        //Collections.sort(numbers, new BackwardsIntegerComparator());
        // С применением анонимного класса
        Collections.sort(numbers, new Comparator<Integer>() { // можно сжать код лямбдой
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("Наша сортировка по убыванию: " + numbers);


        List<Person> people = new ArrayList<>();
        people.add(new Person(3, "Mike"));
        people.add(new Person(1, "Bob"));
        people.add(new Person(2, "Katy"));

        // Collections.sort(people); не получится, т.к мы не задали естественный порядок в классе
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()){
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("После нашего компаратора по возрастанию id: "+people);
    }
}

/**
 * Реализуем компаратор для нашего собственного класса Person
 */
class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class StringLengthComparator implements Comparator<String> {
    /** Возвращается целое число и именно по этому целому числу java понимает какой объект больше
     *
     * o1 > o2 ->1
     * o1 < o2 -> -1
     * o1 == o2 ->0
     *
     * compare(2, 4) -> -1
     * compare(4, 2) -> 1
     * compare(1,1) -> 0
     */
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()){
            return  1;
        } else if (o1.length() < o2.length()) {
            return  -1;
        } else{
            return 0;
        }
    }
}

// Можно рассматривать -1 и 1 как: -1 -> (в конец), 1 <- (в начало)

/**
 * Создавать класс для реализации 1 интерфейса не всегда целесообразно
 * Если мы вызовем сортировку всего 1 раз, то можно использовать анонимный класс
 */