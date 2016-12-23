import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Size Subarray Sum
 * 对于子序列中，如何找到和为7的子序列 （sum >= s, not equals to s）
 * 1. 利用树
 * 2. 基于链表实现的树
 * 3. 基于数组实现的树(Solution1)
 * 4. 不依赖任何数据结构
 * 问题1： 如何构造树(二叉非平衡稳定树) - 选取结点 & 不选取结点
 * 1. 对于二叉平衡树而言，树本身就是非稳定的,所以不可以用二叉树的思想进行插入（构造）
 *    所以如果是采用链表的思想进行树的构建，则会很麻烦，所以这里采用数组进行树的实现
 * 2. 数组的每次子节点构建都是依赖于上层父结点，所以需要两个变量存取上层父结点的start与end
 */
public class leet209 {

    // 思路1
    class Solution1 {
        private class Node {
            int val;
            int len; // 长度
            public Node(int val, int len) {
                this.val = val;
                this.len = len;
            }
        }

        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length < 1) return 0;

            List<Node> list = new ArrayList<>();
            list.add(new Node(0, 0));

            int sta = 0;
            int end = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = sta; j < end; j++) {
                    Node pre = list.get(j);
                    list.add(new Node(pre.val, pre.len));
                    list.add(new Node(nums[i]+pre.val, pre.len+1));
                }
                sta = end;
                end = end * 2 + 1;
            }

            int min = Integer.MAX_VALUE;
            for (int i = sta; i < end; i++) {
                if (list.get(i).val == s && list.get(i).len < min) {
                    min = list.get(i).len;
                }
            }
            return min;
        }
    }

    // 思路2
    class Solution2 {
        public int minSubArrayLen(int s, int[] a) {
            if (a == null || a.length == 0)
                return 0;

            int sum = 0;
            int j = 0;  //
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < a.length; i++) {
                sum += a[i];
                while (sum >= s) {
                    min = Math.min(min, i - j + 1);
                    sum -= a[j++];
                }
            }

            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }



    public static void main(String[] args) {

        //System.out.println(minSubArrayLen(7, new int[]{4,3,1}));
    }
}
