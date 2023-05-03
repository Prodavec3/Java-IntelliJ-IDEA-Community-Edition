package JavaAdv.Multithreading.CallableAndFurure;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Классы позволяют возвращать значения и исключения из потоков
 *
 * new Runnuble() - метод void run, который ничего не возвращает, а нам необходимо чтобы поток что-то вернул
 * Можно, например, создать поле result и что-то с ним делать
 * А можно проще, используя интерфейс не Runnable, а Callable, он параметризованный
 */
public class Test {
    private static int result;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Finished");
            result+=5;
        });

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(result);*/


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            /**
             * При реализации лямбда выражений java сама понимает Runnuble или Callable
             * мы используем, по возвращаемому значению
             *
             * Используя Future<type> = мы получаем значение с return
             */
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt(10);
                if (randomValue < 5)
                    throw new Exception("Something bad happened, value < 5");
                return randomValue;
            }
        });

        executorService.shutdown();

        try {
            System.out.println(future.get());
            int result = future.get(); // Получи
            // ли значение. get дожидается окончание выполнения потока
        } catch (ExecutionException e) {
            Throwable ex = e.getCause(); // поймали исключение из потока
            System.out.println(ex.getMessage());
        }
    }
}
