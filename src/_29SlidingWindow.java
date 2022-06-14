import java.util.ArrayList;

public class _29SlidingWindow {
    public static void main(String[] args) {

        int[] a = {2, 7, 3, 0, 6, 1, -5, -12, -11};  // 9

        maxSum(a, 3); // 12
        minSum(a, 3); // -28
    }

    public static void maxSum(int[] arr, int size) {
        int max = Integer.MIN_VALUE;

        if (size > arr.length) {
            System.out.println("Size is larger then array's length");
            return;
        }

        for (int i = 0; i <= arr.length - size; i++) {
            int temp = 0;
            for (int j = i; j < i + size; j++) {
                temp += arr[j];
            }

            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);


    }

    public static void minSum(int[] arr, int size) {
        if (size > arr.length) {
            System.out.println("Size is larger then array's length");
            return;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - size; i++) {
            int temp=0;
            for (int j = i; j < i + size; j++) {
                temp +=arr[j];
            }

            if (temp<min){
                min = temp;
            }
        }

        System.out.println(min);
    }
}
