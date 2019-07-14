package Chap3;

import java.util.EmptyStackException;

// Similar to MyStack except there is a capacity that cannot be exceeded.
public class MyStackFinite<T> {
    private int size;
    private int capacity;

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public MyStackFinite(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }
    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size >= capacity;
    }
}
