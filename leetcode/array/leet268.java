/**
 * Created by tisong on 12/22/16.
 */
public class leet268 {

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