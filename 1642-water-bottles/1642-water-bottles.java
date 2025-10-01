class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int max = numBottles;
        int empty = numBottles;

        while(empty >= numExchange){
            int newBottles = empty / numExchange;
            max += newBottles;

            empty = newBottles + (empty % numExchange);
        }

        return max;
    }
}
