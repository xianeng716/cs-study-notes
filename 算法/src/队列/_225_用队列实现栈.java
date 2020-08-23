package 队列;

import java.util.LinkedList;
import java.util.Queue;

public class _225_用队列实现栈 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public _225_用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        } else {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.poll();
        } else {
            return queue1.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
