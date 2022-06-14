public class _31MinSuubArray {

    public static void main(String[] args) {
        minSubArray(new int[]{8, 1, 6, 15, 3, 16, 5, 7, 14, 30, 12}, 60);
    }

    public static void minSubArray(int[] arr, int sum) {
        int start = 0;
        int end = 0;
        int total = 0;
        int minLength = Integer.MAX_VALUE;

        while (start < arr.length) {
            if (total < sum && end < arr.length) {
                total += arr[end];
                end++;
            } else if (total >= sum) {
                int currentLength = end - start;
                if (minLength > currentLength) {
                    minLength = currentLength;
                }
                total -= arr[start];
                start++;
            } else if (end >= arr.length) {
                break;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("Cannot find subarray that can sum up to the given number");
        } else {
            System.out.println(minLength);
        }
    }
}
