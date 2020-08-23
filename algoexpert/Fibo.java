import java.util.ArrayList;

/**
 * Fibonocci series. Return the nth fibo number
 */

public class Fibo {
    public static int getNthFib(int n) {
        int f0 = 0;
        int f1 = 1;
        int sum = 1;
        ArrayList<Integer> a = new ArrayList<>();
        if (n==1)
            return f0;
        else if(n==2)
            return f1;
        else if(n>2){
            for (int i = 2; i<n; i++) {
                sum = f0 + f1;
                f0 = f1;
                f1 = sum;
            }
        }
        return sum;
    }
}
