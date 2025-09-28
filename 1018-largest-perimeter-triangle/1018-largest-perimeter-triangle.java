//Arrays.sort(nums)
//shoelace formula for area

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = n-1;i >= 2;i--){
            if(isTriangle(nums[i],nums[i-1],nums[i-2]))
                return nums[i] + nums[i-1] + nums[i-2];
        }
        return 0;
    }

    private boolean isTriangle(int s1,int s2,int s3){
        if(s1 + s2 <= s3) return false;
        if(s2 + s3 <= s1) return false;
        if(s3 + s1 <= s2) return false;
        return true;
    }
}

