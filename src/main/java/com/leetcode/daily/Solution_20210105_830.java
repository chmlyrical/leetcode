package com.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhao on 2021/1/5.
 */
public class Solution_20210105_830 {
    public static void main(String[] args) {
        String s = "abbxxxxzyy";
        System.out.println(largeGroupPositions(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        s = s + "A";
        List<List<Integer>> result = new ArrayList<>();
        int begin = 0;
        for (int i = 1; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (i - begin >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i - 1);
                    result.add(temp);
                }
                begin = i;
            }
        }
        return result;
    }
}
