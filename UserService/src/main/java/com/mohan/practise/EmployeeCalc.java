package com.mohan.practise;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeCalc {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1234, "Mohan", "dev", 2));
        employeeList.add(new Employee(1234, "Sachin", "dev", 2));
        employeeList.add(new Employee(1234, "Ravi", "QA", 2));
        employeeList.add(new Employee(1234, "abd", "MAN", 2));
        employeeList.add(new Employee(1234, "Ramesh", "dev", 2));

        Map<String,Integer>empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingInt(Employee::getCodeCommit)));

        Optional<Map.Entry<String,Integer>>finalMap = empMap.entrySet().stream().max(Map.Entry.comparingByValue());

        Map.Entry<String,Integer>data = finalMap.get();

        System.out.println(data.getKey() + "-------"+ data.getValue());

        Map<String, Integer> employeeDepMap = new HashMap<>();

        for (Employee emp : employeeList) {

            if (employeeDepMap.containsKey(emp.getDepartment())) {
                int updatedCount = employeeDepMap.get(emp.getDepartment()) + emp.getCodeCommit();
                employeeDepMap.put(emp.getDepartment(), updatedCount);

            } else {
                employeeDepMap.put(emp.getDepartment(), emp.getCodeCommit());
            }


        }
        Optional<Map.Entry<String, Integer>> mapData = employeeDepMap.entrySet().stream().max(Map.Entry.comparingByValue());
        Map.Entry<String, Integer> mappingfinalData = mapData.get();
        System.out.println("highest count commit of department and count" + mappingfinalData.getKey() + "----------" + mappingfinalData.getValue());

    }
}
