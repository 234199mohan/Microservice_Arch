package com.mohan.user.service.config;


public class JavaHelper {

    public static void main(String[] args) {
        System.out.println("java helper main called");
        for(int i=1;i<=5;i++)
        {
            if(i==1){
                System.out.println("piramid started");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        int [][]numbers = {
                {1,2,3},
                {4,5},
                {6,7,8,9}
        };

        System.out.println(numbers[0][1]);
        int tempwealth =0;
        int wealth =0;
        for(int row=0;row<numbers.length;row++){
            tempwealth=0;
            for(int col=0;col<numbers[row].length;col++){
                System.out.print(numbers[row][col]+ ",");
                tempwealth = tempwealth+numbers[row][col];
            }
            if(wealth<tempwealth) {
                wealth = tempwealth;
            }
            System.out.println("");
        }
        System.out.println("max wealth calculated is "+ wealth);

        int []arr = {1,5,9,3,10,15,6,25};
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                int temp = max;
                max = arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(max);

    }
}
