import java.util.*;

/**
 * Created by tisong on 12/21/16.
 */
public class leet381 {




}

// 如何实现插入 删除都在 O(1)的时间复杂度呢
// 对于数组而言
class RandomizedCollection {
    private List<Integer> arrays;

    private Map<Integer, Set<Integer>> locs;

    private Random random = new Random();

    public RandomizedCollection() {
        arrays = new ArrayList<>();
        locs = new HashMap<>();
    }


    public boolean insert(int val) {
        boolean res = locs.containsKey(val);
        if (!res) {
            locs.put(val, new LinkedHashSet<>());
        }
        locs.get(val).add(arrays.size());
        arrays.add(val);
        return !res;
    }

    public boolean remove(int val) {
        boolean res = locs.containsKey(val);
        if (!res) return false;

        int pos = locs.get(val).iterator().next();

        if (pos < arrays.size() - 1) {
            // 如果不是最后一个元素
            int last = arrays.get(arrays.size()-1);
            arrays.set(pos, last);
            locs.get(last).remove(arrays.size()-1);
            locs.get(last).add(pos);
        }

        arrays.remove(arrays.size()-1);
        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    public int getRandom() {
        return arrays.get( random.nextInt(arrays.size()) );
    }
}
