package com.mohan.search;

import java.util.ArrayList;
import java.util.List;

public class FindFirstString {

    public int strStr(String haystack, String needle) {

        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        FindFirstString find = new FindFirstString();
        //"sadbutsad", "sad"
        int index = find.strStr("hello", "ll");
        System.out.println(index);
    }
}
