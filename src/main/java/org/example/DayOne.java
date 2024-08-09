package org.example;

/**
 * Day 1
 *
 * What is an object?
 *  state:
 *  behaviors: functions
 *
 *  polymorphsim: many forms? -> same method can have different way to perform
 *  overloading: complie time
 *      the same method name, but different variables: such as, the number of variables, the types
 *  overriding: runtime
 *      it happens in a child class. child class would like to interitance some parent's methods, you can
 *      implement it in a different way.
 *
 *
 *   can we override a data members in class -> NO
 *   class Animal{
 *
 *       string firstname = "ABC"
 *   }
 *
 *   class dog extends Animal {
 *       String firstname = "CBA"
 *   }
 *
 *
 *   Encapsulation:
 *      private String first<- getter to get the current value , setter method to reset or update your value
 *      why do we need to use this: we always need to protect  data.
 *
 *
 *  Abstraction:
 *      ****abstract vs Interface****
 *      Abstract class:
 *          an abstract is a class that cannot be instantiated. it serves as a base class for subclasses
 *          it can have both abstract and non-abstract method
 *          it can have constructor
 *          A class can extend only one abstract class
 *
 *      Interface:
 *          you are not allow to have constructor
 *          A subclass can implement more than one interface
 *          you can have default and static method after java 8
 *          private is allowed after java 9
 *
 *
 *      why you can not extends multiple class?
 *      the diamond problem
 *               abstract class: crab
 *              /        extends     \
 *                   red crab   herb crab
 *                          |  /
 *                        blue crab
 *  inheritance: code reusability
 *
 *  primitive type vs wrapper type -> wrapper type has more functions you can use
 *  primitive type   default value     length
 *  boolean           false                 1bit
 *  int                 0                   2byte???
 *  short               0                   2byte???
 *  long                 0L                 8 byte
 *  double              .0                  8byte
 *  float               0.0f                4byte
 *  char                 '\u0000'              2byte???
 *
 *  wrapper type
 *
 *  Integer, Boolean...
 *  you need to know the range of wrapper type
 *  Integer range [-128,127] see cases below, you need always watch out the range
 *
 *
 *
 *String vs StringBuilder vs StringBuffer
 * String class is immutable class, which means you cannot change value of string later
 * StringBuilder allows you to modify value of string
 * StringBuffer is synchronized
 *
 *access modifiers
 *              class   package         subclass        world(global)
 * public:        Y         Y               Y               Y
 * protected:     Y         Y               Y               N
 * default:       Y         Y                N               N
 * private:       Y         N                 N               N
 *
 * does Java use pass by value of pass by reference?
 *  Java always use pass by reference
 *  for primitive type: the actual value (such as int i = 11) is passed
 *
 *shallow copy vs deep copy
 *
 * shallow copy: both original object and copied object point to the same address
 * deep copy: original object and copied object point to the different address
 *
 * shallow copy
 * class User implement Cloneable{
 *     String name;
 *     int age;
 *     ..
 * @Override
 * protected Object clone() throws Exception{
 *
 *     return super.clone();
 * }
 *
 *
 * }
 *
 * main{
 *
 *     User original = new User("my name", 28);
 *     User shallowCopied = (User) original.clone();
 *
 * }
 *
 *
 * deep copy
 * class User implement Cloneable{
 *  *     String name;
 *  *     int age;
 *  *     ..
 *  * @Override
 *  * protected Object clone() throws CloneNotSupportedException{
 *  *
 *  *     User cloned = (User) super.clone();
 *        return cloned
 *  * }
 *  *
 *  *
 *  * }
 *  *
 *  * main{
 *  *
 *  *     User original = new User("my name", 28);
 *  *     User deepcopy = (User) original.clone(); // different
 *  *
 *  * }
 *
 *
 * "this" keyword vs "Supper" keyword
 *
 * exception
 * ...
 *
 */
public class DayOne {
    public static void main(String[] args) {
        Integer i1 = 12;// -> valurOf function -> create an integer with address Ox123456
        Integer i2 = 12;// -> valurOf function -> jsut return cached "12" -> points to the same address
        // you are using "==", you are comparing two object with address Ox123456
        System.out.println(i1 == i2); //true


        Integer i3 = 333;// -> valurOf function -> create an integer with address Ox123457
        Integer i4 = 333;// return a new integer object with addres OX1098765
        System.out.println(i3 == i4);//false

        //Integer i5 = new Integer(12);
        //System.out.println(i5 == i1);// false
       String st1 = "first";
       String st2= "second";
       String st3 = st1 + st2; // StringBuilder(st1) + StringBuilder(St2)

        //access modifiers
        //
        int myInt =11;
        changeInt(myInt);
        System.out.println(myInt); // 11
    }
    public static void changeInt(int myint){
        myint = 12;
    }

}
