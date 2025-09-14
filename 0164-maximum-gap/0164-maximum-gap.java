class Solution {
    public int maximumGap(int[] nums) {
        int maxDiff = 0;
        Arrays.sort(nums);
        for(int i = 1;i < nums.length;i++) maxDiff = Math.max(maxDiff, nums[i]-nums[i-1]);
        return maxDiff;
    }
}