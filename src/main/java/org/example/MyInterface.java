package org.example;

//Day 1
// suppose a child to implement interface(s)
// you can implement more than one interface
// keywork implment should be used in your child class
public interface MyInterface {
    //public MyInterface(){}; not allow constructor here

    // default is static final
    //same to String First_name = "My first Name" -> also it is public static final
    public static  final String First_name = "My first Name";
    void thisIsMyMethod();// you don't need method body, default access modifier is abstract and public

    // after java 8-> you could implement a method in an interface class
    default void thisIsDefaultMethod() {// you have to implement it when you are using default access modifier
        System.out.println();
    }

    static int add(int a, int b) {// you have to implement it when you are using static
        return a + b;
    }
    // can we can private method in an interface? yes, after java 9
//    private int mul(int a, int b ){
//        return a * b;
//    }

}
