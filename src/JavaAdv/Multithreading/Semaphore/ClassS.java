package JavaAdv.Multithreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ClassS {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

/**
 * Только 1 раз будет создан Connection - сделав конструктор приватным
 */
class Connection { // Соединение с сервером
    private int connectionsCount;
    private static Connection connection = new Connection();
    private Semaphore semaphore = new Semaphore(10);
    private Connection(){ // singleton 1 объект класса

    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        /**
         * В случае если вдруг что-то случилось в doWork - в любом случае выполняем release()
         */
        try {
            doWork();
        }
        finally {
            semaphore.release();
        }

    }

    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println("Подключение №" + connectionsCount);
        }

        Thread.sleep(5000);

        synchronized (this){
            connectionsCount--;
            System.out.println("Декремент: " + connectionsCount);
        }
    }
}
