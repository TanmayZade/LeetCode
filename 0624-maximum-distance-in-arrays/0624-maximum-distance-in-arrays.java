class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for(int i = 1;i < arrays.size();i++){
            List<Integer> currList = arrays.get(i);
            int currMin = currList.get(0);
            int currMax = currList.get(currList.size() - 1);

            maxDistance = Math.max(maxDistance,Math.abs(currMax - minValue));
            maxDistance = Math.max(maxDistance,Math.abs(maxValue - currMin));

            minValue = Math.min(minValue,currMin);
            maxValue = Math.max(maxValue,currMax);
           
        }

        return maxDistance;
    }
}