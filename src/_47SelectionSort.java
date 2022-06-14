import java.util.Arrays;

public class _47SelectionSort {
    public static void main(String[] args) {

        int[] arr = {14, -4, 17, 6, 22, 1, -5};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }
}
