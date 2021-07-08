public class SinglyLinkList <T> {

    private class Node {

        T data;
        Node next;

        public Node (T data) {

            this.data = data;
            next = null;
 
        }

    }

    private Node head;
    private Node tail;

    public SinglyLinkList() {

        head = tail = null;

    }

    public boolean findData(T data) {

        if (head == null) {

            return false;

        }
        else {

            Node traverseNode = head;

            while (traverseNode != null) {

                if (traverseNode.data.equals(data)) {

                    break;

                }

                traverseNode = traverseNode.next;

            }

            if (traverseNode == null) {

                return false;

            }
            else {

                return true;

            }

        }

    }

    public void insert (T data) {

        Node node = new Node(data);

        if (head == null) {

            head = tail = node;

        }
        else {

            tail.next = node;
            tail = node;

        }

    }

    public void insert (T data, T after) { 
         
        if (head == null) {

            System.out.println("\n\t\tThe list is empty. " + data + " inserted normally");
            insert(data);

        }
        else if (findData(after) == false) {

            System.out.println("\n\t\t" + after + " was not found in list. " + data + " inserted normally");
            insert(data);

        }
        else if (tail.data.equals(after)) {

            insert(data);

        }
        else {

            Node afterNode = head;

            while (afterNode.data.equals(after) != true) {

                afterNode = afterNode.next;

            }

            Node newNode = new Node(data);

            newNode.next = afterNode.next;
            afterNode.next = newNode;

            System.out.println("\n\t\t" + data + " inserted after " + after);

        }

    }

    public void replace(T newData, T oldData){

        if (head == null) {

            System.out.println("THe List is EMpty");

        }
        else if (findData(oldData) == false){

            System.out.println("Could not find " + oldData + " in List");

        }
        else {

            Node traverseNode = head;

            while(traverseNode.data.equals(oldData) == false){

                traverseNode = traverseNode.next;

            }

            traverseNode.data = newData;

        }

    }

    public void delete(T data) {

        if (head == null) {

            System.out.println("\n\t\tList is empty");

        }
        else if (findData(data) == false) {

            System.out.println("\n\t\t" + data + " does not exist in node");

        }
        else {   
            
            //data exists to delete

            if ((head.data.equals(data)) && (head.next == null)) {

                //only 1 element in list

                head = tail = null;
                
            }
            else if (head.data.equals(data)) {

                //deleting head node

                head = head.next;

            }
            else if (tail.data.equals(data)) {

                //deleting tail node

                Node newTail = head;
                while (newTail.next != tail) {

                    newTail = newTail.next;

                }

                newTail.next = null;
                tail = newTail;

            }
            else {

                //delete node is somewhere between head and tail

                Node deleteNode = head;
                while (deleteNode.data.equals(data) != true) {

                    deleteNode = deleteNode.next;

                }

                Node prevNode = head;
                while (prevNode.next.equals(deleteNode) != true) {

                    prevNode = prevNode.next;

                }

                prevNode.next = deleteNode.next;

            }

        }

    }

    public void arrayToList(T[] arr, int size) {

        for (int i = 0; i < size; i++) {

            insert(arr[i]);

        }

        System.out.println("Array successfull converted into List");

    }

    public void display() {

        if (head == null) {

            System.out.println("\n\t\tList is empty");

        }
        else {

            Node traverseNode = head;

            System.out.print("\t\t");

            while (traverseNode != null) {

                System.out.print(traverseNode.data);

                traverseNode = traverseNode.next;

                if (traverseNode != null) {

                    System.out.print(" -> ");

                }

            }

            System.out.println();

        }

    }

    public void reverseLinkListEfficient() {

        if (head == null) {

            System.out.println("The List is Empty");

        }
        else {

            Node curr, prev, next;

            curr = head;
            prev = next = null;

            while (curr != null) {

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }

            tail = head;
            head = prev;

        }

    }

    public void reverseLinkListInefficient(){

        if (head == null) {

            System.out.println("The List is empty");

        }
        else {

            Node temp = tail;
            tail = head;
            head = temp;

            Node curr = head;
            Node nextNode = tail;

            while (tail != curr) {

                while (nextNode.next != curr) {

                    nextNode = nextNode.next;

                }

                curr.next = nextNode;

                curr = curr.next;

                nextNode = tail;

            }

            tail.next = null;

        }

    }

}