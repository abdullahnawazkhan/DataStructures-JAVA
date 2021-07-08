public class List {

    private int elements;
    private int m; //key value
    private Node head;

    List(int elements, int m) {

        this.elements = elements;
        this.m = m;
        head = new Node(0);

        Node curr = head;
        for (int i = 0; i < elements - 1; i++) { //creating a circular linked list

            curr.next = new Node(i + 1);
            curr = curr.next;

        }
        curr.next = head;

    }

    void print() {

        Node curr = head.next;
        System.out.print(head.data + " ");

        while (curr != head) {

            System.out.print(curr.data + " ");
            curr = curr.next;

        }

    }

    private void delete(Node node) {

        Node prev = head;
        while (prev.next != node) {

            prev = prev.next;

        }

        prev.next = node.next;
        elements--;

    }

    public void start() {

        Node curr = head;

        while (elements != 1) {

            for (int i = 0; i < m - 1; i++) {

                curr = curr.next;

            }

            System.out.println(curr.data + "-index element removed");

            Node temp = curr;
            delete(temp);

            curr = curr.next;

        }

        head = curr;
        System.out.println("Element Remaining: " + head.data);

    }

}