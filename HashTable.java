public class HashTable {

    private class Node {

        String data;
        Node next;

        Node(String data) {

            this.data = data;
            next = null;

        }

    }

    private Node[] arr;
    private int size;
    private int noOfElements;

    public HashTable(int initialSize) {

        noOfElements = 0;
        size = initialSize;
        arr = new Node[size];

    }

    public boolean findData(String data) {

        int index = hashFunction(data);

        if (arr[index] == null) {

            return false;

        }
        else {

            Node traverseNode = arr[index];

            while (traverseNode != null) {

                if (traverseNode.data.equals(data) == true) {

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

    public double loadFactor() {

        return (noOfElements / size);

    }

    public int hashFunction(String data) {

        int hash = 0;

        for (int i = 0; i < data.length(); i++) {

            hash += (int) data.charAt(i);

        }

        return (hash % size);

    }

    public void insert(String data) {

        if (loadFactor() > 0.70) {

            System.out.println("THe Table is full");

        }

        Node newNode = new Node(data);

        int index = hashFunction(newNode.data);

        if (arr[index] == null) {

            arr[index] = newNode;
            noOfElements++;

        } 
        else {

            Node traverseNode = arr[index];

            while (traverseNode.next != null) {

                traverseNode = traverseNode.next;

            }

            traverseNode.next = newNode;

        }

    }

    public void remove(String data) {

        if (findData(data) == false) {

            System.out.println("Data does not exist in Hash Table");

        }
        else {

            int index = hashFunction(data);

            Node deleteNode = arr[index];

            while (deleteNode.data.equals(data) != true) {

                deleteNode = deleteNode.next;

            }

            if (arr[index] == deleteNode) {

                //first Node of chain at index

                arr[index] = deleteNode.next;

            }
            else {

                //will need another ref referencing to the node before deleteNode

                Node prevNode = arr[index];
    
                while (prevNode.next != deleteNode) {
    
                    prevNode = prevNode.next;
    
                }

                if (deleteNode.next == null) {
    
                    //last node of the chain

                    prevNode.next = null;
    
                }
                else {

                    //somewhere in b/w first and last

                    prevNode.next = deleteNode.next;
    
                }

            } 

        }

    }

    public void printTable() {

        for (int i = 0; i < size; i++){

            if (arr[i] != null) {

                Node traverseNode = arr[i];

                while (traverseNode != null) {

                    System.out.println(traverseNode.data);

                    traverseNode = traverseNode.next;

                }

            }

        }

    }

    public void printIndexes() {

        for (int i = 0; i < size; i++) {

            System.out.print("index " + i + " : ");

            if (arr[i] != null) {

                System.out.println("OCCUPIED");

            }
            else {

                System.out.println("EMPTY");

            }

        }

    }

}