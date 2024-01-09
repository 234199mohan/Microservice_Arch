package com.mohan.practise;


import java.util.LinkedList;

public class ProducerConsumer {

    public static void main(String[] args) {

        LinkedList<Integer> producerConsumerQueue = new LinkedList<>();
        int maxCap = 5;

        Thread producerThread = new Thread(() -> {
            int count = 1;
            while (true) {
                synchronized (producerConsumerQueue) {
                    while (producerConsumerQueue.size() == maxCap) {
                        System.out.println("Queue is full, waiting for consumer...");
                        try {
                            producerConsumerQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Produced: " + count);
                    producerConsumerQueue.add(count);
                    count++;
                    producerConsumerQueue.notifyAll();

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread consumerThread = new Thread(() -> {
            int count2 = 1;
            while (true) {
                synchronized (producerConsumerQueue) {
                    while (producerConsumerQueue.isEmpty()) {
                        System.out.println("Queue is empty waiting for producer.......");
                        try {
                            producerConsumerQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    producerConsumerQueue.addFirst(count2);
                    System.out.println("Consumed :" + count2);
                    count2++;
                    producerConsumerQueue.notifyAll();

                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        producerThread.start();
        consumerThread.start();


    }
}
