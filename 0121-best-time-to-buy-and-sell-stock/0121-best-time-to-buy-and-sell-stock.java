class Solution {
    public int maxProfit(int[] prices) {
        int result =0;
        int minPrice=Integer.MAX_VALUE;

        for(int i = 0;i < prices.length;i++){
                    int maxPrice = 0;

            if(prices[i] < minPrice)
                minPrice = prices[i];
            else if(prices[i] > maxPrice)
                maxPrice = prices[i];
            int profit = maxPrice - minPrice;
            result = Math.max(result, profit);
        }


        return result;
    }
}