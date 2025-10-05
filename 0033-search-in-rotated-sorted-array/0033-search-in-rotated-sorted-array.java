class Solution {
    public int search(int[] nums, int target) {
        return searchTar(nums, target, 0, nums.length-1);
    }

    private int searchTar(int[] nums,int target, int si, int ei){
            if(si > ei) return -1;
            int mid = si + (ei - si)/2;
            if(nums[mid]== target) return mid;
            if(nums[si] <= nums[mid]){
                if(nums[si] <= target && target <= nums[mid])
                    return searchTar(nums, target,si, mid-1);
                else
                    return searchTar(nums, target, mid+1, ei);
            }else{
                if(nums[mid] <= target && target <= nums[ei])
                    return searchTar(nums, target,mid + 1, ei);
                else
                    return searchTar(nums, target,si, mid-1);
            }
    }
}