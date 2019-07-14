package Chap3;

import java.util.EmptyStackException;

/* This class implements a Three Stacks using a single array.  We give each Stack a third of the array
*  and whenever one Stack runs out of space, we make the array bigger. */
public class Prob1 {
    private int[] arr;
    private int[] indices = new int[3];

    public Prob1() {
        arr = new int[9];
        indices[0] = 0;
        indices[1] = (9)/3;
        indices[2] = (2*9)/3;
    }

    public int pop(int stackNum) {
        checkStackNum(stackNum);
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        } else {
            indices[stackNum]--;
            return arr[indices[stackNum]];
        }

    }

    public void push(int item, int stackNum) {
        checkStackNum(stackNum);
        arr[indices[stackNum]] = item;
        indices[stackNum]++;
        if (indices[stackNum] == ((stackNum+1)*arr.length)/3) {
            expandArray();
        }
    }

    public int peek(int stackNum) {
        checkStackNum(stackNum);
        return arr[indices[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        checkStackNum(stackNum);
        return indices[stackNum] == (stackNum*arr.length)/3;

    }

    public void checkStackNum(int stackNum) {
        if (stackNum > 2 || stackNum < 0) {
            throw new EmptyStackException();
        }
    }

    public void expandArray() {
        int newCapacity = arr.length*3;
        int[] newArr = new int[newCapacity];
        int currStack = 0;
        while (currStack < 3) {
            int j = currStack*newArr.length/3;
            for (int i = (currStack*arr.length)/3; i < indices[currStack]; i++) {
                newArr[j] = arr[i];
                j++;
            }
            indices[currStack] = j;
            currStack++;
        }
        arr = newArr;
    }

    public static void fillThreeStack(Prob1 stack) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                stack.push(j, i);
            }
        }
    }

    public static void popAndPrintAll(Prob1 stack) {
        for (int i = 0; i < 3; i++) {
            System.out.print("Stack " + (i + 1) + ": ");
            while (!stack.isEmpty(i)) {
                System.out.print(stack.pop(i) + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
    public static void main(String[] args) {
        Prob1 threeStack = new Prob1();
        fillThreeStack(threeStack);
        // Expected 8 7 6 5 4 3 2 1 0 for all stacks
        popAndPrintAll(threeStack);
        fillThreeStack(threeStack);
        threeStack.push(9, 0);
        threeStack.push(9, 1);
        threeStack.push(9, 2);
        // Expected 9 8 7 6 5 4 3 2 1 0 for all stacks
        popAndPrintAll(threeStack);
    }
}
