import java.util.Stack;

/**
 * Created by tisong on 12/7/16.
 */
public class leet445 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = 0;
        int length2 = 0;

        for (ListNode node = l1; node != null; node = node.next)  { length1++; }
        for (ListNode node = l2; node != null; node = node.next)  { length2++; }

        ListNode max = l1, min = l2;
        int maxN = length1, minN = length2;
        if (length2 > length1) {
            max = l2;
            min = l1;
            maxN = length2;
            minN = length1;
        }

        ListNode res = new ListNode(0); // head node

        res.next = add(max, min, maxN, minN);
       if (res.next != null && res.next.val >= 10) {
           res.val += res.next.val / 10;
           res.next.val = res.next.val % 10;
       }
        return res.val == 0 ? res.next : res;

    }

    private ListNode add(ListNode node1, ListNode node2, int maxN, int minN) {

        if (node1 == null && node2 == null) { return null; }

        ListNode node = null;
        if (maxN > minN) {
            node = new ListNode(node1.val);
            node.next = add(node1.next, node2, maxN-1, minN);
        }
        else if (maxN == minN){
            node = new ListNode(node1.val + node2.val);
            node.next = add(node1.next, node2.next, maxN--, minN--);
        }

        if (node.next != null) {
            int n = node.next.val / 10;
            node.val += n;
            node.next.val = node.next.val % 10;
        }

        return node;
    }

    public ListNode addTowByStack(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        for (ListNode i = l1; i != null; i = i.next) n1++;
        for (ListNode i = l2; i != null; i = i.next) n2++;

        Stack<Integer> st = new Stack();
        int totn = Math.max(n1, n2);
        for (ListNode i = l1, j = l2; totn > 0; totn--) {
            int a = 0, b = 0;
            if (totn <= n1) {
                a = i.val;
                i = i.next;
            }
            if (totn <= n2) {
                b = j.val;
                j = j.next;
            }
            st.push(a + b);
        }

        int c = 0;
        ListNode ans = null;
        while (!st.empty()) {
            ListNode i = new ListNode(st.pop());
            int c1 = (c + i.val) / 10;
            i.val = (c + i.val) % 10;
            i.next = ans;
            ans = i;
            c = c1;
        }

        if (c > 0) {
            ListNode i = new ListNode(c);
            i.next = ans;
            ans = i;
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
