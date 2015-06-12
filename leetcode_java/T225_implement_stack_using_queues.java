class MyStack {

    private Queue queue;

    public void push(int x) {
        Queue q = new LinkedList();     // could be any queue type, see note above
        q.add(x);
        q.add(queue);
        queue = q;
    }

    public void pop() {
        queue.remove();
        queue = (Queue) queue.peek();
    }

    public int top() {
        return (int) queue.peek();
    }

    public boolean empty() {
        return queue == null;
    }
}
