package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * concurrent hashmap is a hashmap with sync keyword
 *
 * before java 8, concurrent hashmap uses array + linkedlist
 * after java 8, it uses array + linkedList / red-black tree
 *
 * ***we could not have null value
 *
 * do all functions in concurrent hash map has sync keyword?
 *  no, like get() does not have sync keyword...
 *
 *                  in concurrent hashmap, the lock will be added with each segments
 *  [[][][][]..[16 segments]]
 *                  \
 *
 *  blocking queue -> provides thread safe, and extends queue in java
 *
 *  it is producer - consumer model
 *
 *
 * the drawbacks of sync keyword
 * 1: lower performance your application:
 * 2deadlock: if two or more threads are waiting for each other to release lock(shared resources) then
 *          deadlock will occur -> your program will hang.  thread will never complete
 *
 *          thread 1 ->  access shared resource 1 -> depends on shared resource 2
 *          thread 2 -> access resource 2 -> resource 1
 *
 * 3 debugging  -> it can be harder to identify the root cause of issues
 *
 *
 *
 *
 * pessimistic locker
 *
 *
 *
 * optimistic locker
 *
 *
 * reentrantlock
 * mutual exclusion: only one thread can hold locker at the same time. preventing multiple threads from accessing
 *              or modifying the same code or variable
 *
 * reentrancy: A thread can have another lock after getting one lock
 *
 * Fairness: suppose you have 3 threads are waiting outside and trying to get lock [thread 1, thread2, thread3]
 * thread 0 release the lock at this moment, thread 1 will always get the lock first
 *
 *
 * writeAndRead lock -> ReentrantReadWriteLock
 * Fairness: yes
 * reentrancy: yes
 * mutual exclusion: yes for write lock, no for read lock
 *
 *
 * thread pool
 * fixed - size thread pool
 *  it is thread pool has a fixed number of threads -> once you create , all threads are always keep alive
 *  if you know how much threads in you project, you can use it
 *
 *  cached thread pool
 *  it it a thread pool has no fixed number of threads -> you can create thread as much as you want
 *  if a thread in your cached thread pool is idle for a specified time, this thread will be terminated.
 *  have a negative impact on your performance
 *
 *  single thread pool
 *  you have only one thread.
 *
 *
 *  fork join pool: implement work-stealing thread pool
 *
 *      suppose you have a lot huge task need to be executed
 *      this pool will divide huge task into a smaller task, this smaller task will be executed in parallel
 *      if one thread finished first, it will "steal" task from other thread,
 *      suppose thread 1 has very fast execution time, thread 2 has longer execution time
 *      when thread 1 finish tasks, thread 1 try to get some tasks from thread 2
 *
 *
 * executors vs executorservice vs executor
 *
 * executor: it is an interface that has only one method, execute() -> you can execute runnable task
 *
 * executorservice: used for submitting tasks, shutting down. managing tasks
 *
 * executors: is used for creating thread pool
 *
 */
public class Day7 {
//    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
//
//    public void produce() throws InterruptedException {
//        int value = 0;
//        while(true){
//            System.out.println("produce: " + value);
//            queue.put(value++);
//        }
//    }
//
//    public void consume() throws InterruptedException{
//        while (true){
//            if(queue.size() == 10){
//                int value = queue.take();
//                System.out.println("Consume: " + value);
//                Thread.sleep(1000);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        // two threads
//        Day7 day7 = new Day7();
//        Thread produceThread = new Thread(()->{
//            try {
//                day7.produce();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//
//
//        Thread consumerThread = new Thread(()->{
//            try {
//                day7.consume();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//        produceThread.start();
//        consumerThread.start();


//
//    }
    private int counter = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Day7 day7 = new Day7();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    day7.increment();
                    // do something else here
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

        // multiple threads
        Thread t1 = new Thread(task, "1");
        Thread t2 = new Thread(task, "2");
        t1.start();
        t2.start();
    }

    public void increment(){
        reentrantLock.lock();
        try {
            counter++;
            System.out.println("counter is " + counter);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();//release
        }
    }

}
