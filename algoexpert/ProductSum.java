import java.util.ArrayList;
import java.util.List;

/**
 * Difficulty - Easy
 * [x, [y, [z]]] = x + 2 * (y+3z)
 */

public class ProductSum {
    public static Integer innerSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object obj: array) {
            if(obj instanceof ArrayList){

                sum+= innerSum((List<Object>)obj,depth+1) * (depth+1);
            }else{
                sum += (int) obj;
            }
        }
        return sum;
    }

    public static int productSum(List<Object> array) {
        // Write your code here.
        return innerSum(array, 1);
    }
}
