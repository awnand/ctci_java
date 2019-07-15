package Chap4;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;

public class BinaryTree<T> {
    BinaryNode<T> root;

    public static void inOrderTraversal(BinaryNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(BinaryNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
        System.out.println();
    }
    public static void postOrderTraversal(BinaryNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public BinaryTree() {
        root = null;
    }

}
