import java.util.ArrayList;

public class BinarySearchTree {

    private BTNode root;

    public BinarySearchTree() {

        root = null;

    }

    public void setRoot(BTNode node) {

        root = node;

    }

    public BTNode getBTNode(int data) {

        //use only when data DOES exist

        BTNode traverseBTNode = root;

        while (traverseBTNode.data != data) {

            if (data > traverseBTNode.data) {

                traverseBTNode = traverseBTNode.right;

            }
            else {

                traverseBTNode = traverseBTNode.left;

            }

        }

        return traverseBTNode;

    }

    public boolean findData(int data) {

        BTNode traverseBTNode = root;

        while (traverseBTNode != null) {

            if (traverseBTNode.data == data) {

                return true;

            }
            else {

                if (data > traverseBTNode.data) {

                    traverseBTNode = traverseBTNode.right;

                }
                else {

                    traverseBTNode = traverseBTNode.left;

                }

            }

        }

        return false;

    }

    private BTNode insertRecursiveAlternative(BTNode current, int data) {

        if (current == null) {

            current = new BTNode(data);

        }
        else if (data <= current.data) {

            current.left = insertRecursiveAlternative(current.left, data);

        }
        else {

            current.right = insertRecursiveAlternative(current.right, data);

        }

        return current;

    }

    public void insertRecursiveAlternative(int data) {

        root = insertRecursiveAlternative(root, data);

    }

    private void insertRecursive(BTNode current, int data) {

        if (current == null) {

            root = new BTNode(data);

        }
        else if (data <= current.data) {

            if (current.left != null) { 
                
                insertRecursive(current.left, data);
            
            }
            else {

                current.left = new BTNode(data);

            }

        }
        else {

            if (current.right != null) {
                
                insertRecursive(current.right, data);
            
            }
            else {

                current.right = new BTNode(data);

            }

        }

    }

    public void insertRecursive(int data) {

        insertRecursive(root, data);

    }

    public void insertIterative(int data) {

        BTNode node = new BTNode(data);

        if (root == null) {

            root = node;

        }
        else {

            BTNode parent = null;
            BTNode traverseBTNode = root;

            while (traverseBTNode != null) {

                parent = traverseBTNode;

                if (data > traverseBTNode.data) {

                    traverseBTNode = traverseBTNode.right;

                }
                else {

                    traverseBTNode = traverseBTNode.left;

                }

            }

            if (data > parent.data) {

                parent.right = node;

            }
            else {

                parent.left = node;

            }

            node.parent = parent;

        }

    }

    public void deleteBTNode(int data) {

        if (root == null) {

            System.out.println("The Tree is empty");

        }
        else if (findData(data) == false) {

            System.out.println("Data was not found in tree");

        }
        else {
            /*

                Data exists in Tree
            
                3 conditions

                (i)   Leaf BTNode
                (ii)  BTNode with 1 child
                (iii) BTNode with 2 children
            
            */

            BTNode deleteBTNode = getBTNode(data);

            if ((deleteBTNode.left == null) && (deleteBTNode.right == null)) {
                
                //is a leaf BTNode

                if (deleteBTNode == root) {

                    root = null;

                }
                else {

                    BTNode parentBTNode = deleteBTNode.parent;

                    if (parentBTNode.left == deleteBTNode) {

                        parentBTNode.left = null;

                    }
                    else if (parentBTNode.right == deleteBTNode) {

                        parentBTNode.right = null;

                    }

                }

            }
            else if ((deleteBTNode.right != null && deleteBTNode.left == null) || (deleteBTNode.left != null && deleteBTNode.right == null)) {
                
                //Delete BTNode has one child

                if (deleteBTNode == root) {

                    if (root.left != null) {

                        root = root.left;

                    }
                    else {

                        root = root.right;

                    }

                    root.parent = null;

                }
                else {

                    BTNode parentBTNode = deleteBTNode.parent;

                    if (parentBTNode.left == deleteBTNode) {

                        //Delete BTNode's child should be linked to parentBTNode's left

                        if (deleteBTNode.left != null) {

                            parentBTNode.left = deleteBTNode.left;
                            deleteBTNode.left.parent = parentBTNode;

                        }
                        else {
                            
                            parentBTNode.left = deleteBTNode.right;
                            deleteBTNode.right.parent = parentBTNode;
                        
                        }

                    }
                    else {

                        //Delete BTNode's child should be linked to parentBTNode's right

                        if (deleteBTNode.left != null) {

                            parentBTNode.right = deleteBTNode.left;
                            deleteBTNode.left.parent = parentBTNode;

                        }
                        else {

                            parentBTNode.right = deleteBTNode.right;
                            deleteBTNode.right.parent = parentBTNode;

                        }

                    }

                }

            }
            else {

                //BTNode with 2 children

                BTNode smallestKey = deleteBTNode;

                while (smallestKey.left != null) {

                    smallestKey = smallestKey.left;

                }

                int smallestKeyValue = smallestKey.data;

                deleteBTNode(smallestKey.data);

                deleteBTNode.data = smallestKeyValue;

            }

        }

    }
    
    private void preOrder(BTNode current) {

        if (current == null) {

            return;

        }

        System.out.println(current.data);
        
        preOrder(current.left);

        preOrder(current.right);

    }

    public void preOrder() {

        preOrder(root);

    }

    private void inOrder(BTNode current) {

        if (current == null) {

            return;

        }

        inOrder(current.left);

        System.out.println(current.data);

        inOrder(current.right);

    }

    public void inOrder() {

        inOrder(root);

    }

    private void returnInOrder(BTNode current, ArrayList<Integer> list) {

        if (current != null) {
        
            returnInOrder(current.left, list);

            list.add(current.data);

            returnInOrder(current.right, list);
        
        }    

    }

    private void postOrder(BTNode current) {

        if (current == null) {

            return;

        }

        postOrder(current.left);

        postOrder(current.right);

        System.out.println(current.data);

    }

    public void postOrder() {

        postOrder(root);

    }

    public void sortedArrayToBalancedBST(int[] arr) {

        root = sortedArrayToBalancedBST(arr, 0, arr.length - 1);

    }

    private BTNode sortedArrayToBalancedBST(int[] arr, int start, int end) {

        if (start > end) {

            return null;

        }

        int mid = (start + end)/2;
        BTNode BTNode = new BTNode(arr[mid]);

        BTNode.left = sortedArrayToBalancedBST(arr, start, mid - 1);

        BTNode.right = sortedArrayToBalancedBST(arr, mid + 1, end);

        return BTNode;

    }

    public void convertToBalancedBST() {

        ArrayList<Integer> list = new ArrayList<Integer>();

        returnInOrder(root, list);

        int[] arr = new int[list.size()];
        int index = 0;

        for (Integer array: list) {

            arr[index] = array;
            index++;

        }

        sortedArrayToBalancedBST(arr);

    }

    public int getMin() {

        BTNode traverseBTNode = root;

        while (traverseBTNode.left != null) {

            traverseBTNode = traverseBTNode.left;

        }

        return traverseBTNode.data;

    }

    public int getMax() {

        BTNode traverseBTNode = root;

        while (traverseBTNode.right != null) {

            traverseBTNode = traverseBTNode.right;

        }

        return traverseBTNode.data;

    }

    public void printRightSide() {

        if (root == null) {

            System.out.println("BST is empty");

        }
        else {

            BTNode traverseNode = root;

            while (traverseNode != null) {

                System.out.println(traverseNode.data);

                if (traverseNode.right != null) {

                    traverseNode = traverseNode.right;

                }
                else {

                    traverseNode = traverseNode.left;

                }

            }

        }

    }

    public int LCA(int num1, int num2) {

        if (num1 == num2) {

            return num1;

        }

        ArrayList<Integer> arr1 = new ArrayList<>();

        BTNode traverseNode = root;
        while (traverseNode.data != num1) {

            arr1.add(traverseNode.data);

            if (num1 > traverseNode.data) {

                traverseNode = traverseNode.right;

            }
            else {

                traverseNode = traverseNode.left;

            }

        }

        ArrayList<Integer> arr2 = new ArrayList<>();

        traverseNode = root;
        while (traverseNode.data != num2) {

            arr2.add(traverseNode.data);

            if (num2 > traverseNode.data) {

                traverseNode = traverseNode.right;

            }
            else {

                traverseNode = traverseNode.left;

            }

        }

        int lca = 0;

        for (int i = 0; i < arr2.size(); i++){
            
            if (arr1.get(i) == arr2.get(i)) {

                lca = arr2.get(i);

            }
            else {

                break;

            }

        }

        return lca;

    }

    public void printBFS() {

        LinkListQueue<BTNode> queue = new LinkListQueue<>();

        queue.enqueue(root);

        while (queue.isEmpty() != true) {

            BTNode temp = queue.dequeue();
            System.out.print(temp.data + " ");

            if (temp.left != null) {

                queue.enqueue(temp.left);

            }
            
            if (temp.right != null) {

                queue.enqueue(temp.right);

            }

        }

    }

}