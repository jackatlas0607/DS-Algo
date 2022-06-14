import java.util.Arrays;

public class _51MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1, 15, 17};
        int[] arr2 = {-3, 9, 16};
        System.out.println(Arrays.toString(conquer(arr1, arr2)));

        System.out.println("-----------------------------------------------------------");

        int[] arr3 = {15, 3, 17, 18, 35, 11, 0, 36, -336, 1054};
        System.out.println(Arrays.toString(mergeSort(arr3)));

    }

    public static int[] conquer(int[] arr1, int[] arr2) {
        // {1,3,6}  {2,4,8}

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j++;
                k++;
            } else {
                result[k] = arr1[i];
                i++;
                k++;
            }
        }

        // a1 or a2 might have some elements left
        // use loop to put them all into result

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }else{
            //{5,4,9,1,3}  middle = 2
            // {5,4,9,6,1,3}  middle = 3
            //divide
            int middle = (int) Math.floor(arr.length/2);
            int[] left = new int[middle];
            int[] right = new int[arr.length-middle];
            System.arraycopy(arr,0,left,0,left.length);
            System.arraycopy(arr,left.length,right,0,right.length);
            return conquer(mergeSort(left),mergeSort(right));

        }
    }


}
