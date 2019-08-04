package Chap4;

// Contains methods for the purpose of checking whether a Binary Tree is a BST.
public class Prob5 {

    public static int lastData;

    /* This method makes a single call to inOrderTraversalCheck.  It takes O(H) space due to the
    *  recursion stack and O(N) space since we have to do a constant operation at each Node in the
    *  tree. We leverage the lastData variable to make sure that we are seeing data in sorted order,
    *  a property that would only be true if we were traversing a BST. */
    public static boolean validateBST(BinaryTree<Integer> bst) {
        return inOrderTraversalCheck(bst.root);
    }

    private static boolean inOrderTraversalCheck(BinaryNode<Integer> root) {
        if (root != null) {
            inOrderTraversalCheck(root.left);
            if (lastData > root.data) {
                return false;
            }
            lastData = root.data;
            inOrderTraversalCheck(root.right);
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bst = Prob2.createMinimalBST(Prob2.createSortedArray(9));
        BinaryTree<Integer> falseBST = Prob2.createMinimalBST(Prob2.createSortedArray(7));
        falseBST.root.left.left.left = new BinaryNode<>(5);
        falseBST.root.left.right = new BinaryNode<>(-2);
        // Expected true.
        System.out.println(validateBST(bst));
        // Expected false.
        System.out.println(validateBST(falseBST));
    }
}
