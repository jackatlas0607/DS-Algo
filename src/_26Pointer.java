import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class _26Pointer {
    public static void main(String[] args) {
        int[] a = {-11, 0, 1, 2, 3, 9, 14, 17, 21};
        averagePair(a, 1.5);
    }

    public static void averagePair(int[] arr, double avg) {
        int left = 0;
        int right = arr.length - 1;
        ArrayList<int[]> result = new ArrayList<>();

        while (right > left) {
            double tempAverage = (arr[left] + arr[right]) / 2.0;
            if (tempAverage > avg) {
                right--;
            }else if(tempAverage==avg){
                result.add(new int[]{arr[left],arr[right]});
                right--;
                left++;
            }else{
                left++;
            }
        }

        Iterator<int[]> iterator = result.iterator();
        while(iterator.hasNext()){
            System.out.print(Arrays.toString(iterator.next())+"\t");
        }

        System.out.println();

        for (int[] e : result){
            System.out.print(Arrays.toString(e)+"\t");
        }

        System.out.println();

        for (int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i))+"\t");
        }


    }
}
