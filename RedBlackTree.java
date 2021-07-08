public class RedBlackTree {

    private class Node {

        int data;
        Node left, right, parent;
        boolean black, isLeftChild;

        Node(int data){

            this.data = data;

            left = right = parent = null;            
            
            black = false;
            
            isLeftChild = false;

        }

    }

    private Node root;

    RedBlackTree() {

        root = null;

    }

    private Node rightRotation(Node grandParent) { 

        Node median = grandParent.left;
        
        grandParent.left = median.right;
        
        if(median.right != null) {

            median.right.parent = grandParent;

        }

        median.right = grandParent;

        median.parent = grandParent.parent;

        grandParent.parent = median;

        if(median.parent != null) {

            if(median.parent.left == grandParent){

                median.parent.left = median;

            }
            else{

                median.parent.right = median;

            }

        }

        return median;

    }

    private Node leftRotation(Node grandParent) {

        Node median = grandParent.right;
        grandParent.right = median.left;
        
        if(median.left != null) {

            median.left.parent = grandParent;

        }

        median.left = grandParent;

        median.parent = grandParent.parent;
 
        grandParent.parent = median;

        if(median.parent != null) {

            if(median.parent.left == grandParent) {

                median.parent.left = median;

            }
            else{

                median.parent.right = median;

            }

        }

        return median;

    }

    private Node rightLeftRotation(Node grandParent) {
        
        grandParent.right = rightRotation(grandParent.right);

        grandParent = leftRotation(grandParent);

        return grandParent;

    }

    private Node leftRightRotation(Node grandParent) {

        grandParent.left = leftRotation(grandParent.left);

        grandParent = rightRotation(grandParent);

        return grandParent;

    }

    private void rotate(Node grandParent) {

        if(grandParent.left != null) {

            if(grandParent.left.left != null) {

                grandParent = rightRotation(grandParent);

                grandParent.black = true;

                grandParent.left.black = false;

                if(grandParent.right != null) {

                    grandParent.right.black = false;

                }

            }
            else{

                grandParent = leftRightRotation(grandParent);
                    
                grandParent.black = true;

                grandParent.left.black = false;

                grandParent.right.black = false;

            }

        }
        else{

            if(grandParent.right.right != null) {

                grandParent = leftRotation(grandParent);

                grandParent.black = true;

                grandParent.right.black = false;

                if(grandParent.left != null) {

                    grandParent.left.black = false;

                }

            }
            else{

                grandParent = rightLeftRotation(grandParent);

                grandParent.black = true;

                grandParent.left.black = false;

                grandParent.right.black = false;

            }

        }

        if(grandParent.parent == null) {

           root = grandParent;
           root.black = true;

        }

    }

    /*private int getHeight(BTNode BTNode) {

        if(BTNode == null) {

            return 0;

        }

        int leftHeight = getHeight(BTNode.left) + 1;
        int rightHeight = getHeight(BTNode.right) + 1;

        if(leftHeight > rightHeight) {

            return leftHeight;

        }

        return rightHeight;

    }

    private void checkBalance(BTNode BTNode) {

        if((getHeight(BTNode.left) - getHeight(BTNode.right) > 1) || (getHeight(BTNode.left) - getHeight(BTNode.right) < -1)) {

            rebalance(BTNode);

        }

        if(BTNode.parent == null) {

            return;

        }

        checkBalance(BTNode.parent);

    }*/

    public void correctTree(Node node) {

        if(node.parent.isLeftChild == true) {

            //aunt is node.parent.parent.right

            if(node.parent.parent.right == null || node.parent.parent.right.black == true) {

                rotate(node.parent.parent);

            }
            else{

                if(node.parent.parent.right != null){

                    //set aunt to black

                    node.parent.parent.right.black = true;

                }

                node.parent.parent.black = false;

                node.parent.black = true;

            }

        }
        else {

            //aunt is node.parent.parent.left

            if(node.parent.parent.left == null || node.parent.parent.left.black == true) {

                rotate(node.parent.parent);

            }
            else{

                if(node.parent.parent.left != null){

                    //set aunt to black

                    node.parent.parent.left.black = true;

                }

                node.parent.parent.black = false;

                node.parent.black = true;

            }

        }

    }

    public void checkTree(Node node) {

        /*
        
            Rules:

                1)  Every Node is Red or Black
                2)  Root is always Black
                3)  New insertions are always Red
                4)  Every path from root-leaf has the same number of Black nodes
                5)  No path can have two consecutive Red nodes
                6)  Nulls are Black
        

            Rebalance Tree:

                1)  Black Aunt = Rotate
                2)  Red Aunt = Colorflip

            
            After rotation:

                            BLACK       
                            /   \
                          RED   RED
        

            After Colorflip:

                             RED
                            /   \
                        BLACK   BLACK


        */

        if(node == root) {

            return;

        }

        if(node.black == false && node.parent.black == false) {

            correctTree(node);

        }

        checkTree(node.parent);

    }

    public void insertIterative(int data) {

        Node newNode = new Node(data);

        if(root == null){

            root = newNode;

            root.black = true;

        }
        else{

            Node parent = null;
            Node traverseBTNode = root;

            while(traverseBTNode != null) {

                parent = traverseBTNode;

                if(data > traverseBTNode.data) {

                    traverseBTNode = traverseBTNode.right;

                }
                else{

                    traverseBTNode = traverseBTNode.left;

                }

            }

            if(data > parent.data) {

                parent.right = newNode;

            }
            else {

                parent.left = newNode;

                newNode.isLeftChild = true; 

            }

            newNode.parent = parent;

            checkTree(newNode);

            root.black = true;

        }

    }

}