package org.example.Day5;

/**
 * JVM - > Java virtual machine -> run a java program
 *  System.out.println("Hello");
 *              |
 *              |       Java complier
 *              Bytecode: .class file
 *              |
 *              [JVM] ->class loader <---> runtime data areas  <-------> execution engine
 *              |
 *             "Hello"
 *
 *      ***classLoader: will load .class file into your JVM
 *      ***runtime data areas: memory -> bytecode, objects, local variables, return values...
 *      ***execution engine: executing your bytecode: .class file. -> also handle memory management and GC
 *
 *      suc component of runtime areas:
 *
 *
 *
 *      1: stack:
 *          it used to store data for method invocation: method arguments, return value. local variables -> this allow us to track the execution of method invocation
 *          this area is now shared,
 *          Error: stackOverFlowError:
 *
 *      2: memory area
 *          in memory ares, we could find: method data, .class file, method definitions, constant, static variables.
 *          this area is shared, which means other thread can access.
 *
 *      ***3: heap
 *          three components you need to know
 *          1: eden space(young generation): this place is where you need to store new objects.
 *          2:survivor space (young generation): S0, S1 -> store live objects after a GC
 *          3:old generation: store live objects after multiple GC
 *          4: metaspace: information about class file
 *
 *
 * how can we define a live object?
 * the referencing counting method:
 *  Object A=  new Object
 *  Object B = new Object
 *  A.instance = B.instance
 *  B.instance = A.instance
 *  ...
 *
 *
 *  ***The GC roots method
 *   it is an object in java:
 *      local variable:
 *      static varible
 *      thread stack
 *      classes, and class loaders
 *      /./..
 *
 * garbage collection :
 * STW: stop  the world: stop you application
 *
 *
 * 1: mark-sweep algorithm - normal deletion
 *
 * 2:mark-sweep-compact algorithm
 *
 * ***CMS: concurrent mark and sweep -> minimizing # of STW
 *  1:initial mark(STW)
 *      identify the gc roots set
 *  2: concurrent mark:(No STW)
 *      while the application is running, the CMS algorithm continues the marking process by tracing the object from gc roots set
 *
 *  3:remark(STW)
 *      remarking all object again
 *  4:concurrent sweep - reset
 *      reclaim memory from dead objects and prepare for the next cycle
 *
 *
 *
 *
 *
 * ***G1
 *
 * 1: initial mark: mark the live object in the old generation -> this phase is done concurrently with the application threads.
 *      you have minimal impact on app performance
 * 2: concurrent marking
 *      mark more live object in all of the heap -> the application to continue running
 *3: remark
 *  mark any objects that may have been modified since initial marking phase -> STW
 *
 *  4:concurrent clean up -> no STW
 *
 *  5:evacuation
 *      to move live objects from one region to another.-> improve overall heap utilization
 *
 *
 * ...
 *
 *
 * Thread
 * **how many ways to create a thread?
 *  1: class MyThread extends Thread{
 *      you need to override run()
 *
 *  }
 * 2: class myRunnale implements Runnable{
 *
 *     you need override run()
 * }
 * 3: class MyCallable implements Callable<String>{
 *     public String call() throws Exception{
 *         return "this is my thread"
 *     }
 * }
 *
 * Runnable vs Callable
 * runnable does not return a value whereas callable has a return
 * runnable does throw an exception, whereas callable has an expcetion
 *
 * **what are thread states you know
 *
 *  new: you create a thread, but no started yet
 *  runnable: for thread is executing
 *  block:
 *  waiting
 *  time waiting
 *  terminate
 *
 */
public class DayFive {
    public static void main(String[] args) {
        System.out.println("Hello");

    }
}
