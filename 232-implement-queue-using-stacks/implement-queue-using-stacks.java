class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int front = st.pop();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return front;
    }

    public int peek() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int front = st.peek();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return front;
    }

    public boolean empty() {
        return st.size() == 0;
    }
}