import java.util.List;

/**
 * Difficulty - Easy
 * Input: Array of integers and sequence
 * Output: Boolean. True is the sequence is present in the array as sub-sequence in the same order but not necessarily adjacent.
 * False otherwise.
 *
 */

public class SubSequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        int arrIdx = 0;
        int seqIdx = 0;

        while(arrIdx<array.size() && seqIdx < sequence.size()) {
            if(array.get(arrIdx++) == sequence.get(seqIdx)){
                seqIdx++;
            }
        }

        return sequence.size() == seqIdx;
    }
}
