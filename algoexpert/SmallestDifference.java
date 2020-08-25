import java.util.Arrays;

/**
 * Difficulty level - Medium
 *
 * Function that takes tow arrays, and find the pair of numbers whose absolute difference is closest to zero
 * {"arrayOne": [-1, 5, 10, 20, 28, 3], "arrayTwo": [26, 134, 135, 15, 17]}
 * [28,26]
 *
 *
 */

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int firstEle;
        int secondEle;
        if(arrayOne[arrayOne.length-1] > arrayTwo[arrayTwo.length-1]){
            secondEle = arrayTwo[arrayTwo.length-1];
            firstEle = findSmallerDiff(secondEle, arrayOne);
        }else{
            firstEle = arrayOne[arrayOne.length-1];
            secondEle = findSmallerDiff(firstEle, arrayTwo);
        }
        return new int[] {firstEle, secondEle};
    }

    public static int findSmallerDiff(int target, int[] array) {

        int left = 0;
        int right = array.length-1;
        int middle=(left+right)/2;
        while(left!=right-1){
            middle = (left+right)/2;
            System.out.println(left+","+right+","+middle);
            if(Math.abs(array[middle-1]-target)<Math.abs(array[middle+1]-target)){
                right = middle;
            }else if(Math.abs(array[middle-1]-target)>Math.abs(array[middle+1]-target)) {
                left = middle;
            }else{
                return array[middle];
            }
        }
        System.out.println(left+","+right+","+middle);
        if(Math.abs(array[left]-target)>Math.abs(array[right]-target)){
            return array[right];
        }else{
            return array[left];
        }
    }
}
