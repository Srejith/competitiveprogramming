import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Difficult level - Medium
 *
 * Push, pop, peek, Min and max
 * Important criteria: All of the methods should run in constant time
 *
 * So, push, pop and peek can be done in constant time.
 * Max, min can also be done in constant time by maintaining a separate variable.
 * However, the problem would arise when we pop. We will have to traverse through the entire array again to calculate the min and max.
 *
 * So, we maintain a stack of min and max. For every push, we calculate the min and max and put it into a stack.
 */
public class MinMaxStack {

    List<Integer> stack = new ArrayList<>();
    List<HashMap<String, Integer>> minMaxStack = new ArrayList<>();

    public int peek() {
        // Write your code here.
        return stack.get(stack.size() - 1);
    }

    public int pop() {
        // Write your code here.
        HashMap<String, Integer> oldEntry = minMaxStack.remove(minMaxStack.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    public void push(Integer number) {
        // Write your code here.
        HashMap<String, Integer> newEntry = new HashMap<>();
        newEntry.put("min", number);
        newEntry.put("max", number);

        if (minMaxStack.size() > 0) {
            HashMap<String, Integer> oldEntry = minMaxStack.get(minMaxStack.size() - 1);
            Integer oldMin = oldEntry.get("min");
            Integer oldMax = oldEntry.get("max");

            if (oldMin < number) {
                newEntry.put("min", oldMin);
            }
            if (oldMax > number) {
                newEntry.put("max", oldMax);
            }
        }
        minMaxStack.add(newEntry);
        stack.add(number);
    }

    public int getMin() {
        // Write your code here.
        HashMap<String, Integer> oldEntry = minMaxStack.get(minMaxStack.size() - 1);
        return oldEntry.get("min");
    }

    public int getMax() {
        // Write your code here.
        HashMap<String, Integer> oldEntry = minMaxStack.get(minMaxStack.size() - 1);
        return oldEntry.get("max");
    }

}
