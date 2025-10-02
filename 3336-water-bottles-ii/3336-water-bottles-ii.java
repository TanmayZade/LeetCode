class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunkB = numBottles;
        int emptyB = numBottles;
        numBottles = 0;
        while(emptyB >= numExchange){
            emptyB -= numExchange;
            numExchange++;
            emptyB++;
            drunkB++;
        }
        // drunkB += emptyB;

        return drunkB;
    }
}