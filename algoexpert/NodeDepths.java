/**
 * Difficulty - Easy
 * Write a function that takes in a binary tree and returns the sum of it's node's depths
 */
public class NodeDepths {
    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0, 0);
    }

    public static int nodeDepths(BinaryTree root, int sum, int depth) {

        if (root != null) {
            sum = sum + depth++;
            sum = nodeDepths(root.left, sum, depth);
            sum = nodeDepths(root.right, sum, depth);
        }
        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}

