class Solution {
    public int[] productExceptSelf(int[] nums) {
        int currProd = 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);

        for(int i = 0;i < nums.length;i++){
            ans[i] *= currProd;
            currProd *= nums[i];
        }

        currProd = 1;
        for(int i = nums.length-1;i >= 0;i--){
            ans[i] *= currProd;
            currProd *= nums[i];
        }
        return ans;
    }
}