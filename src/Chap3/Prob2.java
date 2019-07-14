package Chap3;


import java.util.EmptyStackException;

// This class represents a Stack that also keeps track of the minimum element.
public class Prob2 {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }


    private StackNode<Integer> top;
    // Used to keep track of minimum elements that are passed through the Stack,
    private StackNode<Integer> min;

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int item = top.data;
        if (top.data == min.data) {
            min = min.next;
        }
        top = top.next;
        return item;
    }

    public void push(int item) {
        StackNode<Integer> t = new StackNode<>(item);
        t.next = top;
        top = t;
        if (min == null || top.data <= min.data) {
            StackNode<Integer> m = new StackNode<>(item);
            m.next = min;
            min = m;
        }
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int min() {
        if (min == null) throw new EmptyStackException();
        return min.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Prob2 minStack = new Prob2();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        // Expected 1
        System.out.println(minStack.min());
        minStack.push(-1);
        minStack.push(1);
        // Expected 1
        System.out.println(minStack.pop());
        // Expected -1
        System.out.println(minStack.min());
        // Expected -1
        System.out.println(minStack.pop());
        // Expected 1
        System.out.println(minStack.min());
        // Expected 5
        System.out.println(minStack.pop());
    }
}
