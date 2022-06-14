import java.util.Arrays;

public class _41BuubleSortFinalCode {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 9, 7, 6, 20, 16, 12};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println("------------------------------");

        System.out.println(Arrays.toString(bubbleSort(new int[]{5,4,3,2,1})));
    }

    public static int[] bubbleSort(int[] arr) {
        int step = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapping = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    step++;
                    swapping = true;
                }else if (swapping == false){
                    break;
                }
            }


        }
        System.out.println("It takes " + step + " steps to complete.");
        return arr;
    }
}
