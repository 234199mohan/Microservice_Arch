package com.mohan.search;

public class BinarySearch {
    /**
     * @author mohan.upreti
     * @param num
     * @param target
     * @return
     */
    static int  binary(int[] num, int target) {

        int end = num.length;
        int start = 0;
        while (start <= end) {
            int mid = end - (end - start) / 2;
            if (num[mid] > target) {
                end = mid - 1;
            }
            if (num[mid] < target) {
                start = mid + 1;
            }
            if (num[mid] == target) {
                System.out.println("found the target number  " + num[mid] + "  in index  " + mid);
               return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] inputData = {1, 4, 8, 9, 12, 15, 36, 40};
        int target = 8;
        binary(inputData, target);
    }
}
