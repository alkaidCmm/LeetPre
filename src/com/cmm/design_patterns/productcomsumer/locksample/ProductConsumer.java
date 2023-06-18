package com.cmm.design_patterns.productcomsumer.locksample;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumer {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition empty = lock.newCondition();
    private static Condition full = lock.newCondition();

    private static Random random = new Random();


    static class Productor implements Runnable {
        private List<Integer> list;
        private int capacity;
        private Lock lock;

        public Productor(List<Integer> list, int capacity, Lock lock) {
            this.list = list;
            this.capacity = capacity;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == capacity) {
                        System.out.println("生产者" + Thread.currentThread().getName() + "  list以达到最大容量，进行wait");
                        // 调用await()前，必须获得对应Lock对象的锁，否则抛出java.lang.IllegalMonitorStateException异常。
                        // 调用await()后当前线程会被阻塞，同时释放已经获得的锁。await()方法的作用与Object.wait()方法作用类似。
                        // 被阻塞的线程可以通过中断唤醒或者signal()/signalAll()唤醒。
                        full.await();
                        System.out.println("生产者" + Thread.currentThread().getName() + "  退出wait");
                    }
                    int i = random.nextInt();
                    System.out.println("生产者" + Thread.currentThread().getName() + " 生产数据" + i);
                    list.add(i);
                    empty.signalAll();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private List<Integer> list;
        private Lock lock;

        public Consumer(List list, Lock lock) {
            this.list = list;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.isEmpty()) {
                        System.out.println("消费者" + Thread.currentThread().getName() + "  list为空，进行wait");
                        empty.await();
                        System.out.println("消费者" + Thread.currentThread().getName() + "  退出wait");
                    }
                    Integer element = list.remove(0);
                    System.out.println("消费者" + Thread.currentThread().getName() + "  消费数据：" + element);
                    full.signalAll();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Productor(linkedList, 8, lock));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(linkedList, lock));
        }

    }
}
