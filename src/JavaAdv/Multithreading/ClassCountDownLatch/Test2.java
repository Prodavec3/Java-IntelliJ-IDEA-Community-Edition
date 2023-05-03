package JavaAdv.Multithreading.ClassCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Декрементируем в main, ждем в потоках Proc
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3); // 3 раза отсчитать пока защелка не отопрется

        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 потока
        for (int i = 0; i < 3; i++){
            executorService.submit(new Processor2(i, countDownLatch));
        }

        executorService.shutdown(); // Означает что все задания выдали и пора приступать к работе

        for(int i = 0; i < 3; i++){
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Processor2 implements Runnable{
    private int id;
    private CountDownLatch countDownLatch;

    public Processor2(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread with id " + id + " proceeded"); // когда защелка откроется каждый поток выведет сообщение
    }
}
