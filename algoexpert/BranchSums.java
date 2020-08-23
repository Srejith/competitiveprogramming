import java.util.ArrayList;
import java.util.List;

/**
 *  Take a Binary Tree as input and returns a list of branch sums ordered from leftmost branch sum to the rrightmost branch sum
 */
public class BranchSums {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();
        branchSums(root, 0, result);
        return result;
    }

    public static void branchSums(BinaryTree root, int cumulativeSum, List<Integer> result) {
        int value = root.value;
        cumulativeSum  = cumulativeSum + value;

        if(root.left!=null){
            branchSums(root.left, cumulativeSum, result);
        }
        if (root.right!=null){
            branchSums(root.right, cumulativeSum, result);
        }

        if(root.left==null && root.right ==null){
            //no child
            result.add(cumulativeSum);
        }
    }
}

