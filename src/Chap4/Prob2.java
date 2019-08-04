package Chap4;

/* Contains methods for the purpose of creating a binary search tree with minimal height from a
*  sorted array. */
public class Prob2 {

    /* This method runs in O(logN) space for stack recursion and O(N) time in order to create a node
    *  for each individual element.  A minimal height BST is simply the bushiest possible BST.  In
    *  order to get an even tree, we can leverage properties of the sorted array.  The median of the
    *  array will be in the middle, and therefore if we choose the median as our root, we know that
    *  potentially, there are roughly the same amount of items that would be on either side.  To ensure
    *  that the tree is actually well-balanced, we only need to recurse, repeatedly grabbing the median
    *  of the subarray and making it the root of the subtree until we run out of items. */
    public static BinaryTree createMinimalBST(int[] sorted) {
        BinaryTree<Integer> bst = new BinaryTree<>();
        BinaryNode<Integer> root = createMinimalBSTHelper(sorted, 0, sorted.length - 1);
        bst.root = root;
        return bst;
    }

    private static BinaryNode<Integer> createMinimalBSTHelper(int[] sorted, int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            return null;
        }
        int middleIndex = (rightBound + leftBound) / 2;
        BinaryNode<Integer> node = new BinaryNode<>();
        node.data = sorted[middleIndex];
        node.left = createMinimalBSTHelper(sorted, leftBound, middleIndex - 1);
        node.right = createMinimalBSTHelper(sorted, middleIndex + 1, rightBound);
        return node;
    }


    public static int[] createSortedArray(int numElements) {
        int[] sorted = new int[numElements];
        for (int i = 1; i <= numElements; i++) {
            sorted[i - 1] = i;
        }
        return sorted;
    }

    private static void createBSTAndPrint(int[] sorted) {
        System.out.println("Elements of sorted array:");
        for (int i = 0; i < sorted.length; i++) {
            if (i == sorted.length - 1) {
                System.out.println(sorted[i]);
            } else {
                System.out.print(sorted[i] + " ");
            }
        }
        BinaryTree<Integer> bst = createMinimalBST(sorted);
        System.out.println("In-order traversal of newly created binary search tree: ");
        BinaryTree.inOrderTraversal(bst.root);
        System.out.println();
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        int[] odd = createSortedArray(9);

        int[] even = createSortedArray(10);

        // Expected 1 2 3 4 5 6 7 8 9
        createBSTAndPrint(odd);
        // Expected 1 2 3 4 5 6 7 8 9 10
        createBSTAndPrint(even);
    }
}
