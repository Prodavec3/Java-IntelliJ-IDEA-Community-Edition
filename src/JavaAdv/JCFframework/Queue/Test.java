package JavaAdv.JCFframework.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Коллекция Queue реализует очередь. FIFO - первый зашел первый вышел
 * Например, использование в потоках - выстраивание очередности
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        /**
         * Добавлять в Queue можно .add(), либо .offer()
         * Получать .poll(), либо .remove()
         *
         * Парные методы .add + .remove; .offer + .poll
         */
        Queue<Person> people = new LinkedList<>();
        people.add(person2); // первый в очередь пришел и встал
        people.add(person4); // 2
        people.add(person1); // 3
        people.add(person3); // 4
        System.out.println("Queue LinkedList:");
        for (Person person : people
             ) {
            System.out.println(person);
        }

        /**
         * Рассмотрим класс ArrayBlockingQueue, реализующий данный интерфейс Queue, класс полезен в многопоточности
         * Который позволяет указать максимальный размер очереди, LinkedList же - пока не закончится память можно доабвлять элементы
         */
        Queue<Person> personsQueue = new ArrayBlockingQueue<>(10); // Задаем максимальный размер очереди
        personsQueue.add(person2); // первый в очередь пришел и встал
        personsQueue.add(person4); // 2
        personsQueue.add(person1); // 3
        personsQueue.add(person3); // 4

        System.out.println("Что удалит remove(): " +  personsQueue.remove()); // Удаление первого элемента в очереди
        System.out.println("После remove(): " + personsQueue);
        System.out.println("На ком отработает .peek(): " + personsQueue.peek()); // peek позволяет посмотреть перового в очереди и не удаляет его
        System.out.println(personsQueue);

        /**
         * add - offer (добавить), remove - poll(удалить), element - peek(показать 1й элемент на выход)
         * По функционалу ничем не отличаются
         * Различие - add,remove,element - выбрасывают исключения при ошибке
         * а offer,poll,peek - вернут специальное значение при ошибке
         * Ошибка, например, если в переполненную очередь добавляем еще один элемент.
         */
    }
}

class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
