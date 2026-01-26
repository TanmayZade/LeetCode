class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int m = nums[i];
            int rem  = target - m;

            if(freq.containsKey(rem)) return new int[]{i,freq.get(rem)};

            freq.put(nums[i], i);
        }

        return new int[]{};
    }
}