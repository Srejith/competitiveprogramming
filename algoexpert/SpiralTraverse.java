import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        //initialized an array that it is not visited
        List<Integer> result = new ArrayList<>();

        int leftIdx = 0;
        int rightIdx = 0;
        int n = array.length;
        int m = array[0].length;
        int rightMax = m;
        int bottomMax = n-1;
        int counter = n*m;
        while(counter>0){

            int localCounter = 0;
            while(localCounter<rightMax && counter>0){
                result.add(array[leftIdx][rightIdx++]);
                localCounter++;
                counter--;
            }
            rightIdx--;
            leftIdx++;
            localCounter = 0;

            while(localCounter<bottomMax && counter>0) {
                result.add(array[leftIdx++][rightIdx]);
                counter--;
                localCounter++;
            }
            leftIdx--;
            rightIdx--;
            bottomMax--;
            rightMax--;
            localCounter=0;

            while(localCounter<rightMax && counter>0){
                result.add(array[leftIdx][rightIdx--]);
                counter--;
                localCounter++;
            }
            leftIdx--;
            rightIdx++;
            localCounter = 0;

            while(localCounter<bottomMax && counter>0) {
                result.add(array[leftIdx--][rightIdx]);
                counter--;
                localCounter++;
            }
            leftIdx++;
            rightIdx++;
            bottomMax--;
            rightMax--;

        }
        return result;
    }
}
