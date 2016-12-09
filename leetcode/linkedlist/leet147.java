/**
 * Created by tisong on 12/9/16.
 */
public class leet147 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    /**
     * 链表实现的插入排序(思想：减治, 减少问题的规模)
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {return head;}

        for (ListNode curr = head.next; curr != null; curr = curr.next) {
            for (ListNode star = head; star != curr; star = star.next) {
                if (curr.val < star.val) {
                    int temp = curr.val;
                    curr.val = star.val;
                    star.val = temp;
                }
            }
        }
        return head;
    }

    
}
