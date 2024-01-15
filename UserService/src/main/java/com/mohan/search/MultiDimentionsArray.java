package com.mohan.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mohan.upreti
 */
public class MultiDimentionsArray {

    static int highestSalaryEmployee(int[][] arr) {

        int temp = 0;
        int highestSalary=0;

        for (int row = 0; row < arr.length; row++) {
            highestSalary=0;
            for (int col = 0; col < arr[row].length; col++) {
                 highestSalary = highestSalary+arr[row][col];
            }
            if(highestSalary>temp){
                temp= highestSalary;
            }
        }
        System.out.println("the highest salary is "+ temp);
        return temp;
    }


    public static void main(String[] args) {
        int[][] numberArray =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 5, 1}

                };

        highestSalaryEmployee(numberArray);



        int []data = {5,3,4,1,3,7,2,9,9,4,5,4,3};
        Map<Integer,Integer>numberMap = new HashMap<>();
        int count =1;
        for(int i=0;i< data.length;i++){
            if(numberMap.containsKey(data[i])){
                count = numberMap.get(data[i])+1;
                numberMap.put(data[i],count);
            }
            else{
                numberMap.put(data[i],1);
            }
        }

        System.out.println("The Repeated number set");

        numberMap.entrySet().stream().forEach(obj->{
            System.out.println("for Number ="+ obj.getKey() +"------------- repeated times ="+ obj.getValue());
        });


    }
}
