package org.example.Day3;

import java.util.ArrayList;
import java.util.concurrent.*;

public class comFuturn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // your tasks are send emails to IT team, HR team and CEO

        // each task will cost 500 MS
        long startTime = System.currentTimeMillis();

//        try{
//            // send an email to IT team
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        try{
//
//            // send an email to HR team
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        try{
//            // send am emial to CEO
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

// why thread pool
        // java create/destroy a thread -> cost a lot cpu resources
        // can we have a pool keep thread(s) alive?
        // then you can use thread pool
        // -> speed up you application by using thread pool
        // why speed up?
//        // bc you don't need to create / destroy threads
        ExecutorService threadpool  = Executors.newFixedThreadPool(3);
        //improve above code
       // ---------0-- timeline----------------510-------------
         // task 1 -------------------------> 500 ms
        // task 2    -------------------------->500 ms
        // task 3     ---------------------------> 500ms
        FutureTask<String> futureTask1 = new FutureTask<>( ()->{
            try{
                // send an email to IT team
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "IT Team receive email";
        });
        threadpool.submit(futureTask1);
        FutureTask<String> futureTask2 = new FutureTask<>( ()->{
            try{
                // send an email to IT team
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "HR Team receive email";
        });
        threadpool.submit(futureTask2);
        FutureTask<String> futureTask3 = new FutureTask<>( ()->{
            try{
                // send an email to IT team
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "CEO  receive email";
        });
        threadpool.submit(futureTask3);
        try{
            futureTask1.get();
            futureTask2.get();
            futureTask3.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("cost time :  " + (endTime - startTime));
        threadpool.shutdown();



        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println(completableFuture1.get());


        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },executorService2);
        System.out.println(completableFuture2.join());
        executorService2.shutdown();

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "hello, I am supplyAsync()";
        });
        System.out.println(completableFuture3.join());


        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Hello, I am supply Async with executors";
        },executorService3).whenComplete((r,e)->{
            System.out.println(" task is finished");
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("exception is happen");
            return null;
        });
        System.out.println(completableFuture4.join());
        executorService3.shutdown();



        // then apply example

        ExecutorService executorService4 = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> completableFuture5 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 3;
        },executorService4).thenApply( r->{// this "r" will take result form the top,
            System.out.println("this is step 2 and compute 3");
            return r + 1;
        }).thenApply( r->{ // this "r" will take result from r + 1
            System.out.println("this is step 3");
            return r + 2;
        }).whenComplete((r,e) ->{
            if(e == null){
                System.out.println("the result is " + r);
            }
        });
        System.out.println(completableFuture5.join());
        executorService4.shutdown();
    }
    //thenRun
    // thenaccept
    //thenapply

        ArrayList<>





}
