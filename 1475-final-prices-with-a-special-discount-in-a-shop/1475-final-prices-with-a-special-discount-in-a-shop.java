import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[prices.length];
        int n = prices.length;

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until we find a smaller or equal price
            while (!s.isEmpty() && s.peek() > prices[i]) {
                s.pop();
            }
            // If stack is not empty, apply the discount
            if (!s.isEmpty()) {
                result[i] = prices[i] - s.peek();
            } else {
                result[i] = prices[i];
            }
            // Push the current price onto the stack for future comparisons
            s.push(prices[i]);
        }

        return result;
    }
}
