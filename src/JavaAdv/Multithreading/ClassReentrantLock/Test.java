package JavaAdv.Multithreading.ClassReentrantLock;
/**
 * Метод lock блокирует и не дает выполняться другим пока не случится unlock
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс этот нужен для синхрозации потоков (вместо synchronized).
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstTread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock(); // Lock интерфейс, RL - класс

    private void increment(){
        for (int i = 0; i < 10000; i++){
            counter++;
        }
    }

    public void firstTread(){
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread(){
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter(){
        System.out.println(counter);
    }
}
