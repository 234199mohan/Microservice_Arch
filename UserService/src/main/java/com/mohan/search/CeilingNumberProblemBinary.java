package com.mohan.search;

public class CeilingNumberProblemBinary {

    static int ceilingNumberCalculator(int[] num, int target) {

        int start = 0;
        int end = num.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (num[mid] < target) {
                start = mid + 1;
            }
            if (num[mid] > target) {
                end = mid - 1;
            }
            if (num[mid] == target) {
                return num[mid];

            }
            if (num[mid] < num[start] && num[start] > target && num[end] > target) {

                return num[start];
            }
            if (num[start] > target) {
                return num[start];
            }
            if (num[end] < target) {
                return -1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 9, 14, 16, 18};
        int target = 14;
        int ceilingNUmber = ceilingNumberCalculator(numbers, target);
        if (ceilingNUmber == -1) {
            System.out.println("target element out of the range....");
        } else {
            System.out.println("Ceiling Number of target " + target + " is " + ceilingNUmber);
        }
    }
}
