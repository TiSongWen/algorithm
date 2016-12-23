/**
 * Two Sum II - a sorted array(O(n) time, O(1) space)
 */
public class leet167 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{};

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp == target) {
                return new int[]{left, right};
            } else if (temp < target){
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
