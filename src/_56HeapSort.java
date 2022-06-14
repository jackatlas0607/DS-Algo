import java.util.Arrays;

public class _56HeapSort {
    public static void main(String[] args) {
        int[] arr = {15, 3, 17, 18, 20, 2, 1, 666};
        //Arrays.sort(arr);

        Sort sort = new Sort(arr);
        sort.heapSort();
        System.out.println(Arrays.toString(arr));

        System.out.println("--------------------------------------------");

        int[] arr2 = {15, 3, 17, 18, 20, 2, 1, 666};
        Sort sort1 = new Sort(arr2);
        System.out.println(Arrays.toString(sort1.heapSort2()));
        System.out.println(Arrays.toString(arr2));
    }
}

class Sort {
    private int heapSize;
    private int[] arr;

    public Sort(int[] arr) {
        this.arr = arr;
        heapSize = arr.length - 1;
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            maxHeapify(0);
        }
    }

    public int[] heapSort2(){
        buildMaxHeap();
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSize--;
            maxHeapify(0);
        }

        return arr;
    }


    public void maxHeapify(int i) {
        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l <= heapSize && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= heapSize && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            // swap A[i] with A[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(largest);
        }

    }

    public void buildMaxHeap() {
        for (int i = (int) Math.floor(heapSize / 2); i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
