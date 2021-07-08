//  Includes all sorting algorithms

public class SortingAlgorithms {

    private int array[];

    public SortingAlgorithms(int array[]) {
        this.array = array;
    }

    public int[] bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swapping values of indexes
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return this.array;
    }

    public int[] selectionSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return this.array;
    }

    public int[] insertionSort() {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int index;
            for (index = i - 1; index >= 0; index--) {
                if (array[index] <= value) {
                    break;
                }
                array[index + 1] = array[index];
            }
            
            array[index + 1] = value;
        }
        return this.array;
    } 

}