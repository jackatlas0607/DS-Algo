import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _23Counter {
    public static void main(String[] args) {
        int[] a1 = {1,1,1};
        int[] a2 = {2,2,2};
        HashSet intersection = intersection(a1, a2);
        System.out.println(intersection);
    }

    public static HashSet intersection(int[] arr1, int[] arr2) {

        int[] arr3 = new int[arr1.length + arr2.length];

        HashMap<Integer, Integer> counter = new HashMap<>();

        HashSet<Integer> result = new HashSet<>();

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println("new cocat array is " + Arrays.toString(arr3));

        for (int i = 0; i < arr3.length; i++) {
            if (counter.containsKey(arr3[i])) {
                Integer value = counter.get(arr3[i]);
                //counter.remove(arr3[i]);
                counter.put(arr3[i], ++value);
            } else {
                counter.put(arr3[i], 1);
            }

        }

        /*
           counter.forEach((k, v) -> {
              System.out.println(k + ":" + v);
           });
        */

        for (int i = 0; i < arr3.length; i++) {
            if (counter.get(arr3[i]) >= 2) {
                result.add(arr3[i]);
            }
        }

        return result;
    }
}
