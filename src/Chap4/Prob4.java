package Chap4;

/* Contains methods for the purpose of checking whether a Binary Tree is balanced.  In this case we
*  are defining a balanced tree as a tree such that the heights of the two subtrees of any node
*  never differ by more than one. */
public class Prob4 {

    /* This method leverages the definition of a balanced tree that we are given in the question.
    *  We start by calculating the height of the left and right pointers of the root.  We then check
    *  to see if the heights never differ by more than one.  This method takes O(H) space and O(N)
    *  time where H is defined as the height of the Binary Tree and N is the number of nodes.  It takes
    *  O(H) space due to the recursion stack in getHeight, with only a call to either left or right
    *  being active at one time. It takes O(N) time because we need to do a constant calculation on
    *  each node of the tree to check its height. */
    private static boolean isBalanced(BinaryTree<Integer> binaryTree) {
        BinaryNode<Integer> root = binaryTree.root;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight - rightHeight >= -1 && leftHeight - rightHeight <= 1) {
            return true;
        }
        return false;
    }

    // Returns height of Binary Tree.
    private static int getHeight(BinaryNode<Integer> root) {
            if (root == null) {
                return 0;
            }

            return getHeightHelper(root, 0);
    }

    private static int getHeightHelper(BinaryNode<Integer> root, int currentHeight) {
        if (root == null) {
            return currentHeight - 1;
        } else {
            int leftHeight = getHeightHelper(root.left, currentHeight + 1);
            int rightHeight = getHeightHelper(root.right, currentHeight + 1);
            return leftHeight > rightHeight ? leftHeight : rightHeight;
        }
    }

    public static BinaryTree<Integer> createUnbalancedTree() {
        BinaryTree binaryTree = new BinaryTree();
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> leaf = root;
        for (int i = 2; i <= 5; i++) {
            leaf.left = new BinaryNode<>(i);
            leaf = leaf.left;
        }
        binaryTree.root = root;
        return binaryTree;
    }

    public static void main(String[] args) {
        // A right-leaning Linked List-like tree with elements 1 through 5.
        BinaryTree<Integer> unbalanced = createUnbalancedTree();
        int[] sorted = new int[10];
        for (int i = 1; i <= 10; i++) {
            sorted[i - 1] = i;
        }
        // A balanced BST of minimal height.
        BinaryTree<Integer> balanced = Prob2.createMinimalBST(sorted);
        // Expected false.
        System.out.println(isBalanced(unbalanced));
        // Expected true.
        System.out.println(isBalanced(balanced));
    }
}
