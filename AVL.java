public class AVL extends BinarySearchTree {

    public AVL() {

        super();

    }

    private BTNode rightRotation(BTNode grandParent) { 

        BTNode median = grandParent.left;
        
        grandParent.left = median.right;
        
        if (median.right != null) {

            median.right.parent = grandParent;

        }

        median.right = grandParent;

        median.parent = grandParent.parent;

        grandParent.parent = median;

        if (median.parent != null) {

            if (median.parent.left == grandParent) {

                median.parent.left = median;

            }
            else {

                median.parent.right = median;

            }

        }

        return median;

    }

    private BTNode leftRotation(BTNode grandParent) {

        BTNode median = grandParent.right;
        grandParent.right = median.left;
        
        if (median.left != null) {

            median.left.parent = grandParent;

        }

        median.left = grandParent;

        median.parent = grandParent.parent;
 
        grandParent.parent = median;

        if (median.parent != null) {

            if (median.parent.left == grandParent) {

                median.parent.left = median;

            }
            else {

                median.parent.right = median;

            }

        }

        return median;

    }

    private BTNode rightLeftRotation(BTNode grandParent) {
        
        grandParent.right = rightRotation(grandParent.right);

        grandParent = leftRotation(grandParent);

        return grandParent;

    }

    private BTNode leftRightRotation(BTNode grandParent) {

        grandParent.left = leftRotation(grandParent.left);

        grandParent = rightRotation(grandParent);

        return grandParent;

    }

    private void rebalance(BTNode grandParent) {

        if (grandParent.left != null) {

            if (grandParent.left.left != null) {

                grandParent = rightRotation(grandParent);

            }
            else {

                grandParent = leftRightRotation(grandParent);
                    
            }

        }
        else {

            if (grandParent.right.right != null) {

                grandParent = leftRotation(grandParent);

            }
            else {

                grandParent = rightLeftRotation(grandParent);

            }

        }

        if (grandParent.parent == null) {

            super.setRoot(grandParent);

        }

    }

    private int getHeight(BTNode BTNode) {

        if (BTNode == null) {

            return 0;

        }

        int leftHeight = getHeight(BTNode.left) + 1;
        int rightHeight = getHeight(BTNode.right) + 1;

        if (leftHeight > rightHeight) {

            return leftHeight;

        }

        return rightHeight;

    }

    private void checkBalance (BTNode BTNode) {

        if ((getHeight(BTNode.left) - getHeight(BTNode.right) > 1) || (getHeight(BTNode.left) - getHeight(BTNode.right) < -1)) {

            rebalance(BTNode);

        }

        if (BTNode.parent == null) {

            return;

        }

        checkBalance(BTNode.parent);

    }

    @Override
    public void insertIterative(int data) {

        super.insertIterative(data);

        checkBalance(super.getBTNode(data));

    }

    @Override
    public void deleteBTNode(int data) {

        BTNode parent = super.getBTNode(data).parent;

        super.deleteBTNode(data);

        checkBalance(parent);

    }

}