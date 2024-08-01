package org.example.Day2;

import java.util.*;

/**
 * "This"  and "Super"
 * "This": points to current
 * what are ways we can use "this" keyword
 *  1:  **"this" can be used to reference current object**
 * 2: use this keyword to call constructor
 *  3: this keyword can be used as parameter
 *  4: this keyword can be used a constructor parameter
 *  5:  we can return  this keyword
 *  what is chaining function? -> new Student().setName("asd").setAge(123).setXX("sasdf")
 *  Student st1 = new Student();
 *  st1.setName("asd");
 *  st1.setXX("ajkhsdf");
 *
 *  Super:
 *      three ways to use
 *      1: points to parent object. super();
 *      2:call parent function: super().callParentMethod();
 *      3:call parent's constructor
 *
 *
 *
 *
 *  exceptions:
 *  what is an exceptions?
 *      catch expected errors
 *      checked exception: compile time
 *      IOException, SQLexpcetion
 *
 *      unchecked exception: runtime exception
 *      indexOutOfBounds
 *
 *
 *  Error:
 *      OutOfMemory
 *
 *
 * how to catch an exception?
 * using throws, throw, try catch finally block
 *
 *
 *
 * error vs exception
 * error is something you are not expected
 * exception is something you are expected
 *
 * Static vs non static
 *
 * static belongs to class itself, not an obeject
 * non static method cann't be called in static method
 *
 *
 *
 *
 * Java 8 collections
 * arraylist, stack, list, vector, priorityqueue, hashmap, treemap, hashSet...
 *
 * Arraylist:
 *      1: to access one element by using indexing -> why we can do this?
 *          ***bc arraylist implement RandomAccess class to allow you access or get any random***
 *          element at the same speed -> O(1)
 *      2: **default capacity = 10**
 *      3: arraylist is using list Object[] to store elements
 *      4: modCount -> for multi threading envior...
 *      5: oldCapacity >> 1   right shift operation   0010 -> 2 -> 0010 >> 1 -> 1
 *              **new capacity = old + 0.5 * old capacity = 1.5 capacity**
 *
 *
 *       6: time complexity in array list:
 *          add(1) -> O(1) in the best case, O(N) -> when -> when array list has to resize
 *          add(index, element) -> O(N)
 *          get() -> always O(1)
 *          remove() -> O(n)
 *          indexof() -> O(n)
 *          contains() -> O(n)
 *
 *
 *
 *  Stack + vector: what is stack? first in last out data structure
 *
 *      stack grow method: new cap =
 *              1: old cap + capacityIncrement
 *              2: 2 * old cap
 *
 *
 *      time complexity:
 *         stack push O(1) pop O(1) size() O(1)
 *         vector: add remove, size() -> O(1)
 *
 *
 *  how can you make general arraylist to synchronized?
 *          List<String> myGeneralList = new ArrayList<>();
 *         List<String> list = Collections.synchronizedList(myGeneralList);
 *
 *      time complexity:
 *          add() -> O(1)
 *          add(index, element) -> O(N)
 *          get() O(N)
 *          remove O(N)
 *
 *
 *    Deque - > FILO and FIFO
 *    double ended queue
 *
 *
 *
 *
 * Priority queue -> min heap
 *
 *     1
 *     /\
 *     5 10
 *     /\  /\
 *     7 9 15 11
 *     /\
 *   13  20
 * [1, 5 , 10, 7 , 9, 15 , 11, 13, 20]
 * parentIndex is given
 * leftIndexNo = parent index * 2 + 1
 * rightIndexNo = parent index * 2 + 2
 * parentNode = (node index no - 1) / 2
 *
 *
 *
 * HashMap
 *before java 8 hashmap use linked list to store node
 *
 * after java 8 hashmap use linked list + red - black tree
 *
 * when hashmap start to transfer from linked list to red -black tree
 *  the linked list size is greater than 8
 *  when does hashmap start to transfer red-black tree to linked list
 *      the number of elements  in tree are less than 6
 *
 * how does hashmap put() works?
 * 1: calculate hash value
 *     static final int hash(Object key) {
 *         int h;
 *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *     }
 *
 *     h = key.hashCode(): 1111 1111 1111 1111 1111 0000 1110 1010 -> random value
 *                         0000 0000 0000 0000 1111 1111 1111 1111
 *                         1111 1111 1111 1111 0000 1111 0001 0101 - >(h = key.hashCode()) ^ (h >>> 16)
 *     (p = tab[i = (n - 1) & hash] where "hash" = (h = key.hashCode()) ^ (h >>> 16)
 *                         1111 1111 1111 1111 0000 1111 0001 0101
 *                         0000 0000 0000 0000 0000 0000 0000 1111
 *                         0000 0000 0000 0000 0000 0000 0000 0101 = 5 -> index
 *
 *   2: if there is null, tab[5] == null -> means that it is empty and no hash collision, then just store current value
 *   3: if there has an element or exits hash collision. hashmap will do the following steps
 *         1: IF hashmap is using red-black tree, then call red-black tree insertion to put value
 *         2: if hashmap is not using red-black tree( using linked list), then put value.
 *                  2.1: after inserting new node into tab table, hashmap will check the size, if the size> threshold
 *                          then resize to red-black tree.
 *
 *     new cap = old * 2
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class DayTwo {
//    public static void main(String[] args) {
//            Student student = new Student("Pengfei Yao",28);
//            student.out();
//            //chaining function
//            new People().setAge(28).setFirstname("Pengfei").setLastName("Yao");
//    }

    public static void main(String[] args) { // throws ClassNotFoundException
        try{
            Class clazz = Class.forName("com.abc.xyz");
        }catch (Exception e){
            e.printStackTrace();
        }
       // nonStaticMethod();


        //array list
        List<String> myGeneralList = new ArrayList<>();
        List<String> list = Collections.synchronizedList(myGeneralList);


        //deque
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("Apple");
        deque.addFirst("banana");

        deque.addLast("orange");

        String firstElement = deque.removeFirst();
        String lastElement = deque.removeLast();
        // leet code question: implementing stack by using deque


        Deque<String> d1 = new ArrayDeque<>();
        d1.addFirst("A");
        d1.addFirst("B");
        d1.addFirst("C");
        d1.addFirst("D");
        Iterator<String> iterator = d1.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element); // Ab cd
        }


        PriorityQueue<Integer> minHeap = new PriorityQueue();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(4);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(4);

    }
    public void nonStaticMethod(){

    }
}
class Student{
    private String name;
    private int age;
    public Student (){
        System.out.println("no variable constructor");
    }
    public  Student(String name, int age){
        // "this keyword used to call constructor"
        this();
        this.name = name;
        this.age = age;

    }
    void out(){
        System.out.println(name  +"   " + age);
    }
    void method1(Student student){
        System.out.println(student.age);
    }
    void method2(){
        method1(this);// we use this keyword as a parameter
    }

}

class People{
    private int age;
    private String firstName;
    private String lastName;
    public People setAge(int age){
        this.age = age;
        return this;
    }
    public People setFirstname(String name){
        this.firstName = name;
        return this;
    }
    public People setLastName(String name){
        this.lastName = name;
        return this;
    }

}
