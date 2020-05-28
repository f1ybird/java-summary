package programtest.leetcode;

import java.util.Stack;

public class QueueByStack {

    public static void main(String[] args) {
        QueueByStack queue = new QueueByStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.list();
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.list();
    }

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public QueueByStack() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int val) {
        pushStack.push(val);
    }

    public int pop() {
        shift();
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        throw new RuntimeException("队列里没有元素");
    }

    public int peek() {
        shift();
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        throw new RuntimeException("队列里没有元素");

    }

    public void shift() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public void list() {
        shift();
        while (!popStack.isEmpty()) {
            System.out.println(popStack.pop());
        }
    }

    public int size() {
        shift();
        return popStack.size();
    }
}
