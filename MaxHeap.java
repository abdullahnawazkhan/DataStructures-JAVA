public class MaxHeap {
   private int[] heap;
   private int noOfElements;
   private int maxSize;

   public MaxHeap(int maxSize) {
      this.maxSize = maxSize;
      heap = new int[maxSize];
      noOfElements = 0;
   }

   private int parent(int pos) {
      return ((pos - 1) / 2);
   }

   private int leftChild(int pos) {
      return (2 * pos) + 1;
   }

   private int rightChild(int pos) {
      return (2* pos) + 2;
   }

   private boolean isLeaf(int pos) {
      if ((hasLeftChild(pos) == false) && (hasRightChild(pos) == false)) {
         return true;
      }
      return false;
   }

   private boolean hasLeftChild(int pos) {
      if (leftChild(pos) < noOfElements) {
         return true;
      }
      return false;
   }

   private boolean hasRightChild(int pos) {
      if (rightChild(pos) < noOfElements) {
         return true;
      }
      return false;
   }

   private boolean hasParent(int pos) {
      if (parent(pos) >= 0) {
         return true;
      }
      return false;
   }

   public void delete() {
      if (noOfElements == 0) {
         System.out.println("Heap is empty");
      }
      else {
         heap[0] = heap[noOfElements - 1];
         noOfElements--;
         int current = 0;

         while (isLeaf(current) == false) {
            int largestChild;

            if (hasLeftChild(current) == false) {
               largestChild = rightChild(current);
            }
            else if (hasRightChild(current) == false) {
               largestChild = leftChild(current);
            }
            else {
               if (heap[leftChild(current)] > heap[rightChild(current)]) {
                  largestChild = leftChild(current);
               }
               else {
                  largestChild = rightChild(current);
               }  
            }
            if (heap[current] < heap[largestChild]) {
               int temp = heap[current];
               heap[current] = heap[largestChild];
               heap[largestChild] = temp;

               current = largestChild;
            }
            else {
               break;
            }
         }
      }
   }

   public void insert(int data) {
      if (noOfElements >= maxSize) {
         System.out.println("Heap is full");
      }

      heap[noOfElements] = data;
      int current = noOfElements;
      noOfElements++;

      while ((hasParent(current)) && (heap[current] > heap[parent(current)])) {
         int temp = heap[current];
         heap[current] = heap[parent(current)];
         heap[parent(current)] = temp;

         current = parent(current);
      }  
   }

   public void print() {
      for (int i = 0; i < noOfElements; i++) { 
         System.out.print(heap[i] + " ");
      } 

      System.out.println();
   }
}