package com.mohan.practise;


import java.util.LinkedList;

/**
 * @param <E>
 * @param <S>
 * @author mohan.chandra
 */
public class CustomBlockingQueue<E> {

    LinkedList<E> blockingQueue = new LinkedList<>();
    int maxSize;

    CustomBlockingQueue(int maxSize) {
        this.maxSize = maxSize;

    }

    synchronized void producer(E item) throws InterruptedException {
        if (blockingQueue.size() == maxSize) {
            System.out.println("Queue is full waiting consumer to add some items........");
            wait();
        }
        if (blockingQueue.isEmpty()) {
            notifyAll();
        }
        blockingQueue.add(item);
        System.out.println("Producer has added the item into queue " + item);


    }



    synchronized void consumer(E item) throws InterruptedException {
        if (blockingQueue.isEmpty()) {
            System.out.println("Queue is Empty waiting producer to remove some items........");
            wait();
        }
        if (blockingQueue.size() == maxSize) {
            notifyAll();
        }
        blockingQueue.removeFirst();
        System.out.println("Consumer has consumed the item from queue " + item);
    }


    <U> U ThreadScheduling(U userThread){

        return (U) Integer.valueOf(userThread.toString());
    }

}
