public class SelectionSort {
    public static int[] selectionSort(int[] a) {
        // Write your code here.

        for(int i=0;i<a.length;i++) {
            int smallestIdx = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[smallestIdx]){
                    smallestIdx = j;
                }
            }
            if(smallestIdx!=i) {
                //swap i and smallest
                int temp = a[i];
                a[i] = a[smallestIdx];
                a[smallestIdx] = temp;
            }
        }
        return a;
    }
}

