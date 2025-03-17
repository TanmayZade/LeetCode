class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxCount = 0;
        int count = 0;
        int k = 0;
        while(k < n){
            if(nums[k] == 1){
                count++;
                maxCount = Math.max(count,maxCount);
            }else{
                count = 0;
            }
            k++;
        }

        return maxCount;

    }
}