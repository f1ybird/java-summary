package programtest.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.add(node5);

        singleLinkedList.list();

        singleLinkedList.removeNthFromEnd(singleLinkedList.getHead(), 6);

        singleLinkedList.list();
    }
}

class SingleLinkedList {

    private int size = 0;

    public int getSize() {
        return size;
    }

    private ListNode head = new ListNode(0);

    public ListNode getHead() {
        return head;
    }

    public void removeNthFromEnd(ListNode head, int n) {
        int delIndex = size - n + 1;
        int count = 0;

        if (delIndex > size || delIndex <= 0) {
            System.out.println("删除的下标不合法");
            return;
        }

        ListNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空，不能删除");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            if (count == delIndex) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    public void add(ListNode node) {
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = node;
        size++;

    }

    public void list() {
        ListNode temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.next == null) {
                System.out.print(temp.next.val);
            } else {
                System.out.print(temp.next.val + "->");
            }

            temp = temp.next;
        }
        System.out.println();

    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}