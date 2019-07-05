package Chap3;

public class Prob5 {

    public static void sortStack(MyStack<Integer> stack) {
        MyStack<Integer> r = new MyStack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }

        while (!r.isEmpty()) {
            stack.push(r.pop());
        }
    }

    public static void popAndPrintAll(MyStack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(9);
        stack.push(1);
        stack.push(10);
        stack.push(4);
        stack.push(12);
        stack.push(3);
        stack.push(6);
        sortStack(stack);
        // Expected 1 3 4 5 6 9 10 12
        popAndPrintAll(stack);
    }
}
