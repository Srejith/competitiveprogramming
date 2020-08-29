/**
 * Difficulty level - Medium
 *
 * Inserting, Searching are pretty straight forward. Recursively call the right and left
 *
 * In case of deletion
 * Case 1: Two children node
 *          remove that node and replace with the minimum node from it's right tree
 * Case 2: Root node with one child
*           move up the node. replace the value with the child value and left and right with the child's left and right value
 * Case 3: Single child node on left
 *          replace the parent's left with child
 * Case 4: Single child node on right
 *          replace the parent's right with child
 */


public class BinarySearchTreeImpl {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            if(value<this.value){
                if(left == null){
                    BST newValue = new BST(value);
                    left = newValue;
                }else{
                    left.insert(value);
                }
            }else {
                if(right==null){
                    BST newValue = new BST(value);
                    right = newValue;
                }else{
                    right.insert(value);
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if(value<this.value) {
                if(left==null){
                    return false;
                }else{
                    return left.contains(value);
                }
            }else if(value>this.value){
                if(right==null){
                    return false;
                }else{
                    return right.contains(value);
                }
            }else{
                return true;
            }
        }

        public BST remove(int value){
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            // Write your code here.

            if(value< this.value ){
                if(left!=null){
                    left.remove(value, this);
                }
            } else if(value>this.value) {
                if(right!=null){
                    right.remove(value, this);
                }
            } else {

                //two nodes
                if(left!=null && right!=null){
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                }
                //single root node
                else if(parent == null){
                    if(left!=null)	{
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if(right!=null){
                        this.value = right.value;
                        right = right.right;
                        left = right.left;
                    }
                }
                //left single
                else if(parent.left == this){
                    if(left!=null){
                        parent.left = left;
                    }else{
                        parent.left = right;
                    }
                }
                //right single
                else if(parent.right == this) {
                    if(left!=null){
                        parent.right = left;
                    }else{
                        parent.right = right;
                    }
                }

            }
        }

        public int getMinValue() {
            if(left == null){
                return this.value;
            }else{
                return left.getMinValue();
            }
        }


    }
}
