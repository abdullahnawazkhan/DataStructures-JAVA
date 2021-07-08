public class LinkListQueue <T> {

    private class Node {

        T data;
        Node next;

        public Node(T data) {

            this.data = data;
            next = null;

        }

    }

    private Node front;
    private Node rear;

    public LinkListQueue() {

        front = rear = null;

    }

    public boolean isEmpty() {

        if (front == null) {

            return true;

        }

        return false;

    }

    public void enqueue(T data) {

        Node node = new Node(data);

        if (front == null) {

            front = rear = node;

        }
        else {

            rear.next = node;

            rear = node;

        }

    }

    public T dequeue() {

        T returnVal = null;

        if (front == null) {

            System.out.println("\t\tSorry the queue is empty");

        }
        else if (front == rear) {

            returnVal = front.data;
            front = rear = null;

        }
        else {

            returnVal = front.data;
            front = front.next;

        }

        return returnVal;

    }

    public void displayQueue(){

        if (front == null) {

            System.out.println("\t\tList is empty");

        }
        else {

            Node traverseNode = front;

            while (traverseNode != null) {

                System.out.println("\t\t" + traverseNode.data);

                traverseNode = traverseNode.next;

            }

        }

    }

}