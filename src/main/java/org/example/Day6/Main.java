package org.example.Day6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * wait() function
 *  this is a method that can be called by a thread and also release the shared resources.
 *  notify() or notifyAll()
 * sleep() function
 *  thread can be temporarily suspend and it does not release the shared resources
 *
 *  start() function vs run() function
 * 1:run method will not create a new thread to execute your code, while start method will create a new thread to
 *          execute it. -> this means that run method will be used by main thread, start method is used by other new thread
 *
 *  2: you can call run method as much as you wan, but you could call start method one time.
 *          start method -> thread state -> from NEW to RUNNABLE -> call start method again -> native start() will check the state is new or not
 *          if the state is not NEW, then given an exception
 * 3:run method will execute your code immediately, whereas start method will wait CPU resources to start
 *
 **** volatile :
 * 1: make different thread can communicate with each other
 *
 * 2: prevent reordering
 *
 * int a = 1;
 * int b = 2;
 * int c = 3;
 * int d = a + b;
 * int e = c + d;
 *
 * -> click run button -> no volatile -> the order may change
 * int b  =2;
 * int c = 3
 * int a = 1; in class
 *
 * -> volatile  -> ordering of your code does not change
 *
 *
 *synchronized -> make sure only one thread can access shared resources at the same time
 *
 *
 * what is cas?
 * cas: compare and swap - > compare and set
 *  ->atomic operation?
 *   it is unit of operations(codes) always execute together, or none of them execute if any exceptions happen
 *
 *  cas processing:
 * Memory location(V): atomic operation will read a value from memory location -> V
 * expected old value(A): I expected the value of V == old value A
 * new value(B): if V == A -> then update with B, otherwise don't do anything.
 *
 * ----time 1 < time 2 < time 3
 * ABA problem in cas
 * thread A -> thread read value V1 and update value to V2 at time 1 -> then change V2 back to V1 at time 2
 * thread B -> thread B read value V1 and update value V3 at time 3
 *
 * AtomicStampedReference
 *
 * they asked:
 *  if you are given int i =0; and two threads, write for updating value of i and read thread for reading value of i
 *
 *
 *  what will happen?
 *  lack of sync, read thread may have a wrong value of i
 *  what if we put volatile keyword with int 1?
 *  what will happen?
 *  the read thread will ALWAYS see the most recent value -> why? ->
 *   any update to value i will be immediately visible to other threads -> in this case, read thread can see updates
 *   **** this not atomic operation!!!!!******
 *
 *   what if we put atomicInteger with i?
 *   the reader thread will AWAYS see the up-to-date value of i
 *
 *
 */
public class Main {
    public static void main(String[] args) { // -> main thread
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int expectedvalue = 0;
        int newValue = 1;
        System.out.println("result is " + atomicInteger.compareAndSet(expectedvalue,newValue));

        AtomicInteger atomicInteger1 = new AtomicInteger(0);
        int expectedvalue1 = 1;
        int newValue1 = 1;
        System.out.println("result is " + atomicInteger1.compareAndSet(expectedvalue1,newValue1));
    }


}
