class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int max = numBottles;  // you drink all initial bottles
        
        int empty = numBottles; // after drinking, all are empty
        while (empty >= numExchange) {
            int newBottles = empty / numExchange; // how many new full bottles
            max += newBottles; // you drink them
            
            empty = newBottles + (empty % numExchange); // new empties + leftovers
        }
        
        return max;
    }
}
