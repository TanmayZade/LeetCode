class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = nums[0];
        int right = nums[n-1];

        while(left != 0 && right != 0){
            if(left < right){
                right -= left;
            }else{
                left -= right;
            }
        }
        if(left == 0) return right;
        else return left;
    }
}