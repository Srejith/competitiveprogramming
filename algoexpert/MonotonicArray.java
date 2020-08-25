/**
 * Difficulty - Medium
 *
 * Return boolean if array is monotonic.
 * An array is monotonic if its elements from left to right are entirely non-increasing or entirely non-decreasing
 * {"array": [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]}
 * true
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        Boolean result = true;

        if(array.length==0 || array.length==1){
            return result;
        }

        int flag = 0;

        //0 - equal
        //1 - descending
        //2 - increasing

        for(int i = 0; i< array.length-1; i++){

            int a = array[i];
            int b = array[i+1];
            if(a<b){
                if(flag==0){
                    flag=1;
                }else if(flag==2){
                    result = false;
                    break;
                }
            }else if(a>b) {
                if(flag==0){
                    flag=2;
                }else if(flag==1){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
