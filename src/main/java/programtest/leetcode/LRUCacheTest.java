package programtest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCacheTest cache = new LRUCacheTest(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {

        }

        public DLinkNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCacheTest(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            return -1;
        }

        //移动到头部
        moveToHead(dLinkNode);
        return dLinkNode.value;
    }

    public void put(int key, int value) {
        DLinkNode dLinkNode = cache.get(key);
        if (dLinkNode == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            //添加到头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //移除尾部
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            dLinkNode.value = value;
            //移动到头部
            moveToHead(dLinkNode);
        }
    }

    public void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
