import java.util.HashMap;

/**
 * Difficulty - Easy
 * Input = Array of integers and targetSum
 * Output = Return an array of two numbers that are present in the array whose sum is equal to the targetSum     *
 */


public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.

        //a+b = c
        //we iterate over the array once. we know a,c
        int length = array.length;
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        for(int i=0;i<length;i++) {
            int valueEle = targetSum - array[i];
            //we form a hashmap that find out b for every a
            targetMap.put(array[i], valueEle);
        }

        //we iterate again, but this time, we search for b in the hashmap
        for(int i=0;i<length;i++) {
            int valueEle = targetMap.get(array[i]);
            if(array[i]!=valueEle && targetMap.containsKey(valueEle)){
                return new int[]{valueEle, targetMap.get(valueEle)};
            }
        }


        return new int[0];
    }
}
