import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Two Sum:
 *      return the indices of the two numbers such that they add up to a specific target
 */
public class leetcode1 {

    private class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                        return res;
                    }
                }
            }
            return res;
        }
    }

    /**
     * HashMap 空间换时间
     */
    private class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];

            if (nums == null || nums.length < 1)  return res;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])) {
                    res[0] = map.get(target-nums[i]);
                    res[1] = i;
                    return res;
                } else {
                    map.put(nums[i], i);
                }
            }
            return res;
        }
    }
}
