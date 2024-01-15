package com.mohan.search;

public class BinarySearchAlgo {

    static int binarySearch(int[] number, int target) {
        int start = 0;
        int end = number.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (number[middle] < target) {
                start = middle + 1;
            } else if (number[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] number = {2, 4, 6, 9, 12, 14, 20, 36, 48};
        int data = binarySearch(number, 12);
        System.out.println("target found in the index "+ data);
    }
}
