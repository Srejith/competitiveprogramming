/**
 * Difficulty Level - Easy
 * Implement Binary Search algorithm
 * O(logn) TS
 */

public class BinarySearch {
    public static int binarySearch(int[] array, int leftIdx, int rightIdx, int target) {
        int result = -1;
        if(leftIdx<=rightIdx) {
            int middleIdx = (leftIdx+rightIdx)/2;
            System.out.println(leftIdx+","+rightIdx+","+middleIdx+","+array[middleIdx]);
            if(array[middleIdx]>target){
                //left
                result = binarySearch(array, leftIdx, middleIdx-1, target);
            }else if(array[middleIdx]<target) {
                //right
                result = binarySearch(array, middleIdx+1, rightIdx, target);
            }else{
                return middleIdx;
            }
        }
        return result;
    }


    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int leftIdx = 0;
        int rightIdx = array.length-1;
        return binarySearch(array, leftIdx, rightIdx, target);
    }
}
