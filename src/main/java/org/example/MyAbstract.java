package org.example;
//Day 1
//child can use extends to implement abstract class
// you can extend only one abstract class

abstract class MyAbstract {
    String First_name = "my first name"; // public but not a static final
    // can we have constructor here?
    //yes
    public MyAbstract(String first_name){
        this.First_name = first_name;
    }
    // can we have a method without method body?
    //yes
    abstract void thisMethod();// not method body here
    //can we have a method WITH method body?
    //yes
    void thisMyMethod(){
        System.out.println("");
    }
}
