package JavaAdv.Multithreading.Interrupted;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1000000000; i++){
                    if (Thread.currentThread().isInterrupted()){ // Проверяем в самом потоке прервали нас или нет извне
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble(100000));
                }
            }
        });

        System.out.println("Starting thread");

        thread.start();


        Thread.sleep(1000);
        thread.interrupt(); // Никак не убивает поток (не прекращает выполнение потока), должен вызываться до join
        // thread.stop(); создатели java не хотят чтобы этот метод использовался

        thread.join();

        System.out.println("Thread has finished");

        /**
         * Мы не увидим последнее сообщение, т.к очень трудоемкая программа
         * т.к вычисление очень долгое и трудное.
         *
         * Мы хотим прервать из main поток thread
         */
    }
}
