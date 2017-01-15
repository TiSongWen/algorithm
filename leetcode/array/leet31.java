import java.util.Arrays;

/**
 * Created by tisong on 12/23/16.
 */
public class leet31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return ;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i-1] > 0) {
                // 替换 nums[i-1] 与 nums[nums.length-1],并且反转 nums[i] ~ nums[nums.length-1]
                int temp = nums[i-1];
                nums[i-1] = nums[nums.length-1];
                nums[nums.length-1] = temp;
                reserve(nums, i, nums.length);
                return ;
            }
        }

        Arrays.sort(nums);
    }

    private void reserve(int[] nums, int sta, int end) {
        for (int i = sta; i < sta + (end - sta) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end-(i-sta)-1];
            nums[end-(i-sta)-1] = temp;
        }
    }


    public static void main(String[] args) {
        new leet31().nextPermutation(new int[]{2,3,1});
    }
}
