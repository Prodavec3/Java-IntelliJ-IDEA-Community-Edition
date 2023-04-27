package JavaAdv.Multithreading.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Паттерн Producer - Consumer
 * Один или более потоков производят что-то, а один или более потребляют что-то
 *
 * Часто встречается при многопоточном программировании.
 *
 * Один или много потоков, которые что-то создают в систему, а потребитель берет из общего пула сущностей.
 */
public class Test {
    private  static  BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // Очередь FIFO, потокобезопасная, есть предельный размер

    public static void main(String[] args) throws InterruptedException {
        // реализуем паттерн  помощью встроенного класса
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
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
    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true){
            queue.put(random.nextInt(100));
        }
    }

    /**
     * put ждет пока очередь не освободится
     */

    private static void consumer() throws InterruptedException {
        while (true){
            Random random = new Random();
            Thread.sleep(100);

            if(random.nextInt(10) == 5){
                System.out.println(queue.take());
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}

/**
 * Producer генерирует числа от 0 до 99 и кладет в очередь.
 * Consumer при определенном условии забирает элементы из очереди.
 */
