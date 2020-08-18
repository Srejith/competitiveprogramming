import java.util.ArrayList;
import java.util.List;

/**
 * Problem's sample input
 * [1,3,5] -> [1,3,6]
 * [1,0,9] -> [1,1,0]
 * [1,9,9] -> [2,0,0]
 */

public class PlusOne {

    public static void main(String[] arg) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(5);
        plusOne(array);
    }


    public static List<Integer> plusOne(List<Integer> array) {

        int b = array.get(array.size()-1);

        if(b==9) {
            if(array.size()==1) {
                //if array size == 1, special handling for msb
                array = new ArrayList<>();
                array.add(0);
                array.add(1);
            }
            else{
                array = plusOne(array.subList(0, array.size()-2));
                array.add(0);
            }
        }else{
            //increment b and concat the array
            array.set(array.size()-1, ++b);
        }
        return array;
    }

}
