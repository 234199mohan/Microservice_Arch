package com.mohan.practise;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentCalc {

    public static void main(String[] args) {

        List<Student> studentList = Stream.of(
                new Student(1, "mohan", 34, "Male", "Computer Science", "Almora", 122, Arrays.asList("234199", "123456")),
                new Student(2, "ravi", 40, "Male", "Computer Science", "Delhi", 100, Arrays.asList("222222", "4444444")),
                new Student(3, "gunjan", 25, "Female", "Electronics", "Agra", 80, Arrays.asList("234199", "123456")),
                new Student(4, "sanku", 18, "Male", "Computer Science", "Bangalore", 50, Arrays.asList("5555555", "66666")),
                new Student(5, "mohan", 28, "Male", "Math", "Noida", 300, Arrays.asList("45454545", "676767")),
                new Student(1, "deepa", 40, "Female", "MBA", "Noida", 666, Arrays.asList("234199", "123456"))

        ).collect(Collectors.toList());


        // 1: find the list of students whose rank is between 50 to 100

        List<Student> studentByRank = studentList.stream().filter(obj -> obj.getRank() >= 50 && obj.getRank() <= 100).collect(Collectors.toList());

        studentByRank.stream().forEach(obj -> {
            System.out.println(obj.getId() + "---------- " + obj.getName() + " --------------  " + obj.getRank());
            ;
        });

        //2: student whose department is computer science and sort them by there name
        List<Student> studentByDept = studentList.stream().filter(obj -> obj.getDept().equalsIgnoreCase("Computer Science")).collect(Collectors.toList());
        Collections.sort(studentByDept, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("");

        studentByDept.stream().forEach(obj -> {
            System.out.println(obj.getId() + "---------- " + obj.getName() + " --------------  " + obj.getDept());
            ;
        });

        System.out.println("");
        List<Student> studentByName = studentList.stream().filter(obj -> obj.getDept().equalsIgnoreCase("Computer Science")).
                sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder())).collect(Collectors.toList());

        studentByName.stream().forEach(obj -> {
            System.out.println(obj.getId() + "---------- " + obj.getName() + " --------------  " + obj.getDept());
            ;
        });
        System.out.println("");
        //3: find all the departments list only

        List<String>deptList = studentList.stream().map(obj->obj.getDept()).distinct().collect(Collectors.toList());

        System.out.print(deptList);

        // group the student by department name

        System.out.println("");
       Map<String, List<Student>> studentDeptGroup = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
       studentDeptGroup.entrySet().stream().distinct().forEach(obj->{
           System.out.println(obj.getKey()  +" ------------------  " + obj.getValue());
       });
        System.out.println("");
       //4: group the student by department name and count of student
        Map<String,Long>studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));

        Map.Entry<String,Long>studentMax = studentMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Maximum Student available in "+ studentMax.getKey() + " and the count is "+ studentMax.getValue());

        //5 find the average age of male and female students


        System.out.println("");
        Map<String,Double> studentGenderGroup = studentList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
        studentGenderGroup.entrySet().stream().forEach(obj -> {
            System.out.println("Total Average of "+obj.getKey()+ "-----------"+ obj.getValue());

        });
        System.out.println("");
        //6: find the highest rank in each department

        Map<String, Optional<Student>> studentDeptMap= studentList.stream().collect(Collectors.groupingBy(Student::getDept,
                Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println(studentDeptMap);

        // find the student who has second rank

        Student sortedStudent = studentList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();

        System.out.println(sortedStudent);


    //count the duplicate in string


     String name = "my name is mohan";
    Map<String,Long>newMap =Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(newMap);

    //remove duplicate from String in java 8
        System.out.println("useCase : remove duplicate from String in java 8");
       Set<String>duplicateAvoidMap =Arrays.stream(name.split("")).collect(Collectors.toSet());

        System.out.println(duplicateAvoidMap);


        System.out.println("case: remove duplicate element from array");

        int []numbers = {1,2,1,3,4,3,5,6,4};
        Arrays.sort(numbers);
        int n=numbers.length;

       int j=0;

        for(int i=0;i<numbers.length-1;i++){

            if(numbers[i]!=numbers[i+1]){
                numbers[j++]=numbers[i];
            }
        }
        numbers[j++] = numbers[n-1];


        for (int i=0; i<j; i++)
            System.out.print(numbers[i]+" ");


        System.out.println(10+20+"Hello");
        System.out.println("Hello"+10+20);
    }








}
