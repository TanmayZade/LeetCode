class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums,k) - atMostKDistinct(nums, k-1);
    }

    private int atMostKDistinct(int[] nums, int k){
        int left = 0;
        int cnt = 0, distinct = 0;
        int[] freq = new int[nums.length + 1];

        for(int right = 0;right < nums.length;right++){
            int num = nums[right];

            if(freq[num] == 0){
                distinct++;
            }

            freq[num]++;

            while(distinct > k){
                int leftNum = nums[left];
                freq[leftNum]--;
                if(freq[leftNum] == 0) distinct--;
                left++;
            }

            cnt += right - left + 1;
        }

        return cnt;
    }
}