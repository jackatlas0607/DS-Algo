import java.util.Arrays;

public class _40BubbleSort3 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 9, 7, 6, 20, 16, 12};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println("------------------------------");

        int[] test = new int[20];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) Math.floor(Math.random()*100);
        }

        System.out.println(Arrays.toString(bubbleSort(test)));
        System.out.println("------------------------------");

        //  1/2 * n^2 - 1/2 * n
        //  25/2 - 5/2 = 10
        System.out.println(Arrays.toString(bubbleSort(new int[]{5,4,3,2,1})));
        System.out.println("------------------------------");

        System.out.println(Arrays.toString(bubbleSort(new int[]{1,2,3,4,5})));
    }

    public static int[] bubbleSort(int[] arr) {
        int step = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    step++;
                }
            }
        }
        System.out.println("It takes " + step + " steps to complete.");
        return arr;
    }
}
