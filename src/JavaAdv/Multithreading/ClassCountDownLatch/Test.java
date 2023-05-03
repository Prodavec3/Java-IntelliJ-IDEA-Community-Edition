package JavaAdv.Multithreading.ClassCountDownLatch;
/**
 * Декрементируем в потоках Proc, ждем в main
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Вместо sync
 *
 * CDL защелка обратного отсчета. Класс потокобезопасный
 * При создании количество операций надо задать
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); // 3 раза отсчитать пока защелка не отопрется

        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 потока
        for (int i = 0; i < 3; i++){
            executorService.submit(new Processor(countDownLatch));
            System.out.println("Попытка открыть защелку №"+(i+1));
        }

        executorService.shutdown(); // Означает что все задания выдали и пора приступать к работе

        countDownLatch.await(); // ждем пока защелка не откроется
        System.out.println("Защелка открылась и главный поток продолжает свою работу");
    }
}

class Processor implements Runnable{
private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        countDownLatch.countDown(); // декрементирует на 1
    }
}