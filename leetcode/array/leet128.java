import java.util.HashSet;
import java.util.Set;

/**
 * Long Consecutive
 */
public class leet128 {

    private static class Solution1 {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length < 1) return 0;

            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (!set.contains(n-1)) {
                    int m = n + 1;
                    while (set.contains(m)) {
                        m++;
                    }
                    res = Math.max(res, m - n);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestConsecutive(new int[]{1,5,2,4,3}));
    }
}
