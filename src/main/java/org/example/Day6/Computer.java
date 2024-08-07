package org.example.Day6;

import java.util.concurrent.TimeUnit;

public class Computer {

    /**
     * case 1:
     * google email is printed first -> why ? -> as long as one thread call one sync method at certain time
     *  other thread(s) should wait the current thread to finish ->
     *  in another world, sync keyword locks the current object: "this" -> computer0
     */
//    public synchronized  void googleEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("google email is sent");
//    }
//
//    public synchronized void XEmail(){
//        // very fast
//        System.out.println("X email is sent");
//    }

//    public static void main(String[] args) {
//        Computer computer0 = new Computer();
//        new Thread(() ->{
//            computer0.googleEmail();
//        },"thread1 with google").start();
//        new Thread(()->{
//            computer0.XEmail();
//        },"thread2 with x").start();
//    }

    /**
     * case 2: when we call sync method and non-sync method at the same time
     *  non-sync method is printed first
     *  which means we don't have resource competition -> non-sycn allows another thread to execute your code
     */

//    public synchronized  void googleEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("google email is sent");
//    }
//
//    public synchronized void XEmail(){
//        // very fast
//        System.out.println("X email is sent");
//    }
//
//    public void facebookEmail(){// no sync keyword here
//        System.out.println(" you are using facebook email");
//    }

//    public static void main(String[] args) {
//        Computer computer0 = new Computer();
//        new Thread(() ->{
//            computer0.googleEmail();
//        },"thread1 with google").start();
//        new Thread(()->{
//            computer0.facebookEmail();
//        },"thread2 with x").start();
//    }


    /**
     * case 3:
     * when we are using different thread and objects call sync method at the same time, there is not resource competition
     * when are using different thread and objects call sync and non-sync at the same time, there is also not resources competition
     *
     */
//    public  synchronized  void googleEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("google email is sent");
//    }
//
//    public synchronized void XEmail(){
//        // very fast
//        System.out.println("X email is sent");
//    }
//
//    public void facebookEmail(){// no sync keyword here
//        System.out.println(" you are using facebook email");
//    }
//    public static void main(String[] args) {
//        Computer computer0 = new Computer();
//        Computer computer1 = new Computer();
//        new Thread(() ->{
//            computer0.googleEmail();
//        },"thread1 with google").start();
//        new Thread(()->{
//            computer1.XEmail();
//        },"thread2 with x").start();
//    }


    /**
     * case 4: with static and sync keyword
     *
     * some resources with static are belong to class itself.
     *
     * for the non-static method, your locker: sycn will lock the current object: this -> computer0
     * for the static method, your locker will lock the class resources: Computer
     */
//    public  static synchronized  void googleEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("google email is sent");
//    }
//
//    public static synchronized void XEmail(){
//        // very fast
//        System.out.println("X email is sent");
//    }
//
//    public void facebookEmail(){// no sync keyword here
//        System.out.println(" you are using facebook email");
//    }
//    public static void main(String[] args) {
//        Computer computer0 = new Computer();
//        Computer computer1 = new Computer();
//        new Thread(() ->{
//            computer0.googleEmail();
//        },"thread1 with google").start();
//        new Thread(()->{
//            computer1.XEmail();
//        },"thread2 with x").start();
//
//    }

    /**
     * case 5:
     * for the non-static method, your locker: sycn will lock the current object: this -> computer0
     * for the static method, your locker will lock the class resources: Computer
     */

    public  static synchronized  void googleEmail(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("google email is sent");
    }

    public  synchronized void XEmail(){
        // very fast
        System.out.println("X email is sent");
    }

    public void facebookEmail(){// no sync keyword here
        System.out.println(" you are using facebook email");
    }
    public static void main(String[] args) {
        Computer computer0 = new Computer();
        Computer computer1 = new Computer();
        new Thread(() ->{
            computer0.googleEmail();
        },"thread1 with google").start();
        new Thread(()->{
            computer1.XEmail();
        },"thread2 with x").start();

    }

}
