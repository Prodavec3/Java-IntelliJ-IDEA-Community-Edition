package JavaAdv.Multithreading.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 1 ресурс используют много потоков
 * например, 10 потоков пишут на сервер и мы хотим делить ограниченный ресурс между всеми потоками
 */
public class Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // должны передать число - кол-во разрешений для потоков,
        // сколько потоков одновременно могут писать на сервер ( в нашем случае max 3 потока исп. ресурс)

        try {
            semaphore.acquire(); // начинаем взимодействие с ресурсом, acquire ждет пока permit = 0
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        semaphore.release(); // отпускает одно из разрешений
        // потоки забирают разрешение и когда выполнили задачу - отдают разрешение

        System.out.println("Разрешений: "+semaphore.availablePermits()); // Количество разрешений
    }
}
