import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tisong on 12/7/16.
 */
public class leet148 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 链表的归并排序实现
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode list) {
        if (list == null || list.next == null) { return list; }

        ListNode mid = getMiddle(list);

        ListNode midNext = mid.next;

        mid.next = null;

        ListNode left  = mergeSort(list);
        ListNode right = mergeSort(midNext);

        return merge(left, right);
    }

    private ListNode getMiddle(ListNode list) {
        ListNode slow = null;
        ListNode fast = null;

        for (slow = list, fast = null; fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) ;

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = left;
        ListNode preL = null;
        ListNode currL = left, currR = right;
        ListNode nextR = right;

        while(currR != null && currL != null) {
            if (currR.val < currL.val) {
                nextR = currR.next;
                currR.next = currL;
                if (preL != null) {
                    preL.next = currR;
                }else {
                    head = currR;
                }
                preL  = currR;
                currR = nextR;
            } else {
                preL  = currL;
                currL = currL.next;
            }
        }

        if (currL == null)
            preL.next = currR;

        return head;
    }

    public static void main(String[] args) throws IOException {
        ListNode head = new ListNode(-1);
        ListNode curr = head;


        curr.next = new ListNode(1);
        curr.next.next = new ListNode(3);
        curr.next.next.next = new ListNode(2);

        curr.next.next.next.next = null;

        new leet148().sortList(head.next);

    }
}
