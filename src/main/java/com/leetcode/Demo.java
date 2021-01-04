package com.leetcode;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.logging.Level;

/**
 * Created by chenhao on 2020/6/22.
 */
public class Demo {


    public static void main(String[] args) {

        //int[] nums = new int[]{7, 2, 4};
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);

        for (int num : res) System.out.println(num);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        if (k == 1) {
            return nums;
        }
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    tmp = nums[j] > tmp ? nums[j] : tmp;

                }
                result[i] = tmp;
            } else {
                //if (i > k && (i - k) % (k - 1) == 0) {
                if (i > k - 2 && (i - k) % (k - 1) == 0) {
                    tmp = Integer.MIN_VALUE;
                }
                result[i] = nums[i - 1 + k] >= tmp ? nums[i - 1 + k] : tmp;

                tmp = result[i];
            }

        }

        return result;
    }


}
