public class LinkListStack <T> {

    private class Node {

        T data;
        Node next;

        public Node(T data) {

            this.data = data;
            next = null;

        }

    }

    private Node top;

    public LinkListStack() {

        top = null;

    }

    public void push(T data) {

        Node node = new Node(data);

        if (top == null) {

            top = node;

        }
        else {

            node.next = top;
            top = node;

        }

    }

    public void pop() { 

        if (top == null) {

            System.out.println("\t\tStack is already empty");

        }
        else if (top.next == null) {

            top = null; 

        }
        else {

            top = top.next;

        }

    }

    public void peek() {

        if (top == null) {

            System.out.println("\t\tStack is empty");

        }
        else {

            System.out.println("\t\t" + top.data);

        }

    }

}