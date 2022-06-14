import java.util.Arrays;

public class _44InsertionSort {
    public static void main(String[] args) {

        int[] arr = {14, -4, 17, 6, 22, 1, -5};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    //  -4 14 17 6 -->  -4 14 17 17 --> -4 14 14 17 --> -4 6 14 17

    public static int[] insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];  
                i-=1;
            }
            arr[i+1]=key;

        }
        return arr;
    }

}
