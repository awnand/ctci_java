package Chap4;

public class BinaryTree {
    BinaryNode root;

    public static void inOrderTraversal(BinaryNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.name + " ");
            inOrderTraversal(node.right);
        }
        System.out.println();
    }

    public static void preOrderTraversal(BinaryNode node) {
        if (node != null) {
            System.out.print(node.name + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
        System.out.println();
    }
    public static void postOrderTraversal(BinaryNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.name + " ");
        }
        System.out.println();
    }
}
