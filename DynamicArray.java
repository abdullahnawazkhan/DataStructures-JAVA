public class DynamicArray <T> {

    private T[] arr;
    private int index;
    private int size;

    DynamicArray(int size) {

        this.size = size;
        arr = (T[]) new Object[size];
        index = 0;

    }

    public void insertData(T data) {

        if (index >= size) { 

            size++;

            T[] newArr = (T[]) new Object[size];
            
            for (int i = 0; i < arr.length; i++) {

                newArr[i] = arr[i];

            }

            arr = newArr;

        }

        arr[index] = data;
        index++;

    }

    public int findIndex(T data) {

        int index = -1;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == data){

                index = i;
                break;

            }

        }

        return index;

    }

    public void delete(T data) {

        int deleteIndex = findIndex(data);

        if (deleteIndex == -1) {

            System.out.println("Data was not found");

        }
        else {

            size--;
            T[] newArr = (T[]) new Object[size];

            for (int i = 0, j = 0; i < arr.length; i++, j++) {

                if(i == deleteIndex){

                    j--;

                }
                else{

                    newArr[j] = arr[i]; 

                }

            }

            arr = newArr;

        }

    }

    public void deleteAlternative(T data) {

        int deleteIndex = findIndex(data);

        if (deleteIndex == -1) {

            System.out.println("Data was not found");

        }
        else {

            for (int i = deleteIndex + 1; i < arr.length; i++) {

                arr[i - 1] = arr[i];

            }

            size--;

            T[] newArr = (T[]) new Object[size];
            for (int i = 0; i < newArr.length; i++) {

                newArr[i] = arr[i];

            }

            arr = newArr;

        }

    }

    public void display() {

        if(index == 0) {

            System.out.println("No data has been entered");

        }
        else {

            for (int i = 0; i < arr.length; i++) {

                System.out.println(arr[i]);

            }
            
            System.out.println("Size : " + size);

        }

    }

}