package programtest.newcoder;

import java.util.Scanner;

public class DelLinkTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            //链表个数
            int num = sc.nextInt();

            //头结点值
            int headVal = sc.nextInt();

            //头结点
            ListNode head = new ListNode();
            head.val = headVal;

            for (int i = 0; i < num - 1; i++) {
                int newVal = sc.nextInt();
                int oldVal = sc.nextInt();
                addNode(newVal, oldVal, head);
            }

            int delVal = sc.nextInt();
            delNode(delVal, head);
            System.out.println(listNode(head));
        }
        sc.close();
    }

    private static String listNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }
        return sb.toString();
    }

    private static ListNode delNode(int delVal, ListNode head) {
        if (head.val == delVal) {
            ListNode ret = head.next;
            head.next = null;
            return ret;
        } else {
            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == delVal) {
                    prev.next = prev.next.next;
                    break;
                }
                prev = prev.next;
            }
            return head;
        }
    }

    private static void addNode(int newVal, int oldVal, ListNode head) {
        ListNode h = head;
        while (h != null) {
            if (h.val == oldVal) {
                ListNode node = new ListNode();
                node.val = newVal;
                node.next = h.next;
                h.next = node;
                break;
            }
            h = h.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
}
