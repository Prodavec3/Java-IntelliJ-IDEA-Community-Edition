package JavaAdv.JCFframework.ComparableInterface;

import java.util.*;

/**
 * Для сортировки строк и чисел поставлять компаратор было не обязательно
 * Был естественный порядок, а для объектов клосса Person обязательно
 *
 * Дадим естественный порядок для своего класса
 */
public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();
        // Полиморфизм, Collection -> от него наследуются Set и List
        addElements(personList);
        addElements(personSet);

        Collections.sort(personList);

        System.out.println("Отсортирован: " + personList);
    }

    private static void addElements(Collection collection){
        collection.add(new Person(4, "George"));
        collection.add(new Person(1, "Bob"));
        collection.add(new Person(3, "Katy"));
        collection.add(new Person(2, "Tom"));
    }
}

class Person implements Comparable<Person>{ // Реализуем интерфейс, добавляем метод compareTo, даем ему возможность быть сравненым
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     * теперь можеи использовать .sort()
     */
    @Override
    public int compareTo(Person o) { // Определяем порядок, объект о сравнивается с другим объектом класса Person
        if (this.id > o.getId()){
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}