/**
 * Created by tisong on 12/9/16.
 */
public class leet160 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }

        int lengthA = size(headA);
        int lengthB = size(headB);


        for (;lengthA > lengthB; lengthA--) {
            headA = headA.next;
        }

        for(;lengthA < lengthB; lengthB--) {
            headB = headB.next;
        }

        while(headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int size(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next, size++) ;
        return size;
    }
}
