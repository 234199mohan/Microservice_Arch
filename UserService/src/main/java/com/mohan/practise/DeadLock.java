package com.mohan.practise;

public class DeadLock {


    public static void main(String[] args) throws InterruptedException {

        String resource1 = "resource1";
        String resource2 = "resource2";

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked Resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: Locked Resource 2");
                }
            }
        });


        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked Resource 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: Locked Resource 1");
                }
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }

}


