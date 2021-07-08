public class ArrayQueue <T> {

    private T[] arr;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(int size) {

        this.size = size;
        arr = (T[]) new Object[size];
        head = tail = 0;

    }

    public void enqueue(T data) {

        if (tail == size) {

            System.out.println("Queue is full");

        }
        else if (head == tail) {

            arr[head] = data;
            tail++;

        }
        else {

            arr[tail] = data;
            tail++;

        }

    }
    
    public void dequeue() {

        if (head == tail) {

            System.out.println("The Queue is empty");

        }
        else {

            for (int i = 1; i < tail; i++) {

                arr[i - 1] = arr[i];

            }

            tail--;

        }

    }

    public void display() {

        if (head == tail) {

            System.out.println("Queue is empty");

        }
        else {

            for (int i = head; i < tail; i++) {

                System.out.println(arr[i]);

            }

        }

    }

    public void displayAlternate() {

        if (head == tail) {

            System.out.println("Queue is empty");

        }
        else if (tail > head) {

            for (int i = head; i < tail; i++) {

                System.out.println(arr[i]);

            }

        }
        else {

            for (int i = head; i < size; i++) {

                System.out.println(arr[i]);

            }

            for (int i = 0; i < tail; i++) {

                System.out.println(arr[i]);

            }

        }

    }

}