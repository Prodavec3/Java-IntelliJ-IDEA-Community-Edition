package JavaAdv.Multithreading.WaitNotify;

import java.util.Scanner;

/**
 * wait() и notify() - методы определены у любого объекта в Java, т.к они определены у Object
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*
        Object object = new Object();
        object.wait();
        object.notify();
        */
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

/**
 * Методы работают в разных потоках
 */
 class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started");
            /**
             * wait - отдаем intrinsic lock (будто в потоке вышли из сонхронизованного блока
             * в текущем потоке ждем пока будет вызван notify() на этом объекте
             * у wait есть параметр сколько он будет ждать notify
             */
            wait(); // вызывается только в пределах синхронизованного блока
            // Ожидаем пока не отработает notify из другого потока.
            System.out.println("Producer thread resumed");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            //notifyAll(); // Все потоки которые ждут - проснутся, wait - notify
            notify();

            // если напишем Thread.sleep(5000); то будем ждать еще 5с, т.к монитор
            // занимает данный поток
        }
    }
 }
/**
 * то есть wait - ждем, сихронизируемся на this, wait - поток отдает монитор
 * в другом потоке, который синхронизирован на this - notify говорит что можешь проснуться
 * заканчивается сам и отдает обратно первому
 *
 * notify не возвращает монитор
 */