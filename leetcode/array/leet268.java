/**
 * Created by tisong on 12/22/16.
 */
public class leet268 {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        int sumOfNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfNums += nums[i];
        }
        return sum - sumOfNums;
    }

    class Solution {
        // 错误的思路, 忘记考虑数组并不是有序的
        public int missingNumber(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i+1] - nums[i] != 1) {
                    return nums[i] + 1;
                }
            }
            if (nums[0] != 0) {
                return 0;
            } else {
                return nums[nums.length-1] + 1;
            }
        }
    }
}
