class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int cnt = 0, currSum = 0;
        for(int i = 0;i < nums.length;i++){
            currSum += nums[i];
            if(currSum == k) cnt++;
            int rem = currSum - k;
            if(preSumMap.containsKey(rem)){
                cnt += preSumMap.get(rem);
            }

            preSumMap.put(currSum,preSumMap.getOrDefault(currSum,0)+1);
        }
        return cnt;

    }
}