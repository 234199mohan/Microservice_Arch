package com.mohan.search;

public class SmallestCharacter {

    public static char nextGreatestLetter(char[] letters, char target) {

        int end = letters.length - 1;
        int start = 0;

        while (start <= end) {

            int middle = start + (end - start) / 2;

            if (letters[middle] > target) {
                end = middle - 1;
            }else{
                start = middle+1;
            }
        }

        return letters[start % letters.length];
    }



    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'f', 'g', 'k', 'l', 'n', 'p'};
        char target = 'p';
        char letter = nextGreatestLetter(letters, target);
        System.out.println("Smallest character which is greater then target element  " +target + "  is = -------> "  +  letter);

    }
}
