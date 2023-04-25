package JavaProd.HashCodeAndEquals;

import java.util.*;

/**
 * Ключи в Map всегда уникальны и в Set только уникальные элементы
 *
 * Переоперделяем hashCode и equals если надо сравнивать по значению, а не по физическому адресу
 *
 * Оба метода служат для сравнения объектов, выбирается тот что наиболее быстро
 *
 * Метод equals работает долго, т.к мы проходимся по всем значимым полям (которые мы включили в этап сравнения)
 * и только если все поля равны считаем что они равны.
 *
 * Для ускорения проверки на равенство используется хэшкод (сначала используем хешкод), в случае если этот метод
 * отработал правильно - ОК, не правильно - запускаем equals.
 *
 * Бывает такое что hashCode говорит что объекты равны, а они не равны
 *
 * Функция для хэширования = функция свертки (хэш - функция). Преобразует объект произвольной длины
 * в целое число фиксированной длины
 * {object} -> {int}
 * Любому объекту сопоставляем число. Сравнение целых чисел делается быстро.
 *
 * Бывает коллизия - когда хэши одинаоквые, а объекты разные.
 * Это из-за ограничения количества хэшей (int = 32bit).
 * 2 разных объекта бывает возвращают один и тот же хэш.
 */

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        // Ключи в map уникальны
        map.put(1, "Один");
        map.put(1, "One");
        // Значения в set уникальны
        set.add(1);
        set.add(1);

        System.out.println("Map " +map);
        System.out.println("Set " + set);

        Map<Person, String> map2 = new HashMap<>();
        Set<Person> set2 = new HashSet<>();

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(2, "Bob");

        map2.put(person1, "123");
        map2.put(person2, "123");

        set2.add(person1);
        set2.add(person2);

        /**
         * На выводе будет все норм, ключ это объект что в map что в set
         */
        System.out.println("Map with Person as Key: " + map2);
        System.out.println("Set with Person: " + set2);

        // Создадим еще одного person3, у которого будут идентичны поля с person1
        Person person3 = new Person(1, "Mike");
        map2.put(person3, "123");
        set2.add(person3);
        // Выведем с person3
        System.out.println();
        System.out.println("Map with Person as Key: " + map2);
        System.out.println("Set with Person: " + set2);
        // по идее person1 и person3 это одинаковые объекты, т.к id и name у них одинаковые
        // это 2 одинаковых объекта, но Map допустил 2 одинаковых ключа, а Set допустил что 2 раза повторяется один и тот же объект

        /**
         * Если будет String у Set, то выдаст верно 1 элемент.
         * Т.к стд классы String, Integer и др реализуют hashCode и equals
         */
        Set<String> setStr = new HashSet<>();
        setStr.add("Hi");
        setStr.add("Hi");
        System.out.println();
        System.out.println("Сравнение через equals(): " + setStr.equals("Hi"));
        System.out.println();
        System.out.println("Set with String: " + setStr);

        /**
         * Integer x = 1; // Java сама упакует в класс обертку
         * x.equals();
         * Этот функционал наследуется от класса родителя, Object и там определено, что разные объекты = разные объекты (false)
         * т.к разные ссылки, equal не беспокоит содержание
         *
         * native означает что реализация метода не в java, напр. в C++ для более высокого быстродействия
         *
         * hashCode также сравнивает ссылки на объекты - если разные ссылки - разные объекты (не смотря на содержание)
         *
         * Для того чтобы это исправить - необходимо переопределить hashCode и equals
         * (чтобы person1 == person3)
         */

    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) { // получаем второй объект и сравниваем
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() { // объект сжимается и конвертируется в целое число, это целое число - представление объекта
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     * После того как переопределили - теперь java будет сравнивать корректно
     *
     * Контракт hashcode() equals()
     * 1) У двух проверяемых объекто вызываем метод hashcode()
     * если хэши разные -> два объекта точно разные
     * 2) если хэши одинаковые -> либо объекты одинаковые, либо разные, но случилась коллизия
     * -> вызываем метод equals()
     * 3) equals -> выдает точный ответ
     *
     * Чем меньше коллизий тем быстрее происходит сравнивание (реже вызываем equals)
     */
}
