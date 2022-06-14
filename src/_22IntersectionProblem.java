import java.util.ArrayList;

public class _22IntersectionProblem {
    public static void main(String[] args) {

        ArrayList intersection = intersection(new int[]{1, 6, 4, 23, 5}, new int[]{2, 4, 5, 76});
        System.out.println(intersection);
    }


    public static ArrayList intersection(int[] arr1,int[] arr2){

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    result.add(arr1[i]);
                    break;
                }
            }
        }
        return result;
    }
}
