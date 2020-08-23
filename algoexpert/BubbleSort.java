/**
 * Difficult level - Easy
 * Implement Bubble Sort mechanism
 *
 * We peform a small optimization by setting a flag variable to sorted = true if and only if no swaps were
 * taken place during the sub-iteration. This might eliminate already sorted or partially sorted arrays.
 */

public class BubbleSort {
    public static int[] bubbleSort(int[] a) {
        // Write your code here.
        int n = a.length;
        boolean sorted = false;
        int i = 0;
        while(!sorted){
            sorted = true;
            for(int j=0; j<n-i-1;j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    sorted = false;
                }
            }
            i++;
        }
        return a;
    }
}
