import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Difficulty level - Medium
 *
 * Return the longest palindromic substring
 *
 * i/p: abaxyzzyxf
 * o/p: xyzzyx
 *
 * The logic below is an optimization of O(n3).
 * It can be done in a better manner - o(n2) where we change the palindrome is checked.
 *
 * Palindrome can be even or odd.
 * Even is where ab|ba
 * Odd is abb|c|bba
 *
 * so, we treat each character in the string as the middle portion of the palindrome and check for it, instead of forming substrings and checking repeatedly *
 */

public class LongestPalindromeSubString {
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        String result = "";
        if(str.length()==1){
            return str;
        }else{
            HashMap<Character, List<Integer>> alphaCount = new HashMap<>();

            for(int i=0; i<str.length(); i++){
                List<Integer> list = new ArrayList<>();
                if(alphaCount.containsKey(str.charAt(i))){
                    list = alphaCount.get(str.charAt(i));
                }
                list.add(i);
                alphaCount.put(str.charAt(i), list);
            }
            for(Map.Entry<Character, List<Integer>> map: alphaCount.entrySet()){
                Character alpha = map.getKey();
                List<Integer> index = map.getValue();
                if(index.size()>1){
                    for(int i=0;i<index.size();i++){
                        for(int j=i+1;j<index.size();j++){
                            if(checkPalin(str, index.get(i), index.get(j))){
                                String localResult = str.substring(index.get(i), index.get(j)+1);
                                System.out.println("Local "+localResult);
                                if(localResult.length()>result.length()){
                                    result = localResult;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Boolean checkPalin(String str, int start, int end){
        System.out.println(str.substring(start,end+1)+","+start+","+end);
        for(int i=start, j=end; i<=j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
