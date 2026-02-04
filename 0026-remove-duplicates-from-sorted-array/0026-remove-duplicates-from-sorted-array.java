class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[idx] != nums[j]){
                nums[++idx] = nums[j++];
            }else j++;
        }
        return ++idx;
    }
}