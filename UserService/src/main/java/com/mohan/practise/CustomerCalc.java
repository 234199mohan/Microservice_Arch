package com.mohan.practise;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerCalc {



    public static void main(String[] args) {

        List<Customer> customerList = Stream.of(
                new Customer("mohan", "marathalli", 5000),
                new Customer("suresh", "btm_layout", 3000),
                new Customer("mina", "marathalli", 1000),
                new Customer("sankalp", "mina", 5000),
                new Customer("gunjan", "sjr", 5000),
                new Customer("mina", "brrokfield", 5000),
                new Customer("mina", "marathalli", 100000)

        ).collect(Collectors.toList());

        //case1: need the area whose max earning in any area (like which area customer earning more)

        Map<String, Integer> customerMap = customerList.stream().collect(Collectors.groupingBy(Customer::getArea, Collectors.summingInt(Customer::getAmount)));

        Optional<Map.Entry<String, Integer>> finalMap = customerMap.entrySet().stream().max(Map.Entry.comparingByValue());

        Map.Entry<String, Integer> finalData = finalMap.get();

        System.out.println("the Highest Collection from area is  " + finalData.getKey() + " and total collection is  " + finalData.getValue());

        //case2: total collection amount from all areas
        int data = customerList.stream().mapToInt(Customer::getAmount).reduce((obj1, obj2) -> obj1 + obj2).getAsInt();

        System.out.println("All Customer collection in Bangalore Area is " + data);

        //case 3: shorting by customer name and then highest collection wise

        Comparator<Customer> sortedByName = Comparator.comparing(Customer::getName);
        List<Customer> sortedList = customerList.stream().sorted(sortedByName).collect(Collectors.toList());


        Collections.sort(sortedList, new Comparator<>() {

            @Override
            public int compare(Customer o1, Customer o2) {

                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return Integer.valueOf(o2.getAmount()).compareTo(Integer.valueOf(o1.getAmount()));
                }
                return 0;
            }
        });

        sortedList.stream().forEach(obj -> {
            System.out.println(obj.getName() + "----------------" + obj.getAmount());
        });


        //case3: streams map(if you want to apply some operation into the element itself)

        List<Integer>numbers = customerList.stream().map(obj -> obj.getAmount() * obj.getAmount()).collect(Collectors.toList());
        numbers.stream().forEach(obj->{
            System.out.print(obj+ ", ");
        });

        System.out.println("");
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
        System.out.println(G7Countries);





    }
}