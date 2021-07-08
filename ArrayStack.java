public class ArrayStack <T> {

    private T[] arr;
    private int top;

    public ArrayStack(int size) {

        arr = (T[]) new Object[size];
        top = 0;

    }

    public void push(T data) {

        if (top >= arr.length) {

            System.out.println("Stack Overflow");

        }
        else {

            arr[top] = data;
            top++;

        }

    }

    public T pop() {

        if (top == 0) {

            System.out.println("Stack Underflow");
            return null;

        }
        else {

            top--;
            return arr[top];

        }

    }

    public int getTopIndex() {

        return top;

    }

    public void display() {

        if (top == 0) {

            System.out.println("Stack Empty");

        }
        else {

            for (int i = 0 ; i < top; i++) {

                System.out.println(arr[i]);

            }

            System.out.println("Top : " + top);

        }

    }

}