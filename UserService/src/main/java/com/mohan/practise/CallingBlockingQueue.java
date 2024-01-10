package com.mohan.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallingBlockingQueue {
    static int finalCount = 0;

    public static void main(String[] args) {

        CustomBlockingQueue<Integer> blocking = new CustomBlockingQueue(10);

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future> futureList = new ArrayList<>();


        Future<Integer> futureData = service.submit(new Callable<Integer>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    finalCount = finalCount + i;
                    blocking.producer(i);
                    Thread.sleep(1000);
                }

                return finalCount;
            }
        });
        futureList.add(futureData);

        Future<Integer> futureData2 = service.submit(new Callable<Integer>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    finalCount = finalCount + i;
                    blocking.consumer(i);
                    Thread.sleep(2000);
                }

                return finalCount;
            }
        });

        futureList.add(futureData2);



        futureList.stream().forEach(obj->{
            try {
                System.out.println("future result for "+ obj.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
