/**
 *
 * Difficult - Medium
 * Function that returns the longest peak in an array
 *
 * A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip after which it is strictly decreasing. 3 integers needed
 * to form a peak.
 *
 * 1 3 10 2 - peak
 * 1 2 2 0 - not a peak
 * 1 2 3 - not a peak
 *
 * i/p - 1 2 3 3 4 0 10 6 5 -1 -3 2 3
 * o/p - 0 10 6 5 -1 2 -3
 *
 *
 * Trick - Conventional method is as below - keep track of the direction of the array and do.
 * However, the smart way would be to understand the peak process.
 *
 * Find all the peaks first. Finding a peak is simple - If the left and right number are smaller than the index, then the index is a peak.
 * Now, iterate through the peaks again and traverse in either direction until strictly decreasing property fails. Return the count.
 */
public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.

        int resultPeak = 0;
        int currentPeak = 0;
        int direction = 0; // 0 - ascending; 1 - descending


        for(int i=0; i<array.length; i++) {
            System.out.println("Index: "+i+" Element: "+array[i]);
            if(direction == 0) {
                if(array[i]<array[i+1]){
                    System.out.println("adding to peak(a): "+array[i]);
                    currentPeak++;
                }else if(array[i]>array[i+1]){
                    if(currentPeak>=2) {
                        System.out.println("reverse peak: "+array[i]);
                        currentPeak++;
                        direction = 1;
                    }else{
                        System.out.println("reset peak: "+array[i]);
                        currentPeak = 0;
                        direction = 0;
                    }
                }else{
                    //reset of the peaks
                    System.out.println("reset peak: "+array[i]);
                    currentPeak = 0;
                    direction = 0;
                }
            }else{
                //direction is descending
                if(array[i]>array[i+1]){
                    System.out.println("adding to peak(d): "+array[i]);
                    currentPeak++;
                }else{
                    //validate add to result array
                    System.out.println("peak ended: "+array[i]);
                    if(currentPeak>resultPeak){
                        System.out.println("new result peak");
                        resultPeak = currentPeak;
                    }
                    //reset of the peaks
                    i=i-2;
                    currentPeak = 0;
                    direction = 0;
                }
            }
        }
        return resultPeak;
    }
}
