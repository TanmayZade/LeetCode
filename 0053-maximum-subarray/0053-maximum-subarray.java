class Solution {
    public int maxSubArray(int[] nums) {
    //bruteforce for O(n3)
    //using prefix O(n2)
    //using kadane's algorithm
    int n = nums.length;
    if(n == 1) return nums[0];
    int result = 0;
    int cs = 0;
    int ms = Integer.MIN_VALUE;

    for(int i = 0;i < nums.length;i++){
        cs += nums[i];
        ms = Math.max(cs,ms);

        if(cs < 0)
            cs = 0;
        
    }
    return ms;

    }
}