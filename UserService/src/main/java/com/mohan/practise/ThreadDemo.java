package com.mohan.practise;

public class ThreadDemo {


    public static void main(String[] args) {


        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };

        Thread t2 = new Thread(t1){
            public void run() {
                System.out.println("Thread");
            }
        };
        t2.start();
    }
}
