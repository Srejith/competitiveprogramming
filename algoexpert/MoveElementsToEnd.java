import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Difficulty - Medium
 * Move all instances of the integer to the end of the array
 *
 * {"array": [2, 1, 2, 2, 2, 3, 4, 2], "toMove": 2}
 * [4, 1, 3, 2, 2, 2, 2, 2]
 */

public class MoveElementsToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        if(array.size()==0){
            return new ArrayList<Integer>();
        }
        int leftIdx = 0;
        int rightIdx = leastRightIndex(array, toMove, array.size()-1);
        while(leftIdx<rightIdx) {
            if(array.get(leftIdx)==toMove){
                Collections.swap(array,leftIdx,rightIdx);
                rightIdx = leastRightIndex(array, toMove, rightIdx-1);
            }
            leftIdx++;
        }
        return array;
    }

    public static int leastRightIndex(List<Integer> array, int toMove, int startIdx){
        for(int i=startIdx; i!=0;i--){
            if(array.get(i)!=toMove){
                return i;
            }
        }
        return 0;
    }
}
