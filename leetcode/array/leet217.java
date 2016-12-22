import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 */
public class leet217 {

    // 思路1： O(n^2) time; O(1) space
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] - nums[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // 思路2：空间换时间 HashSet
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                } else {
                    set.add(nums[i]);
                }
            }
            return false;
        }
    }
}
