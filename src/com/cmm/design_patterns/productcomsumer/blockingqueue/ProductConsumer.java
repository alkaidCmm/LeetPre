package com.cmm.design_patterns.productcomsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProductConsumer {
    /**
     * BlockingQueue内部实现就附加了两个阻塞操作。
     * 即当队列已满时，阻塞向队列中插入数据的线程，直至队列中未满；
     * 当队列为空时，阻塞从队列中获取数据的线程，直至队列非空时为止。
     * @param <T>
     */
    static class Productor<T> implements Runnable {
        private BlockingQueue<Integer> queue;
        private static Random r = new Random();

        public Productor(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int i = r.nextInt();
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class Consumer implements Runnable {
        BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                Integer element = queue.poll();
                System.out.println("消费者" + Thread.currentThread().getName() + "正在消费数据" + element);
            }
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Productor(queue));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(queue));
        }
    }
}
