package JavaAdv.Multithreading.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Synchronized с указанием объекта синхронизации потоков
 */
public class TestWithObjSynchr {

    public static void main(String[] args) throws InterruptedException {
        new Worker().main();
    }
    /**
    public void increment(){
        synchronized (this){ //synchronized block, указываем на каком объекте хотим синхр. и указываем в теле какие именно команды
            counter++;
        }
    }
*/
}

class Worker{
    Random random = new Random();
    /**
     * Объекты lock1,2 созданы для синхронизации. Можем использовать любой объект.
     * Нам здесь необходим монитор.
     */
    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100)); // рандомное число в рамках [0,99]
        }
    }
    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100)); // рандомное число в рамках [0,99]
        }
    }
    public void work(){
        for(int i = 0; i < 1000; i++){
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();
     //   work();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        /**
         * То есть в данном случае 2 потока 2 раза делают work(), друг друга перезаписывают, т.к
         * нет синхронизации. Напишем synchronized в addToList1 и 2 это сработает,
         * и будет 2.000 элементов в 2х местах.
         * Но мы видим, что программа занимает по времени в 2 раза больше времени.
         * Происходит т.к если мы пишем синхронайс в заголовке метода, то синхр происходит на this.
         * Объект this в данном случае это Worker. Получается, что addtolist1.2 синхр. на одном объекте
         * если один считает и записывает - другой ждет (т.к монитор у первого)
         *
         * В итоге мы хотим, чтобы 1 метод выполнял 1 поток, 2 метод 2й.
         * То есть чтобы не было блокировки и второй поток не простаивал.
         * В двух потоках мы изменяем разные сущности (list 1 и list 2).
         * Между потоками не происходит пересечение данных.
         *
         * Поэтому мы хотим чтобы методы работали параллельно.
         *
         * Мы можем синхр на разных объектах.
         * Для этого создали Object lock1 и 2 и будем синхронизироваться на них, т.к
         * это 2 разных объекта и 2 разных монитора друг от друга не зависящих.
         *
         * И в итоге будет параллельное выполнение выполнение методов, потоки синхронизованы
         * и пишут в разные листы.
         */
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long after = System.currentTimeMillis();
        System.out.println("List 1: " + list1.size() + " элементов");
        System.out.println("List 2: " + list2.size() + " элементов");
        System.out.println("Программа исполнилась за: " + (after - before));
    }
}
