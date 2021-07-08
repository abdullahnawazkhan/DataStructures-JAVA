public class DoublyLinkList <T> {

    private class Node {

        Node prev;
        T data;
        Node next;

        public Node(T data) {

            prev = null;
            this.data = data;
            next = null;

        }

    }

    private Node head;
    private Node tail;

    public DoublyLinkList() {

        head = tail = null;

    }

    public boolean findData(T data) {

        if(head == null){

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

    public void insert(T data) {

        Node node = new Node(data);

        if (head == null) {

            head = tail = node;

        }
        else {

            node.prev = tail;
            tail.next = node;

            tail = node;

        }

    }

    public void insert(T data, T after) {

        if (findData(after) == false) {

            System.out.println("\n\t\t" + after + " was not found in list, " + data + " inserted normally");

            insert(data);

        }
        else if (tail.data == after) {

            insert(data);

        }
        else {

            Node afterNode = head;

            while (afterNode.data.equals(after) != true) {

                afterNode = afterNode.next;

            }

            Node node = new Node(data);

            node.prev = afterNode;
            node.next = afterNode.next;

            if (afterNode.next != null) {
                
                afterNode.next.prev = node;
                afterNode.next = node;
            
            }

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

                //only 1 element exists in list

                head = tail = null;
            
            }
            else if (head.data.equals(data)) {

                //deleting head node

                head = head.next;
                head.prev = null;
                
            }
            else if (tail.data.equals(data)) {

                //deleting tail node

                tail = tail.prev;
                tail.next = null;

            }
            else {

                //delete node is somewhere in between head and tail

                Node deleteNode = head;
                while (deleteNode.data.equals(data) != true) {

                    deleteNode = deleteNode.next;

                }

                deleteNode.prev.next = deleteNode.next;
                deleteNode.next.prev = deleteNode.prev;

            }

        }

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
                    System.out.print(" <-> ");
                }
            }

            System.out.println();
        }
    }


    public void reverseList() {
        if (head == null) {
            System.out.println("The List is Empty");
        }
        else {
            Node curr = head;
            Node next = curr.next;

            while (curr.next != null) {
                Node temp = curr.next;
                curr.next = curr.prev;
                curr.prev = temp;

                curr = next;
                next = curr.next;
            }

            Node temp = tail;
            tail = head;
            head = temp;
        }
    }
}