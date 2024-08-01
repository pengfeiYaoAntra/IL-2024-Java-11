package org.example.Day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Java 8 new features
 *  interface vs functional interface
 *
 *  functional interface has only method and it has functinalInterface annotation
 *
 *  runnale, callable, comparator, consumer, Function class (a method), predicate, supplier
 *
 *
 * lambda expression: it is a function/ method without name -> anonymous function
 *
 * lambda expression without parameter: () -> {System.out.print("something")}
 * lambda expression  with parameter (a) -> a * a;
 *Before Java 8
 * new Thread(new Runnable(){
 * @override
 *  public void run(){
 *     System.out.print("I am creating a new thread");
 *  }
 * }).start();
 *
 * ->  I am creating a new thread
 *
 * After Java 8
 * new Thread(()->System.out.print("I am creating a new thread")).start();
 *
 *
 * ******Stream api******
 * allows you to perform some operations on java collections: arraylist
 * stream api has two parts: intermediate function + terminal function
 *
 * intermediate functions:
 *
 *  filter
 *  map
 *  flatmap
 *  distinct()
 *  sorted()
 *  limit()
 *
 *  terminal functions
 *      forEach()
 *      reduce
 *      collect
 *      anyMatch
 *      allmatch
 *      Nonematch
 *
 *
 *
 * stream api vs collections
 * collections are data structures that store values, whereas stream api does not store values
 * collections can be modified by adding or removing elements, whereas stream api does modify the original data ->
 *      create a stream to do operations
 * collections are useful for storing and organizing data, whereas stream api is useful for processing data.
 */
public class DayThree {

    public static void main(String[] args) {
//        Calculator add = (a,b) -> a + b;
//        System.out.println(add.calculate(1,1));
//        List<Integer> number = Arrays.asList(1,2,4,5,6,7); // -> double all elements in this arraylist using labmda function
//        //
//        number.forEach( n -> {
//            int x = n * 2;
//            System.out.println(x);
//        });
//
//        //lambda function to create a max heap
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
//        //comparator
//        List<String> str = Arrays.asList("java","Spring", "Kotlin", "Scala");
//        Collections.sort(str, (String a, String b) -> b.compareTo(a));



        //stream api
        // select strings start with a
        List<String> list = Arrays.asList("a1","a2","c1","b1","d3", "A3", "A4", "C2", "Acd123", "AWQ", "DFG123");
        list.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        //I would like to select all strings that contains  uppercase
        List<String> newLIst = list.stream()
                .filter(str -> str.chars().allMatch(Character::isUpperCase)) // do anyMatch
                .collect(Collectors.toList());
        System.out.println(newLIst);

        System.out.println(list);

        // use list, select all string that contains number  and lower case: 1,2,3...
        //hint: two filters -> one filter -> filter out all string contains -> regex -> .*\\d.*
        //hint : second filter -> filter out all string contains lower  case

        list.stream()
                .filter(str -> str.matches(".*\\d.*"))
                .filter(str -> str.chars().anyMatch(Character::isLowerCase))
                .forEach(System.out::println);


        // reduce
        //
        List<Integer> nums = Arrays.asList(2,1,4,5,7,8,11,22);
        // I would like to sum all even numbers
        int sum = nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0,Integer::sum);
        System.out.println(sum);


        // find the max number in nums
        int max = nums.stream().reduce(Integer::max).get();

        //
        boolean ifAnyMatch = nums.stream()
                .anyMatch( number -> number > 20);
        if(ifAnyMatch){
            System.out.println("yes");
        }
        boolean ifAllMatch = nums.stream().allMatch(number -> number > 20);
        if(ifAllMatch){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }

    }
}
