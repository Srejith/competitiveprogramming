/**
 * Difficulty - Easy
 * Find the largest 3 numbers in array and send them in sorted manner, without sorting the full array
 */

public class ThreeLargestNos {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.

        //l1 - greatest
        //l2 - second greatest
        //l3 - third greatest

        Integer l1 = Integer.MIN_VALUE;
        Integer l2 = Integer.MIN_VALUE;
        Integer l3 = Integer.MIN_VALUE;

        for (int i=0;i<array.length; i++) {
            if(array[i]>l1){
                l3 = l2;
                l2 = l1;
                l1 = array[i];
            }else if(array[i]>l2) {
                l3 = l2;
                l2 = array[i];
            }else if(array[i]>l3){
                l3 = array[i];
            }
        }
        return new int[]{l3,l2,l1};
    }
}
