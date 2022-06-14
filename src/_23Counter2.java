import java.util.HashSet;


public class _23Counter2 {
    public static void main(String[] args) {
        int[] a1 = {1, 1, 1};
        int[] a2 = {2, 2};
        intersection(a1, a2);
    }

    public static void intersection(int[] arr1, int[] arr2) {

        HashSet set1 = new HashSet<>();
        HashSet set2 = new HashSet<>();


        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set2.add(arr2[i]);
        }

        set1.retainAll(set2);
        if (set1.isEmpty()){
            System.out.println("No intersection");
        }else{
            System.out.println(set1);
        }

    }
}
