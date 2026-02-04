class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int mEle = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(cnt == 0){
                mEle = nums[i];
            }
            if(nums[i] == mEle ){
                cnt++;
            }else cnt--;
        }
        return mEle;
    }
}