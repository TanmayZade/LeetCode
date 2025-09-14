class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // int freq[] = new int[n + 2];
        // for(int i = 0;i < n;i++) freq[nums[i]]++;
        // for(int i = 0;i < n+2;i++) if(freq[i] == 0) return i;
        // return 0;
        int sum = n*(n+1)/2;

        int currSum = 0;

        for(int i = 0;i < n;i++) currSum += nums[i];

        return (sum - currSum);
    }
}