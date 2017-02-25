import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 经典问题: 3Sum
 */
public class leet15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;

        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && nums[j] != nums[i]; j++) {
                int z = BinarySearch.search(-nums[i]-nums[j], nums);
                if (z > j) {
                    List<Integer> temp = new LinkedList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[z]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    static class BinarySearch {
        public static int search(int target, int[] nums) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (target < nums[mid]) hi = mid - 1;
                else if (target > nums[mid]) lo = mid + 1;
                else return mid;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        new leet15().threeSum(new int[] {-1,0,1,-1,2});
    }
}
