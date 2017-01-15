/**
 * Created by tisong on 12/9/16.
 */
public class leet109 {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        return bst(head);
    }

    private TreeNode bst(ListNode head) {
        if (head == null)   return null;
        if (head.next == null) {
            TreeNode t = new TreeNode(head.val);
            t.left = t.right = null;
            return t;
        }

        ListNode mid = getMiddle(head);
        ListNode right = mid.next.next;
        ListNode left = head;
        ListNode midNext = mid.next;
       // System.out.println("mid: " + mid.val + "\tleft: " + left.val + "\tright: " + right.val);
        mid.next = null;

        TreeNode treeNode = new TreeNode(midNext.val);
        treeNode.right = bst(right);
        treeNode.left = bst(left);

        mid.next = midNext;

        return treeNode;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null)  return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        for (;fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) ;

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);

        ListNode n = listNode;
        for (int i = 1; i < 7; i++) {
            n.next = new ListNode(i);
            n = n.next;
        }

        new leet109().sortedListToBST(listNode);
    }
}
