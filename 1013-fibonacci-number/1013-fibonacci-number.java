import java.util.*;

class Solution {
    HashMap<Integer, Integer> hm  = new HashMap<>();
    public int fib(int n) {
        if(n <= 1) return n;
        int lastDigit = n-1;
        if(!hm.containsKey(n-1)){
            int lastDSum = fib(n-1);
            hm.put(lastDigit, lastDSum);
        }
            int lastSecondDigit = n-2;        
        if(!hm.containsKey(lastSecondDigit)){
            int lastSSecondDigit = fib(n-2);
            hm.put(lastSecondDigit, lastSSecondDigit);
        }
        return hm.get(lastDigit) + hm.get(lastSecondDigit);
    }


}