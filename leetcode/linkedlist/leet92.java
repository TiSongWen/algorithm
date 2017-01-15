/**
 * Created by tisong on 12/9/16.
 */
public class leet92 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mNode = getNode(m-1, head);
        ListNode nNode = getNode(n-1, head);
        ListNode prevM = getNode(m-2, head);
        ListNode prev = null, next, curr = mNode;
        while (prev != nNode) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        mNode.next = curr;

        if (prevM != null)
            prevM.next = nNode;
        else {
            return  nNode;
        }

        return head;
    }

    private ListNode getNode(int index, ListNode head) {
        if (index < 0) return null;
        ListNode n = null;
        for (n = head; index > 0 && n != null; index--, n = n.next) ;
        return n;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);

        ListNode n = listNode;
        for (int i = 1; i < 7; i++) {
            n.next = new ListNode(i);
            n = n.next;
        }

        listNode = new leet92().reverseBetween(listNode, 1, 1);

        for (ListNode n1 = listNode; n1 != null; n1 = n1.next) {
            System.out.print(n1.val + "\t");
        }
        System.out.println("");
    }

    private void printLink(leet143.ListNode listNode) {
        for (leet143.ListNode n = listNode; n != null; n = n.next) {
            System.out.print(n.val + "\t");
        }
        System.out.println("");
    }
}
