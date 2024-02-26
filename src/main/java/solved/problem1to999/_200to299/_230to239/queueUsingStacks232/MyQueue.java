package solved.problem1to999._200to299._230to239.queueUsingStacks232;

import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        s1.add(x);
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
