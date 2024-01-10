package com.mohan.practise;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i=0;i<=5;i++){
            service.execute(new Task());

        }
        Thread.sleep(100);
        System.out.println("Thread Name of Executor class: " + Thread.currentThread().getName());
    service.shutdown();

    }


}
