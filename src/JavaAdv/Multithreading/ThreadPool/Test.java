package JavaAdv.Multithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Создавали потоки до этого мы явно.
 *
 * ThreadPool
 * Создается N число потоков и выполняют задание параллельно
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Класс Executors содержит в себе статические методы. Принимают аргументы и возвращают executorService
         * Executor Service это пул потоков. В данном случае пул из 2 потоков.
         * Они будут работать над задачей и не будут между друг другом конфликтовать.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++){
            executorService.submit(new Work(i)); // в submit мы ставим класс, который реализует Runnable
            // В этом классе мы как раз и описываем логику что будет происходить
            // Мы передали "2м работникам 5 заданий" [0,4]
        }
        executorService.shutdown(); // перестаем принимать задания новые и приступаем к выполнению заданий
        // shutdown ~ start
        System.out.println("All tasks submitted");

        // ~ join, ждем выполнение потоков, как только время подошло - все идет дальше
        executorService.awaitTermination(1, TimeUnit.DAYS); // сколько мы хотим ждать, сколько готовы ждать потоки до выполнения заданий
    }
}

class Work implements Runnable{
    private  int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work " + id + " was completed");
    }
}
