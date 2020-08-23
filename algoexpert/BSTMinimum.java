/**
 * Difficulty - Easy
 * Function that takes a BST and a target integer value and returns the closest value to that target value contained in the BST
 */

public class BSTMinimum {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        if(Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }

        if(target<tree.value && tree.left!=null){

            return findClosestValueInBst(tree.left, target, closest);

        }else if (target> tree.value && tree.right!=null) {

            return findClosestValueInBst(tree.right, target, closest);

        } else{
            return closest;
        }
    }

    static class BST {
        public static int value;
        public static BST left;
        public static BST right;

        public BST(int value)   {
            BST.value = value;
        }
    }
}
