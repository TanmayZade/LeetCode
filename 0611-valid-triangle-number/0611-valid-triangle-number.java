class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length, count = 0;
        if(n < 3) return 0;
        Arrays.sort(nums);

        for(int i = n-1;i >= 2;i--){
            int left = 0, right = i-1;

            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    right--;
                }else{
                    left++;
                }
            }
        }

        return count;
    }
}