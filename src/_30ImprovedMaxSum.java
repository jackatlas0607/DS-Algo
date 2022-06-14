public class _30ImprovedMaxSum {
    public static void main(String[] args) {
        maxSum(new int[]{2, 7, 3, 7, 25, 0, 6, 1, -5, 12, -11}, 3); // 35
    }

    public static void maxSum(int[] arr, int size) {
        if (size > arr.length) {
            System.out.println("Size is larger then array's length");
            return;
        }

        int max = 0;
        for (int i = 0; i < size; i++) {
            max += arr[i];
        }

        int temp = max;

        for (int j = size; j < arr.length; j++) {
            temp = temp + arr[j] - arr[j - size];
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);

    }
}
