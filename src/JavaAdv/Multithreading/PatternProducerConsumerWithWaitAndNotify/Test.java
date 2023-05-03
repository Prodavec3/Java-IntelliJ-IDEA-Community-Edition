package JavaAdv.Multithreading.PatternProducerConsumerWithWaitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1 поток добавлял 2 извлекал из очереди
 *
 * wait notify низкоуровневые методы
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10; // max количество элементов в очереди
    private final Object lock = new Object(); // объект для синхронизации, должны быть константами
    public void produce() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (lock){
                // Все обращения из разных потоков к одной очереди должны быть синхрониз.
                while (queue.size() == LIMIT){
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify(); // в консюмере 0 элементов если и он заснул, то тут 2й поток надо пробудить
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (lock){
                while (queue.size() == 0){
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size: " + queue.size());
                lock.notify(); // взяли 1 элемент, говорим 1 потоку проснуться, т.к освободилось место
            }

            Thread.sleep(1000); // Чтобы продюсер успевал заполнять
        }
    }
}
