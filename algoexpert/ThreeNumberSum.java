import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Difficulty level - Medium
 * <p>
 * {"array": [12, 3, 1, 2, -6, 5, -8, 6], "targetSum": 0}
 * [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
 * <p>
 * {"array": [1, 2, 3], "targetSum": 6}
 * [[1, 2, 3]]
 * <p>
 * {"array": [12, 3, 1, 2, -6, 5, 0, -8, -1], "targetSum": 0}
 * [[-8, 3, 5], [-6, 1, 5], [-1, 0, 1]]
 */

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int halfSum = array[i] + array[j];
                int reqdSum = targetSum - halfSum;
                int index = isNumberPresent(reqdSum, array, j + 1);
                if (index != -1) {
                    //number is present
                    Integer[] subResult = {array[i], array[j], array[index]};
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    public static int binarySearch(int[] array, int leftIdx, int rightIdx, int target) {
        int result = -1;
        if (leftIdx <= rightIdx) {
            int middleIdx = (leftIdx + rightIdx) / 2;
            if (array[middleIdx] > target) {
                //left
                result = binarySearch(array, leftIdx, middleIdx - 1, target);
            } else if (array[middleIdx] < target) {
                //right
                result = binarySearch(array, middleIdx + 1, rightIdx, target);
            } else {
                return middleIdx;
            }
        }
        return result;
    }

    //find out if the particular number is present in the array or not - returns the index
    public static int isNumberPresent(int target, int[] array, int startIndex) {
        //binary search - O(logn)
        int leftIdx = startIndex;
        int rightIdx = array.length - 1;
        return binarySearch(array, leftIdx, rightIdx, target);
    }
}