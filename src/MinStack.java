/*
    Link: https://leetcode.com/problems/min-stack
 */
public class MinStack {
    class Node {
        int value;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.value = val;
            this.min = min;
            this.next = next;
        }
    }

    Node node;

    public void push(int val) {
        if (node == null) {
            this.node = new Node(val, val, null);
        } else {
            this.node = new Node(val, Math.min(val, this.node.min), this.node);
        }
    }

    public void pop() {
        this.node = this.node.next;
    }

    public int top() {
        return this.node.value;
    }

    public int getMin() {
        return this.node.min;
    }
}
