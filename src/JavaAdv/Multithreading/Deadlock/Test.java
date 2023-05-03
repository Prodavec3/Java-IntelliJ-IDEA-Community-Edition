package JavaAdv.Multithreading.Deadlock;
/**
 * deadlock мы можем получить, когда lock1 lock2, а 2й поток сначала lock2 потом lock1 и
 * от программы ответа мы не дождемся
 *
 * При sync deadlock'и тоже могут появляться
 *
 * Как избежать deadlock:
 * 1) Не забирать локи в разных порядках. Всегда забирать локи в том же порядке
 * но если это необходимо:
 * 2) ReentrantLock
 */

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks (Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true){
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock(); // Пробуем забрать ло
            } finally {
                if (firstLockTaken && secondLockTaken){
                    return;
                }

                if(firstLockTaken){
                    lock1.unlock();
                }

                if(secondLockTaken){
                    lock2.unlock();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void firstThread(){
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            // lock1.lock();
            //lock2.lock();

            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void secondThread(){
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            //lock1.lock();
            //lock2.lock();

            takeLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    /*
    public void firstThread(){
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            synchronized (account1){
                synchronized (account2){
                    //только тут безопасно могут пересылаться деньги
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }
        }
    }
    public void secondThread(){
        Random random = new Random();
        for (int i = 0; i < 10000; i++){
            synchronized (account1){
                synchronized (account2){
                    //только тут безопасно могут пересылаться деньги
                    Account.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }
    */

    public  void finished(){
        System.out.println("Balance 1 acc: " + account1.getBalance());
        System.out.println("Balance 2 acc: " + account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class  Account {
    private int balance = 10000;
    public void deposit(int amount){
        balance += amount;
    }

    public void withDraw(int amount){
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withDraw(amount);
        acc2.deposit(amount);
    }
}
