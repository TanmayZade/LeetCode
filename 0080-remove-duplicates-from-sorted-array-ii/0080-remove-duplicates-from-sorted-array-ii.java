class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int idx = 2;

        for(int i = 2;i < nums.length;i++){
            if(nums[i] != nums[idx-2]){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}