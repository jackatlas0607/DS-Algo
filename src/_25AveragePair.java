import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class _25AveragePair {
    public static void main(String[] args) {
        int[] a = {-11, 0, 1, 2, 3, 9, 14, 17, 21};
        averagePair(a, 1.5);
    }

    public static void averagePair(int[] arr, double avg) {

        ArrayList<int[]> result = new ArrayList<>();

        //int[] pair= new int[2];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (((arr[i] + arr[j]) / 2.0) == avg) {
//                    pair[0]=arr[i];
//                    pair[1] = arr[j];
                    //System.out.println(Arrays.toString(pair));
                    result.add(new int[]{arr[i] , arr[j]});
                }
            }
        }

        //遍歷方法1
        Iterator<int[]> iterator = result.iterator();
        while(iterator.hasNext()){
            System.out.print(Arrays.toString(iterator.next())+"\t");
        }

        System.out.println();

        //遍歷方法2
        for(int[] e:result){
            System.out.print(Arrays.toString(e)+"\t");
        }

        System.out.println();

        //遍歷方法3
        for (int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i))+"\t");
        }

    }
}
