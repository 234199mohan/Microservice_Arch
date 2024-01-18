package com.mohan.string.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlikeString {

    public static boolean alikeCalculate(String input) {
        int mid = input.length() / 2;
        String first = input.substring(0, mid);
        String second = input.substring(mid);
        int firstcount = 0;
        int secondCount = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> vowList = new ArrayList<>();
        for (char vow : vowels) {
            vowList.add(vow);
        }

        for (char obj : first.toCharArray()) {
            if (vowList.contains(obj)) {
                firstcount++;
            }
        }

        for (char obj : second.toCharArray()) {
            if (vowList.contains(obj)) {
                secondCount++;
            }
        }
        if (firstcount == secondCount) {
            return true;
        }

        return false;
    }


    static int countStringRepeating(String input){
        String comapringString  = "mynameismohanmynameismohanmohanismoynameisyournameismohan";
        int count = 0;
         int index = comapringString.indexOf(input);
         while(index!=-1){
             count++;
             index = comapringString.indexOf(input,index+1);

         }
         return count;
    }



    public static void main(String[] args) {
        boolean value = alikeCalculate("book");

        System.out.println(value);
        int count = countStringRepeating("mohan");

        System.out.println(count);
    }
}
