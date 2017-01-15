import java.util.ArrayList;

/**
 * Created by tisong on 12/9/16.
 */
public class leet143 {
    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return ;

        ArrayList<Integer> list = new ArrayList();

        for (ListNode n = head; n != null; n = n.next) {
            list.add(n.val);
        }

        ListNode n = head;
        for (int i = 0; i <= list.size() / 2 && n != null; i++) {
                n.val = list.get(i);
            if (n.next != null) {
                n.next.val = list.get(list.size() - 1 - i);
                n = n.next.next;
            }
        }
    }

    /**
     * 分成两条链表 L1
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {return ;}

        ListNode fir = head;
        ListNode sec = head.next;

        boolean flag = true;
        for (ListNode n = head.next, f = fir, s = sec; n != null; n = n.next) {
            if (flag) {
                fir.next = n;
                fir = fir.next;
            } else {
                sec.next = n;
                sec = sec.next;
            }
            flag = !flag;
        }
    }


    public void reorderList3(ListNode head) {
        if (head == null || head.next == null) {return ;}

        // 找中点
        ListNode slow = null, fast = null;
        slow = head;
        fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 从中点为轴，切开链表
        ListNode fir = head;
        ListNode sec = slow.next;
        slow.next = null;   // 切分



        // 转置第二个链表
        slow = null;
        fast = sec;
        ListNode next = null;
        while(fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        sec = slow;
        printLink(fir);
        printLink(sec);

//        思路一：用next这根线将两个链表穿插起来
//        head = new ListNode(-1);
//        next = head;
//        head = fir;
//        while (sec != null && fir != null) {
//            next.next = fir;
//            fir = fir.next;
//            next = next.next;
//
//            next.next = sec;
//            sec = sec.next;
//            next = next.next;
//
//        }
//
//        if (sec != null) {
//            next.next = sec;
//            next.next.next = null;
//        }
//        head = head.next;


//        思路二，两个链表进行自己穿插 即 fir引用到 sec, sec再引用到fir，缺点就是会漏掉fir 与 sec长度不一致的情况
//            slow = fir.next;
//            fir.next = sec;
//            fir = slow;
//
//            fast = sec.next;
//            sec.next = fir;
//            sec = fast;

//        思路三 最间
        for (slow = fir, fast = sec; fir != null; ) {
            next = slow.next;
            slow = slow.next = fast;  // 前一个结点slow 连接后一个结点 fast,同时前一个结点移动到后一个结点
            fast = next;
        }
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);

        ListNode n = listNode;
        for (int i = 1; i < 7; i++) {
            n.next = new ListNode(i);
            n = n.next;
        }


        new leet143().reorderList3(listNode);

        for (n = listNode; n != null; n = n.next) {
            System.out.print(n.val + "\t");
        }
    }


    private void printLink(ListNode listNode) {
        for (ListNode n = listNode; n != null; n = n.next) {
            System.out.print(n.val + "\t");
        }
        System.out.println("");
    }
}
