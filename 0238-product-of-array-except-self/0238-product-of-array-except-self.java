class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int currProd = 1;
        Arrays.fill(ans,1);
        for(int i=0;i < n;i++){
            ans[i] *= currProd;
            currProd *= nums[i];
        }
        currProd = 1;
        for(int i = n-1;i >= 0;i--){
            ans[i] *= currProd;
            currProd *= nums[i];
        }

        return ans;
    }
}