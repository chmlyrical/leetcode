package com.leetcode.daily;


//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
//
//
// 示例 4：
//
//
//输入：nums = [9,11], k = 2
//输出：[11]
//
//
// 示例 5：
//
//
//输入：nums = [4,-2], k = 2
//输出：[4]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 770 👎 0
public class Solution_20210102_239 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        //int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);

        for (int num : res) System.out.println(num);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        if (k == 1) {
            return nums;
        }

        int tmp = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    tmp = nums[j] > tmp ? nums[j] : tmp;
                    index = nums[j] > tmp ? j : index;
                }
                result[i] = tmp;
            } else {
                //if (i > k && (i - k) % (k - 1) == 0) {
                if (i - index >= (k - 1)) {
                    tmp = Integer.MIN_VALUE;
                }
                result[i] = nums[i - 1 + k] >= tmp ? nums[i - 1 + k] : tmp;
                index = nums[i - 1 + k] >= tmp ? i - 1 + k : index;
                tmp = result[i];
            }

        }

        return result;
    }
}
