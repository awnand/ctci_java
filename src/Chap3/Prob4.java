package Chap3;

import java.util.NoSuchElementException;

/* This class implements a MyQueue class which implements a queue using two Stacks. To do this,
*  whenever we add an item, we push to the newest stack.  Whenever we remove, we pop everything
*  from newest and push it to oldest so the items are reversed and therefore in correct order for
*  popping from oldest.  We then return a popped item from oldest.  If when we run the remove
*  method, oldest is not empty, we can simply pop from oldest and return. */
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
