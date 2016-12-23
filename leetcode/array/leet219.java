import java.util.HashMap;
import java.util.Map;

/**
 * Created by tisong on 12/22/16.
 */
public class leet219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // num - indice
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                // 存在
                int oldIndice = map.get(nums[i]);
                if (i - oldIndice > k) {
                    map.replace(nums[i], i);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
