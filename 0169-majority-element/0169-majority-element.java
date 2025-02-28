class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        if(n == 1)
            return nums[0];
        Arrays.sort(nums);
        return nums[n/2];
    }
}