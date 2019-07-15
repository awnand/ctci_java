package Chap4;

import java.util.ArrayList;
import java.util.LinkedList;

/* Contains methods for the purpose of creating a Linked List of all the Nodes within a BST at each
*  depth (e.g. if you have a tree with depth D, you'll have D Linked Lists. */
public class Prob3 {

    /* This method runs with O(N) space due the amount of nodes that we need to store, and O(N)
    *  time since we need to traverse through each node. We simply populate the level list by
    *  adding a node to it given a certain level, and then calling the populateLevelList function
    *  on its children while incrementing the level argument. */
    public static ArrayList<LinkedList<BinaryNode<Integer>>> createLevelList(BinaryNode<Integer> root) {
        ArrayList<LinkedList<BinaryNode<Integer>>> lists = new ArrayList<>();
        populateLevelList(root, lists, 0);
        return lists;
    }

    private static void populateLevelList(BinaryNode<Integer> root, ArrayList<LinkedList<BinaryNode<Integer>>> lists, int level) {
        if (root == null) {
            return;
        }
        // Checks to make sure that the level's index in the ArrayList exists.
        if (lists.size() == level) {
            LinkedList<BinaryNode<Integer>> depthList = new LinkedList<>();
            lists.add(level, depthList);
        }
        lists.get(level).add(root);
        // Recursively call to the next level.
        populateLevelList(root.left, lists, level+1);
        populateLevelList(root.right, lists, level+1);
    }

    public static void createLevelListAndPrint(int[] sorted) {
        BinaryTree<Integer> bst = Prob2.createMinimalBST(sorted);
        ArrayList<LinkedList<BinaryNode<Integer>>> list = createLevelList(bst.root);
        System.out.println("Elements of sorted array:");
        for (int i = 0; i < sorted.length; i++) {
            if (i == sorted.length - 1) {
                System.out.println(sorted[i]);
            } else {
                System.out.print(sorted[i] + " ");
            }
        }
        System.out.println("Level order traversal of BST: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Level " + i + ": ");
            for (BinaryNode<Integer> node: list.get(i)) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        // We create our BSTs using the method from the previous problem for convenience.
        int[] even = new int[10];
        for (int i = 1; i <= even.length; i++) {
            even[i - 1] = i;
        }

        int[] odd = new int[15];
        for (int i = 1; i <= odd.length; i++) {
            odd[i - 1] = i;
        }

        createLevelListAndPrint(even);
        createLevelListAndPrint(odd);

    }
}
