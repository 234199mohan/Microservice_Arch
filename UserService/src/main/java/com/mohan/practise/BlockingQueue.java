package com.mohan.practise;

import java.util.LinkedList;

public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer>blockingQueue = new LinkedList<>();
        int maxCap=5;

        Thread producerThread = new Thread(()->{
            int count=1;
            while(true){
                synchronized (blockingQueue)
                {
                 while(blockingQueue.size()==maxCap){
                     System.out.println("Queue is full waiting to consumer some item.....");
                     try {
                         blockingQueue.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
                 blockingQueue.add(count);
                    System.out.println("produced item...... "+ count);
                     count++;
                 blockingQueue.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


        Thread consumerThread = new Thread(()->{
            int count=1;
            while(true){

                synchronized (blockingQueue)
                {
                    while(blockingQueue.isEmpty()){
                        System.out.println("Queue is Empty waiting to produce some item.....");
                        try {
                            blockingQueue.wait();

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    blockingQueue.removeFirst();
                    System.out.println("consumed item....."+ count);
                     count++;
                    blockingQueue.notifyAll();
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
