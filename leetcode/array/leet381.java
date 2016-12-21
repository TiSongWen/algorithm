import java.util.*;

/**
 * Created by tisong on 12/21/16.
 */
public class leet381 {




}

/**
 * 如何实现插入 删除都在 O(1)的时间复杂度呢
 * 对于数组而言，如何实现在O(1)时间复杂度的删除
 * Map   : val - pos1, pos2, pos3...
 * Array : pos1 - val, pos2 - val
 * 插入:
 *    1. 向数组末尾插入
 *    2. 向Map中 val对应的有序Set集合中存放val在数组中的位置
 * 删除:
 *    1. 从Map中获取val对应有序Set集合中第1个pos
 *    2. 数组中该pos要删除, 将pos位置上的元素替换为数组最末尾的元素
 *    3. 删除Map中val对应有序Set集合中pos
 */

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
        locs.get(val).remove(pos);
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
