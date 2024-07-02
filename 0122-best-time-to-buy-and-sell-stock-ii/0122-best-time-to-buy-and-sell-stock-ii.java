class Solution {
    public int maxProfit(int[] prices) {
        int BuyPrice = Integer.MAX_VALUE;
        int TotalProfit = 0;
        
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i-1])
                TotalProfit += prices[i] - prices[i-1];
        }
        return TotalProfit;
    }
}