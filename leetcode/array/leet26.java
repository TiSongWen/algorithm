/**
 * 1,1,2,2
 * 1,1,2,2,2,4
 * 当后面结点向前移动的时候：i不应该再紫邓
 * */
public class leet26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; ) {
            if (nums[i] == nums[i+1]) {
                // 向前移动
                int j = i + 1;
                while (j < length) {
                    nums[j-1] = nums[j];
                    j++;
                }
                length--;
                //向前移动的条件下　i 不用再自增了
            }else {
                i++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        new leet26().removeDuplicates(new int[]{1,1,2,2,2,4,4});
    }
}
