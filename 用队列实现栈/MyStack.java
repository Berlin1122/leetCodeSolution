class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;


    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        Integer result = queue1.remove();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        Integer result = queue1.remove();
        queue2.add(result);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}