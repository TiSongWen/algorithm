import java.util.Arrays;

/**
 * Rotate Array, Try to come up as many solutions as you can, there are at least 3 different ways to solve the problem
 */
public class leet189 {
    /**
     * 利用数组的复制
     */
    private class Solution1 {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length < 1) return ;
            k %= nums.length;
            int[] temp = new int[nums.length];
            System.arraycopy(nums, nums.length - k, temp, 0, k);
            System.arraycopy(nums, 0, temp, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, temp.length);
        }
    }

    /**
     * 基于反转
     */
    private class Solution2 {

    }
}
