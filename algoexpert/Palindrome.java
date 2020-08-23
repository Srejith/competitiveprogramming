/**
 * Difficulty - Easy
 * Palindrome
 */

public class Palindrome {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        boolean isPalin = true;
        if(str.length() != 1){
            int i =0;
            int j = str.length()-1;
            for(;i<j;i++,j--){
                if(str.charAt(i)!=str.charAt(j)){
                    isPalin = false;
                    break;
                }
            }
            char[] result = new char[4];
            result[i] = 'a';
        }
        return isPalin;
    }
}
