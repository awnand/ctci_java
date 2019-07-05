package Chap3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Prob3 {
    private ArrayList<MyStackFinite<Integer>> stacks = new ArrayList<>();
    private int lastStack;
    private int numStacks = 0;

    public Prob3() {
        stacks.add(new MyStackFinite<>(3));
        numStacks++;
        lastStack = 0;
    }

    public void push(int item) {
        if (stacks.get(lastStack).isFull()) {
            if (lastStack == numStacks - 1) {
                stacks.add(new MyStackFinite<>(3));
                numStacks++;
            }
            lastStack++;
        }
        stacks.get(lastStack).push(item);
    }

    public int pop() {
        if (stacks.get(lastStack).isEmpty()) {
            throw new EmptyStackException();
        }
        MyStackFinite<Integer> topStack = stacks.get(lastStack);
        int item = topStack.pop();
        if (topStack.isEmpty() && lastStack != 0) {
            lastStack--;
        }
        return item;
    }

    public int peek() {
        if (stacks.get(lastStack).isEmpty()) {
            throw new EmptyStackException();
        }
        return stacks.get(lastStack).peek();
    }

    public boolean isEmpty() {
        return lastStack == 0 && stacks.get(lastStack).isEmpty();
    }

    public static void fillStacks(Prob3 setOfStacks) {
        for (int i = 0; i < 9; i++) {
            setOfStacks.push(i);
        }
    }

    public static void popAndPrintAll(Prob3 setOfStacks) {
        while (!setOfStacks.isEmpty()) {
            System.out.print(setOfStacks.pop() + " ");
        }
        System.out.println();
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Prob3 setOfStacks = new Prob3();
        fillStacks(setOfStacks);
        // Expected 8 7 6 5 4 3 2 1 0
        popAndPrintAll(setOfStacks);
    }
}
