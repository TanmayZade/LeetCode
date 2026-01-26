class Solution {
    public int search(int[] nums, int target) {
        return searchTarget(nums, target, 0, nums.length-1);
    }

    private int searchTarget(int[] nums, int target, int si, int ei){
        if(si > ei) return -1;
        int mid = si + (ei - si)/2;
        if(nums[mid] == target) return mid;
        if(nums[si] <= nums[mid]){
            if(nums[si] <= target && target <= nums[mid])
                return searchTarget(nums, target, si, mid-1);
            else
                return searchTarget(nums, target, mid+1,ei);
        }else{
            if(nums[mid] <= target && target <= nums[ei])
                return searchTarget(nums, target, mid+1, ei);
            else
                return searchTarget(nums, target, si, mid-1);
        }
    }
}