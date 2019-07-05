package Chap3;

import java.util.NoSuchElementException;

public class Prob4 {
    MyStack<Integer> oldest;
    MyStack<Integer> newest;

    public Prob4() {
        oldest = new MyStack<>();
        newest = new MyStack<>();
    }

    public void add(int item) {
        newest.push(item);
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (oldest.isEmpty()) {
            fillOldest();
        }

        return oldest.pop();
    }

    private void fillOldest() {
        while (!newest.isEmpty()) {
            oldest.push(newest.pop());
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (oldest.isEmpty()) {
            fillOldest();
        }

        return oldest.peek();
    }

    public boolean isEmpty() {
        return oldest.isEmpty() && newest.isEmpty();
    }

    public static void fillQueue(Prob4 queue) {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
    }

    public static void removeAndPrintAll(Prob4 queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void multiPushPop(Prob4 queue) {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Prob4 queue = new Prob4();
        fillQueue(queue);
        // Expected 0 1 2 3 4 5 6 7 8 9
        removeAndPrintAll(queue);
        // Expected 0 1 2 3 4 5 6 7 8 9
        multiPushPop(queue);
    }

}
