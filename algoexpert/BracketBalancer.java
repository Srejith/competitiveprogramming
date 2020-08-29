import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Difficulty - Medium
 *
 * Find balanced and unbalanced brackets from the string
 */

public class BracketBalancer {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        HashMap<Character, Character> matchMap = new HashMap<>();
        matchMap.put(')', '(');
        matchMap.put(']', '[');
        matchMap.put('}', '{');
        List<Character> charStack = new ArrayList<>();

        for(int i=0; i<str.length(); i++) {
            if((str.charAt(i))=='('){
                charStack.add(str.charAt(i));
            }else if((str.charAt(i))=='{'){
                charStack.add(str.charAt(i));
            } else if((str.charAt(i))=='['){
                charStack.add(str.charAt(i));
            } else if(str.charAt(i) == ')' ||str.charAt(i) == '}' || str.charAt(i) == ']'){
                if(charStack.size()>0){
                    Character ch = charStack.get(charStack.size()-1);
                    Character mapCh = matchMap.get(str.charAt(i));
                    if(ch == mapCh) {
                        charStack.remove(charStack.size()-1);
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(charStack.size()==0){
            return true;
        }
        return false;
    }
}
